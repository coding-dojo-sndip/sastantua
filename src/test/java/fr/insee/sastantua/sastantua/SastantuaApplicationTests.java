package fr.insee.sastantua.sastantua;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * InnerSastantuaApplicationTests
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Unit test for simple App.
 */
public class SastantuaApplicationTests {

    @Autowired
    SastantuaApplication sastantua;

    @ParameterizedTest
    @ValueSource(ints = { -1 })
    public void shouldAnswerWithTrue(int niveau) throws IOException, InterruptedException {
        assertEquals(sastantua.exec(niveau), execSastantua(niveau));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0 })
    public void shouldAnswerWithTrue2(int niveau) throws IOException, InterruptedException {
        assertEquals(sastantua.exec(niveau), execSastantua(niveau));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    public void shouldAnswerWithTrue3(int niveau) throws IOException, InterruptedException {
        assertEquals(sastantua.exec(niveau), execSastantua(niveau));
    }

    @ParameterizedTest
    @ValueSource(ints = { 2 })
    public void shouldAnswerWithTrue4(int niveau) throws IOException, InterruptedException {
        assertEquals(sastantua.exec(niveau), execSastantua(niveau));
    }

    @ParameterizedTest
    @ValueSource(ints = { 3 })
    public void shouldAnswerWithTrue5(int niveau) throws IOException, InterruptedException {
        assertEquals(sastantua.exec(niveau), execSastantua(niveau));
    }

    @ParameterizedTest
    @ValueSource(ints = { 5 })
    public void shouldAnswerWithTrue6(int niveau) throws IOException, InterruptedException {
        assertEquals(sastantua.exec(niveau), execSastantua(niveau));
    }

    @ParameterizedTest
    @ValueSource(ints = { 6 })
    public void shouldAnswerWithTrue7(int niveau) throws IOException, InterruptedException {
        assertEquals(sastantua.exec(niveau), execSastantua(niveau));
    }

    @ParameterizedTest
    @ValueSource(ints = { 7 })
    public void shouldAnswerWithTrue8(int niveau) throws IOException, InterruptedException {
        assertEquals(sastantua.exec(niveau), execSastantua(niveau));
    }

    @ParameterizedTest
     @ValueSource(ints = { 51 })
    public void shouldAnswerWithTrue9(int niveau) throws IOException,
     InterruptedException {
     assertEquals(sastantua.exec(niveau), execSastantua(niveau));
     }

    private String execSastantua(int niveau) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();

        String[] commands = { "src/test/resources/sastantua", String.valueOf(niveau) };

        Process proc = rt.exec(commands);

        InputStream stdIn = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(stdIn);
        BufferedReader br = new BufferedReader(isr);

        StringBuffer lines = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null)
            lines.append(line + "\n");
        // proc.waitFor();
        return lines.toString();
    }

}
