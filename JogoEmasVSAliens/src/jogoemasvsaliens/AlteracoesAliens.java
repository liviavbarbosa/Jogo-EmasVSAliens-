package jogoaliesvsemas;
/**
 * Classe que representa os Aliens com seus métodos.
 * 
 * @author Lívia Barbosa e Eduarda Sauceda
 */
public class AlteracoesAliens {
   // static char matriz[][] = new char[5][4];
    /**
     * Verifica se a posição é válida e se há 
     * um alien nela.
     * 
     * @param linha linha da matriz
     * @param coluna coluna da matriz
     * @param matriz matriz do jogo
     * @return true ou false
     */
    public static boolean posicaoValidaAlien(int linha, int coluna, Matriz matriz){
        return (linha < 5 && linha >= 0 && coluna < 4 && coluna >= 0 && matriz.getMatriz(linha, coluna)=='A');
    }
    /**
     * Verifica se há alguma ema a dois espaços de distância do alien,
     * para analisar se ele pode efetuar a captura.
     * 
     * @param linhaOrigem linha da matriz de partida do alien
     * @param colunaOrigem coluna da matriz de partida do alien
     * @param linhaDestino linha da matriz de chegada do alien
     * @param colunaDestino coluna da matriz de chegada do alien
     * @param matriz matriz do jogo
     * @return true ou false
     */
    public static boolean verificacaoDeAtaque(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, Matriz matriz){
        if((linhaDestino == linhaOrigem - 2) && (colunaDestino == colunaOrigem) && (linhaDestino >= 0) 
                && (matriz.getMatriz(linhaDestino, colunaDestino) == 'E') 
                && (matriz.getMatriz(linhaOrigem - 1, colunaOrigem) == '.')){
            return true;
        } else if((linhaDestino == linhaOrigem + 2) && (colunaDestino == colunaOrigem) && (linhaDestino <= 4)
                && (matriz.getMatriz(linhaDestino, colunaDestino) == 'E') 
                && (matriz.getMatriz(linhaOrigem + 1, colunaOrigem) == '.')){
            return true;
        } else if((colunaDestino == colunaOrigem - 2) && (linhaDestino == linhaOrigem) && (colunaDestino >= 0)
                && (matriz.getMatriz(linhaDestino, colunaDestino) == 'E') 
                && (matriz.getMatriz(linhaOrigem, colunaOrigem - 1) == '.')){
            return true;
        } else if((colunaDestino == colunaOrigem + 2) && (linhaDestino == linhaOrigem) && (colunaDestino <= 3)
                && (matriz.getMatriz(linhaDestino, colunaDestino) == 'E') 
                && (matriz.getMatriz(linhaOrigem, colunaOrigem + 1) == '.')){
            return true;
        } else {
            return false;
        }
    }
    /**
     * Verifica se o alien pode se movimentar para cima, para baixo, para o
     * lado esquerdo e para o lado direito, substituindo espaços vazios
     * pelo alien.
     * 
     * @param linhaOrigem linha da matriz de partida do alien
     * @param colunaOrigem coluna da matriz de partida do alien
     * @param linhaDestino linha da matriz de chegada do alien
     * @param colunaDestino coluna da matriz de chegada do alien
     * @param matriz matriz do jogo
     * @return true ou false
     */
    public static boolean movimentoAlien(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, Matriz matriz){
        if((linhaDestino == linhaOrigem - 1) && (colunaDestino == colunaOrigem) 
                && (linhaDestino >= 0)){
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'A');
            return true;
        } else if((linhaDestino == linhaOrigem + 1) && (colunaDestino == colunaOrigem)
                && (linhaDestino <= 4)){ 
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'A');
            return true;
        } else if((colunaDestino == colunaOrigem - 1) && (linhaDestino == linhaOrigem) 
                && (colunaDestino >= 0)) {
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'A');
            return true;   
        } else if((colunaDestino == colunaOrigem + 1) && (linhaDestino == linhaOrigem)
                && (colunaDestino <= 3)){
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'A');
            return true; 
        } else {
            return false;
        }
    }
    /**
     * Verifica se há alguma ema a dois espaços de distância do alien
     * e efetua a captura, substituindo os espaços ocupados por emas 
     * por aliens.
     * 
     * @param linhaOrigem linha da matriz de partida do alien
     * @param colunaOrigem coluna da matriz de partida do alien
     * @param linhaDestino linha da matriz de chegada do alien
     * @param colunaDestino coluna da matriz de chegada do alien
     * @param matriz matriz do jogo
     * @return true ou false
     */
    public static boolean capturaEma(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, Matriz matriz){
        if((linhaDestino == linhaOrigem - 2) && (colunaDestino == colunaOrigem) && (linhaDestino >= 0) 
                && (matriz.getMatriz(linhaDestino, colunaDestino) == 'E') 
                && (matriz.getMatriz(linhaOrigem - 1, colunaOrigem) == '.')){
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'A');
            return true;
            
        } else if((linhaDestino == linhaOrigem + 2) && (colunaDestino == colunaOrigem) && (linhaDestino <= 4)
                && (matriz.getMatriz(linhaDestino, colunaDestino) == 'E') 
                && (matriz.getMatriz(linhaOrigem + 1, colunaOrigem) == '.')){
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'A');
            return true;   
        } else if((colunaDestino == colunaOrigem - 2) && (linhaDestino == linhaOrigem) && (colunaDestino >= 0)
                && (matriz.getMatriz(linhaDestino, colunaDestino) == 'E') 
                && (matriz.getMatriz(linhaOrigem, colunaOrigem - 1) == '.')){
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'A');
            return true;
        } else if((colunaDestino == colunaOrigem + 2) && (linhaDestino == linhaOrigem) && (colunaDestino <= 3)
                && (matriz.getMatriz(linhaDestino, colunaDestino) == 'E') 
                && (matriz.getMatriz(linhaOrigem, colunaOrigem + 1) == '.')){
            matriz.setMatriz(linhaOrigem, colunaOrigem,  '.');
            matriz.setMatriz(linhaDestino,colunaDestino, 'A');
            return true;
        } else {
            return false;
        }
    }
    /**
     * Faz um mapeamento e analisa quantas emas existem dentro da
     * matriz, dando a vitória aos aliens se houver apenas 1 ema
     * dentro da matriz.
     * 
     * @param linha linha da matriz 
     * @param coluna coluna da matriz 
     * @param matriz matriz do jogo
     * @return true ou false
     */
    public static boolean vitoriaAlien(int linha, int coluna, Matriz matriz){
        int quantiaDeEmas = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                if (matriz.getMatriz(i, j)=='E'){
                    quantiaDeEmas++;
                }
            }
        }
        if(quantiaDeEmas < 3){
            return true;
        } else {
            return false;
        }
    }
}