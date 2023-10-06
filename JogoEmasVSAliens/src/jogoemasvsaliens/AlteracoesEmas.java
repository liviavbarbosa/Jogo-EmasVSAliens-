package jogoaliesvsemas;
/**
 * Classe que representa as Emas com seus métodos.
 * 
 * @author Lívia Barbosa e Eduarda Sauceda
 */
public class AlteracoesEmas {
    //static char matriz[][] = new char[5][4];
    /**
     * Verifica se a posição é válida e se há 
     * uma ema nela.
     * 
     * @param linha linha da matriz
     * @param coluna coluna da matriz
     * @param matriz matriz do jogo
     * @return true ou false
     */
    public static boolean posicaoValidaEma(int linha, int coluna, Matriz matriz){
        return(linha <5 && coluna <4 && linha >= 0 && coluna >= 0 && matriz.getMatriz(linha, coluna)=='E');
    }
     /**
     * Verifica se a ema pode se movimentar para cima, para baixo, para o
     * lado esquerdo e para o lado direito, substituindo espaços vazios
     * pela ema.
     * 
     * @param linhaOrigem linha da matriz de partida da ema
     * @param colunaOrigem coluna da matriz de partida da ema
     * @param linhaDestino linha da matriz de chegada da ema
     * @param colunaDestino coluna da matriz de chegada da ema
     * @param matriz matriz do jogo
     * @return true ou false
     */
    public static boolean movimentoEma(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, Matriz matriz){
        if((linhaDestino == linhaOrigem - 1) && (colunaDestino == colunaOrigem) 
                && (linhaDestino >= 0)){
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'E');
            return true;
        } else if((linhaDestino == linhaOrigem + 1) && (colunaDestino == colunaOrigem
                && (linhaDestino <= 4))){ 
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'E');
            return true;
        } else if((colunaDestino == colunaOrigem - 1) && (linhaDestino == linhaOrigem) 
                && (colunaDestino >= 0)) {
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'E');
            return true;   
        } else if((colunaDestino == colunaOrigem + 1) && (linhaDestino == linhaOrigem)
                && (colunaDestino <= 3)){
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'E');
            return true; 
        } else {
            return false;
        } 
    }
    /**
     * Faz um mapeamento e analisa as posições dos aliens dentro
     * da matriz, dando a vitória às emas se os dois aliens 
     * estiverem totalmente cercados por emas.
     * 
     * @param matriz matriz do jogo
     * @return true ou false
     */
    public static boolean vitoriaEma(Matriz matriz){
        int quantiaDeAliensImoveis = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                // Procura os aliens dentro da matriz
                if (matriz.getMatriz(i, j)=='A'){
                    // Verifica se o alien está no meio da matriz para analisar se os 4 espaços em volta dele estão livres
                    if((i == 1 || i == 2 || i == 3) && (j == 1 || j == 2)
                            && (i - 1 == 'E' || i - 1 == 'A') && (i + 1 == 'E' || i + 1 == 'A') 
                            && (j - 1 == 'E' || j - 1 == 'A') && (j + 1 == 'E' || j + 1 == 'A')){
                        quantiaDeAliensImoveis++;
                    // Verifica se o alien está na coluna 0 para analisar se os espaços em cima, embaixo e ao lado direito dele estão livres
                    } else if((i == 1 || i == 2 || i == 3) && (j == 0)
                            && (i - 1 == 'E' || i - 1 == 'A') && (i + 1 == 'E' || i + 1 == 'A')
                            && (j + 1 == 'E' || j + 1 == 'A')){
                        quantiaDeAliensImoveis++;
                    // Verifica se o alien está na coluna 3 para analisar se os espaços em cima, embaixo e ao lado esquerdo dele estão livres
                    } else if ((i == 1 || i == 2 || i == 3) && (j == 3)
                            && (i - 1 == 'E' || i - 1 == 'A') && (i + 1 == 'E' || i + 1 == 'A') 
                            && (j - 1 == 'E' || j - 1 == 'A')){
                        quantiaDeAliensImoveis++;
                    // Verifica se o alien está na linha 0 para analisar se os espaços ao lado e embaixo dele estão livres 
                    } else if((i == 0) && (j == 1 || j == 2)
                            && (i + 1 == 'E' || i + 1 == 'A') && (j - 1 == 'E' || j - 1 == 'A') 
                            && (j + 1 == 'E' || j + 1 == 'A')){
                        quantiaDeAliensImoveis++;
                    // Verifica se o alien está na linha 4 para analisar se os espaços ao lado e em cima dele estão livres 
                    } else if((i == 4) && (j == 1 || j == 2)
                            && (i - 1 == 'E' || i - 1 == 'A') && (j - 1 == 'E'|| j - 1 == 'A') 
                            && (j + 1 == 'E' || j + 1 == 'A')){
                        quantiaDeAliensImoveis ++;
                    // Verifica se o alien está no canto 0x0 para analisar se os espaços embaixo e ao lado direito dele estão livres 
                    } else if((i == 0) && (j == 0) 
                            && (i + 1 == 'E' || i + 1 == 'A') && (j + 1 == 'E' || j + 1 == 'A')){
                        quantiaDeAliensImoveis++;
                    // Verifica se o alien está no canto 0x3 para analisar se os espaços embaixo e ao lado esquerdo dele estão livres 
                    } else if((i == 0) && (j == 3)
                            && (i + 1 == 'E' || i + 1 == 'A') && (j - 1 == 'E' || j - 1 == 'A')){
                        quantiaDeAliensImoveis ++;
                    // Verifica se o alien está no canto 4x0 para analisar se os espaços em cima e ao lado direito dele estão livres
                    } else if((i == 4) && (j == 0)
                            && (i - 1 == 'E' || i - 1 == 'A') && (j + 1 == 'E' || j + 1 == 'A')){
                        quantiaDeAliensImoveis++;
                    // Verifica se o alien está no canto 4x3 para analisar se os espaços em cima e ao lado esquerdo dele estão livres
                    } else if ((i == 4) && (j == 3)
                            && (i - 1 == 'E' || i - 1 == 'A') && (j - 1 == 'E'|| j - 1 == 'A')){
                        quantiaDeAliensImoveis++;
                    }
                }
            }
        }
        // Verifica se os 2 aliens estão cercados por emas
        if(quantiaDeAliensImoveis == 2){
            return true;
        } else {
            return false;
        }
    }
}
