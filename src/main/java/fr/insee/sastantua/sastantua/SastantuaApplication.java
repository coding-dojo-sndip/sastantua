package fr.insee.sastantua.sastantua;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * SastantuaApplication
 */
public class SastantuaApplication {

	public static String exec(int niveau) {
		List<List<String>> pyramide = new ArrayList<>();
		int tailleLigne = 3;
		int tailleEpaules = 3;
		int tailleEtage = 3;
		for (int i = 0; i < niveau; i++) {
			List<String> etage = genererEtage(tailleLigne, tailleEtage);
			pyramide.add(etage);
			tailleEtage++;
			tailleLigne = etage.get(etage.size() - 1).length() + 2 * tailleEpaules;
			tailleEpaules = tailleEpaules + i % 2;
		}
		List<String> dernierEtage = pyramide.get(pyramide.size() - 1);
		int tailleBasePyramide = dernierEtage.get(dernierEtage.size() - 1).length();
		ouvrirPorte(dernierEtage);
		return pyramide.stream().flatMap(etage -> etage.stream()).map(ligne -> ligneCentree(ligne, tailleBasePyramide))
				.collect(Collectors.joining("\n")) + "\n";
	}

	public static void main(String[] args) {
		System.out.println(exec(6));
	}
	// public static void genererLignes(int nbNiveaux) {

	// int tailleEpaules = 2;
	// int hauteurEtage = 3;

	// List<String> listeLignes = new ArrayList<>();

	// while (true) {
	// listeLignes.add(ligneNonCentre(tailleLigneCourante));

	// }
	// }

	public static List<String> genererEtage(int taillePremiereLigne, int hauteurEtage) {
		List<String> listeLignes = new ArrayList<>();
		int tailleLigneCourante = taillePremiereLigne;
		for (int i = 0; i < hauteurEtage; i++) {
			listeLignes.add(ligneNonCentre(tailleLigneCourante));
			tailleLigneCourante += 2;
		}
		return listeLignes;
	}

	public static String ligneNonCentre(int taille) {
		return "/" + "*".repeat(taille - 2) + "\\";
	}

	public static String ligneCentree(String ligneNonCentree, int espaceTotal) {
		int tailleLNC = ligneNonCentree.length();
		int tailleEspace = (espaceTotal - tailleLNC) / 2;
		return " ".repeat(tailleEspace) + ligneNonCentree;
	}

	public static void ouvrirPorte(List<String> dernierEtage) {
		int hauteurPorte = (dernierEtage.size() - 3) + (dernierEtage.size() % 2);
		for (int i = dernierEtage.size() - hauteurPorte; i < dernierEtage.size(); i++) {
			String ligne = dernierEtage.get(i);
			char[] tabLigne = ligne.toCharArray();
			int tailleLigne = tabLigne.length;
			int debutPorte = (tailleLigne - hauteurPorte) / 2;
			for (int j = 0; j < hauteurPorte; j++) {
				tabLigne[debutPorte + j] = '|';
			}
			if (hauteurPorte >= 5 && i == dernierEtage.size() - ((hauteurPorte + 1) / 2)) {
				tabLigne[debutPorte + hauteurPorte - 2] = '$';
			}
			dernierEtage.set(i, String.valueOf(tabLigne));
		}
	}
}
