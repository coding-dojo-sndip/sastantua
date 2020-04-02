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
		List<String> pyramide = new ArrayList<>();
		for (int i = 0; i < niveau; i++) {
			pyramide.addAll(genererEtage(3, 3));
		}
		pyramide.set(pyramide.size() - 1, ouvrirPorte(pyramide.get(pyramide.size() - 1)));
		int taillePyramide = pyramide.get(pyramide.size() - 1).length();
		return pyramide.stream().map(ligne -> ligneCentree(ligne, taillePyramide)).collect(Collectors.joining("\n"))
				+ "\n";
	}

	public static void main(String[] args) {
		System.out.println(exec(1));
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

	public static String ouvrirPorte(String derniereLigne) {
		char[] tabderniereligne = derniereLigne.toCharArray();
		int tailleLigne = tabderniereligne.length;
		tabderniereligne[tailleLigne / 2] = '|';
		return String.valueOf(tabderniereligne);
	}
}
