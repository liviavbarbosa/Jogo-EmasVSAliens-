package jogoaliesvsemas;
/**
 * Classe que representa uma matriz com seus atributos e métodos.
 * 
 * @author Lívia Barbosa e Eduarda Sauceda
 */
public class Matriz {
    private char matriz[][] = new char[5][4];
    /**
     * Mostra a matriz inicial do jogo.
     */
    public void matrizInicial(){
        for(int i = 0; i <= 1; i++){
            for(int j = 0; j <= 3; j++){
                matriz[i][j] = 'E';
            }
        }
        for(int i = 2; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                matriz[i][j] = '.';
            }
        }
        matriz[4][0] = '.';
        matriz[4][1] = 'A';
        matriz[4][2] = 'A';
        matriz[4][3] = '.';
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(matriz[i][j]);  
            }
            System.out.println("");
        }
    }
    /**
     * Mostra o estado atual da matriz, após as modificações
     * feitas durante o jogo.
     */
    public void estadoMatriz(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(matriz[i][j]);  
            }
            System.out.println("");
        }
    }
    /**
     * Devolve o valor da matriz.
     *
     * @param linha linha da matriz
     * @param coluna coluna da matriz
     * @return matriz
     */
    public char getMatriz(int linha, int coluna){
        return matriz[linha][coluna];
    }
    /**
     * Atribui um valor na matriz.
     *
     * @param linha linha da matriz
     * @param coluna coluna da matriz
     * @param valor valor a atribuir a uma posição da matriz
     */
    public void setMatriz(int linha, int coluna, char valor){
        matriz[linha][coluna] = valor;
    }
    /**
     * Verifica se a posição informada pelo jogador 
     * está desocupada.
     * 
     * @param linha linha da matriz
     * @param coluna coluna da matriz
     * @param matriz matriz do jogo
     * @return true ou false
     */
    public static boolean isDesocupado(int linha, int coluna, Matriz matriz){
        return (matriz.getMatriz(linha, coluna)== '.');
    }
     public String estadoMatrizArquivo(int jogador){
         String dado = "" + jogador + "\n";
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                dado+=(matriz[i][j]);  
            }
            dado+=("\n");
        }
        return dado;
    }
}


