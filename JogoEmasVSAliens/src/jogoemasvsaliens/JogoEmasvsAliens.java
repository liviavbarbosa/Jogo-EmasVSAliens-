package jogoaliesvsemas;

import java.io.IOException;
import java.util.Scanner;

public class JogoEmasvsAliens {

    public static void main(String[] args) {
        Matriz matriz = new Matriz();
        int linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, saida;
        boolean desocupado = false, alienProntoParaAtaque = false, posicaoAlien, posicaoValida, posicaoEma;
        boolean vitoriaAlien = false, vitoriaEma = false;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem-vindo ao jogo Emas versus Alienigenas, este e o estado inicial do jogo: ");
        // Mostra a matriz inicial do jogo
        matriz.matrizInicial();
        // Realiza todos os comandos do jogo enquanto nenhum dos jogadores vence
        do {
            // Realiza todos os comandos de jogabilidade para os aliens, enquanto as posições forem válidas, os espaços informados estiverem desocupados e o alien puder atacar uma ema
            do {
                System.out.println("Jogador 1, escolha um Alien e informe qual o numero da linha em que ele esta:");
                linhaOrigem = entrada.nextInt();
                System.out.println("Jogador 1, agora informe o numero da coluna do Alien escolhido:");
                colunaOrigem = entrada.nextInt();
                // Chama o método para verificar se existe um alien onde o jogador 1 informou a linha e a coluna do alien desejado
                posicaoValida = AlteracoesAliens.posicaoValidaAlien(linhaOrigem, colunaOrigem, matriz);
                if (posicaoValida == true) {
                    System.out.println("Jogador 1, informe a linha da jogada desejada:");
                    linhaDestino = entrada.nextInt();
                    System.out.println("Jogador 1, informe a coluna da jogada desejada:");
                    colunaDestino = entrada.nextInt();
                    // Chama o método para analisar se a posição da jogada informada está desocupada
                    desocupado = Matriz.isDesocupado(linhaDestino, colunaDestino, matriz);
                    // Chama o método para analisar se não há uma ema a dois espaços do alien informado, já que, dessa forma, ele poderá capturar e ficar no lugar da ema
                    alienProntoParaAtaque = AlteracoesAliens.verificacaoDeAtaque(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, matriz);
                    if (desocupado == true) {
                        // Chama o método para modificar a posição do alien, deixando a sua posição de origem livre e substituindo a posição livre informada por um alien
                        posicaoAlien = AlteracoesAliens.movimentoAlien(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, matriz);
                        // Se a posição informada pelo jogador 1 estiver fora das regras, a variável posicaoAlien recebe o valor false e o jogador perde a vez
                        if (posicaoAlien == false) {
                            System.out.println("A posicao que voce escolheu nao e valida.");
                        }
                    } else if (alienProntoParaAtaque == true) {
                        // Chama o método para capturar a ema e substituir o seu lugar, tornando livre a posição de origem do alien
                        posicaoAlien = AlteracoesAliens.capturaEma(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, matriz);
                        if (posicaoAlien == false) {
                            System.out.println("A posicao que voce escolheu nao e valida.");
                        }
                        // Se o jogador informar uma posição que já está sendo ocupada, o sistema pede que ele escolha uma nova posição
                    } else {
                        System.out.println("Voce nao pode mover o alien para essa posicao, tente novamente.");
                        matriz.estadoMatriz();
                    }
                    // Se o jogador informar uma posição em que não há nenhum alien para mover, o sistema pede que ele escolha uma nova posição
                } else {
                    System.out.println("Posicao invalida, tente novamente.");
                    matriz.estadoMatriz();
                }
            } while ((!posicaoValida || desocupado == false) && alienProntoParaAtaque == false);
            // Se os aliens capturarem 7 das 8 emas, o jogo será vencido pelo jogador 1
            if (AlteracoesAliens.vitoriaAlien(linhaOrigem, colunaOrigem, matriz) == true) {
                vitoriaAlien = true;
                System.out.println("Vitoria do jogador 1! Parabens!");
            }
            // Método chamado para mostrar as alterações feitas na matriz
            matriz.estadoMatriz();
            System.out.println("Deseja sair e salvar o estado atual do jogo?");
            System.out.println("1) Sim, desejo.");
            System.out.println("2) Não, quero continuar o jogo.");
            saida = entrada.nextInt();
            // Salva o estado da matriz se o jogador escolher salvá-lo
            if (saida == 1) {
                try{
                Arquivo.gravar(matriz.estadoMatrizArquivo(2), "aliensvsemas.txt");
                }catch(IOException e){
                    System.out.println("Erro no arquivo.");
                }
                System.out.println("Saindo.");
            // Continua o jogo sem salvar o estado atual da matriz
            } else {
                // Realiza todos os comandos de jogabilidade para as emas, enquanto as posições forem válidas e os espaços informados estiverem desocupados 
                do {
                    System.out.println("Jogador 2, escolha uma Ema e informe qual o numero da linha em que ela esta:");
                    linhaOrigem = entrada.nextInt();
                    System.out.println("Jogador 2, agora informe o numero da coluna da Ema escolhida");
                    colunaOrigem = entrada.nextInt();
                    // Chama o método para verificar se existe uma ema onde o jogador 2 informou a linha e a coluna da ema desejado
                    posicaoValida = AlteracoesEmas.posicaoValidaEma(linhaOrigem, colunaOrigem, matriz);
                    if (posicaoValida == true) {
                        System.out.println("Jogador 2, informe a linha da jogada desejada:");
                        linhaDestino = entrada.nextInt();
                        System.out.println("Jogador 2, informe a coluna da jogada desejada:");
                        colunaDestino = entrada.nextInt();
                        // Chama o método para analisar se a posição da jogada informada está desocupada
                        desocupado = Matriz.isDesocupado(linhaDestino, colunaDestino, matriz);
                        if (desocupado == true) {
                            // Chama o método para modificar a posição da ema, deixando a sua posição de origem livre e substituindo a posição livre informada por uma ema
                            posicaoEma = AlteracoesEmas.movimentoEma(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, matriz);
                            // Se a posição informada pelo jogador 2 estiver fora das regras, a variável posicaoEma recebe o valor false e o jogador perde a vez
                            if (posicaoEma == false) {
                                System.out.println("A posicao que voce informou nao e valida.");
                            }
                            // Se o jogador informar uma posição que já está sendo ocupada, o sistema pede que ele escolha uma nova posição
                        } else {
                            System.out.println("Voce nao pode mover a ema para essa posicao, tente novamente.");
                            matriz.estadoMatriz();
                        }
                        // Se o jogador informar uma posição em que não há nenhuma ema para mover, o sistema pede que ele escolha uma nova posição
                    } else {
                        System.out.println("Posicao invalida, tente novamente.");
                        matriz.estadoMatriz();
                    }
                } while (!posicaoValida || desocupado == false);
                // Se as emas cercarem os dois aliens, o jogo será vencido pelo jogador 2
                if (AlteracoesEmas.vitoriaEma(matriz) == true) {
                    vitoriaEma = true;
                    System.out.println("Vitoria do jogador 2! Parabens!");
                }
                matriz.estadoMatriz();
                System.out.println("Deseja sair e salvar o estado atual do jogo?");
                System.out.println("1) Sim, desejo.");
                System.out.println("2) Não, quero continuar o jogo.");
                saida = entrada.nextInt();
                // Salva o estado da matriz se o jogador escolher salvá-lo
                if (saida == 1) {
                    System.out.println(matriz.estadoMatrizArquivo(1));
                    System.out.println("Saindo.");
                }
            }
        } while ((!vitoriaAlien || !vitoriaEma) && saida != 1);
        if(saida != 1){
          System.out.println("Fim de jogo. Parabens ao vencedor!");
        }
    }
}