package jogoaliesvsemas;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Arquivo {
    public static void gravar(String conteudo, String jogoaliensvsemas) throws IOException {
        File file = new File(jogoaliensvsemas);
        FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8);
        BufferedWriter buffer = new BufferedWriter(writer);
        //escreve no arquivo
        buffer.write(conteudo);
        // fecha arquivo
        buffer.close();
        writer.close();
    }
    public static String[] getLinhas(String jogoaliensvsemas) throws Exception {
        // declaração das variáveis
        String[] linhas;
        String linha;
        String conteudo = "";
        int i = 0;
        //abre o arquivo para leitura
        File file = new File(jogoaliensvsemas);
        FileReader reader = new FileReader(file, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(reader);
        //lê a primeira linha do arquivo
        linha = buffer.readLine();
        linhas = new String[5];
        //lê as demais linhas do arquivo
        do{
            linha = buffer.readLine();
            if(linha != null){
                linhas[i++] = linha;
            }
        } while(linha != null);

        //fecha o arquivo
        buffer.close();
        reader.close();
        return linhas;
    }
    public static char recuperarJogada(String jogoaliensvsemas) throws IOException {
        File file = new File(jogoaliensvsemas);
        FileReader reader = new FileReader(file, StandardCharsets.UTF_8);
        char[] jogada = new char[1];
        char j = ' ';
        reader.read(jogada);
        for (char c : jogada){
            j = c;
        }
        return j;
    }
}
    
