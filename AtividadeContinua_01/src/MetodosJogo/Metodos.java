package MetodosJogo;

/*
Autores:

Caio Victor dos Santos - 1904013
Cristhian Ocampo Quinteiro – 1902919
Mirelly Simões Barbosa - 1903911
Thiago Souza do Amparo – 1904089

*/

import java.util.Scanner;

public class Metodos {
    
    //Metodo de inicialização da matriz do jogo.
    public static char[][] initialize(){
        //Cria uma matriz 3x3, que será a grade do jogo.
        char M[][] = new char[3][3];
        
        //Percorre a matriz 3x3 que foi criada.
        for(int linha = 0; linha < M.length; linha++){//Percorre a linha.
            for(int coluna = 0; coluna < M.length; coluna++){//Percorre a coluna.
                
                //Para cada celula da matriz o laço coloca um espaço em branco.                 
                M[linha][coluna] = ' '; //O espaço representa uma celula vazia.
                
            }
        }
        //O metodo retorna a matriz criada e preenchida.
        return M;        
    }
    
    //O metodo preenche a matriz do jogo, com o char(simbolo) do jogador.
    public static boolean step(char M[][], int linha, int coluna, char gamer){
        
        //Verifica se a posição da matriz está vazia.
        if(M[linha][coluna] == ' '){
            
            //Caso esteja, preenche a posição escolhida com o char do jogador.
            M[linha][coluna] = gamer;
            
            //Retorna true como confirmação de preenchimento da matriz.
            return true;
            
        //Caso não esteja vazia.    
        }else{
            
            //Retorna false como indicação de que a posição está ocupada.
            return false;//Nesse caso a matriz não é preenchida.            
        }        
    }
    
    //O metodo verificará o status da partida.
    public static int status(char M[][]){
        
        //A variavel armazenará a quantidade de campos preenchidos.
        int camposPreenchidos = 0;
        
        //As variaveis armazenará o status de jogo de cada jogador.
        boolean playerOne = false;//O status de vencedor se inicia com falso.
        boolean playerTwo = false;//O status de vencedor se inicia com falso.
        
        //Percorre a matriz do jogo.
        for(int linha = 0; linha < M.length; linha++){//Percorre a linha.
            for(int coluna = 0; coluna < M.length; coluna++){//Percorre a coluna.
                
                //Verifica se a célula da matriz percorrida está vazia.
                if(M[linha][coluna] != ' '){
                    
                    //Caso não esteja, acrescenta mais um na variavel camposPreenchidos.
                    camposPreenchidos++;
                    
                }
                
                //Verifica se o jogador 'O' venceu em alguma linha.
                if((M[linha][0] == 'O') &&  (M[linha][1] == 'O') && (M[linha][2] == 'O')){
                    
                    //Caso tenha vencido, a variavel playerOne recebe true.
                    playerOne = true;//Muda o status do jogador para vencedor.
                
                //Verifica se o jogador 'X' venceu em alguma linha.
                }else if((M[linha][0] == 'X') &&  (M[linha][1] == 'X') && (M[linha][2] == 'X')){
                    
                    //Caso tenha vencido, a variavel playerTwo recebe true.
                    playerTwo = true;//Muda o status do jogador para vencedor.
                
                //Verifica se o jogador 'O' venceu em alguma coluna.
                }else if((M[0][coluna] == 'O') &&  (M[1][coluna] == 'O') && (M[2][coluna] == 'O')){
                    
                    //Caso tenha vencido, a variavel playerOne recebe true.
                    playerOne = true;//Muda o status do jogador para vencedor.
                 
                //Verifica se o jogador 'X' venceu em alguma coluna.   
                }else if((M[0][coluna] == 'X') &&  (M[1][coluna] == 'X') && (M[2][coluna] == 'X')){
                    
                    //Caso tenha vencido, a variavel playerTwo recebe true.
                    playerTwo = true;//Muda o status do jogador para vencedor.
                
                //Verifica se o jogador 'O' venceu na primeira diagonal.
                }else if((M[0][0] == 'O') && (M[1][1] == 'O') && (M[2][2] == 'O')){
                    
                    //Caso tenha vencido, a variavel playerOne recebe true.
                    playerOne = true;//Muda o status do jogador para vencedor.
                
                //Verifica se o jogador 'X' venceu na primeira diagonal.    
                }else if((M[0][0] == 'X') && (M[1][1] == 'X') && (M[2][2] == 'X')){
                    
                    //Caso tenha vencido, a variavel playerTwo recebe true.
                    playerTwo = true;//Muda o status do jogador para vencedor.
                
                //Verifica se o jogador 'O' venceu na segunda diagonal.    
                }else if((M[0][2] == 'O') && (M[1][1] == 'O') && (M[2][0] == 'O')){
                    
                    //Caso tenha vencido, a variavel playerOne recebe true.
                    playerOne = true;//Muda o status do jogador para vencedor.
                
                //Verifica se o jogador 'X' venceu na segunda diagonal.    
                }else if((M[0][2] == 'X') && (M[1][1] == 'X') && (M[2][0] == 'X')){
                    
                    //Caso tenha vencido, a variavel playerTwo recebe true.
                    playerTwo = true;//Muda o status do jogador para vencedor.
                    
                }                            
            }
        }
        
        //Caso não haja vencedores e o total de células preenchidas seja 9.
        if(!playerOne && !playerTwo && camposPreenchidos == 9){
            
            //Significa que houve um empate.
            return 0;//Nesse caso retorna 0, que significa empate.
        
        //Caso o Player 1 tenha vencido.
        }else if(playerOne){
            
            //Retorna 1, que significa que o jogador 'O' venceu a partida.
            return 1;
        
        //Caso o Player 2 tenha vencido.
        }else if(playerTwo){
            
            //Retorna 2, que significa que o jogador 'X' venceu a partida.
            return 2;            
        
        //Caso não haja empate, ou vencedores, o jogo continua normalmente.
        }else{
            
            //Retorna -1, que significa que o jogo pode continuar.
            return -1;
            
        }            
    }
    
    //O metodo imprimirá na tela a matriz do jogo.
    public static void exibirGrade(char M[][]){        
        
        //Imprimirá a primeira linha da matriz na tela.
        System.out.println(M[0][0] + "|" + M[0][1] + "|" + M[0][2]);
        
        //Imprimirá traços que serão utilizados como separadores de linhas.
        System.out.println("-----");
        
        //Imprimirá a segunda linha da matriz na tela.
        System.out.println(M[1][0] + "|" + M[1][1] + "|" + M[1][2]);
        
        //Imprimirá traços que serão utilizados como separadores de linhas.
        System.out.println("-----");
        
        //Imprimirá a terceira linha da matriz na tela.
        System.out.println(M[2][0] + "|" + M[2][1] + "|" + M[2][2]);           
    }
    
    //O metodo irá realizar toda a interação com o jogador e a validação da jogada.
    public static void roundGamer(char M[][], char gamer){
        
        //Variaveis para armazenar a posição escolhida pelos jogadores.
        int posLinha;//Armazena a posição da linha escolhida.
        int posColuna;//Armazena a posição da coluna escolhida.
        
        //Variavel do tipo Booleana para validar a jogada do jogador.
        boolean round;//Receberá o retorno do metodo step.
        
        //Mensagem informando há quem a rodada pertence.
        System.out.println("\nJogador '" + gamer + "' faça sua jogada!");
        
        //Validador de jogada, verificará se a jogada do jogador é valida.
        do{
            //Mensagem informando o jogador quais posições ele deve preencher.
            System.out.println("Escolha um posição [linha] e [coluna] para jogar:\n");

            //Mensagem solicitando o preenchimento de uma posição para a linha. 
            System.out.println("Escolha a posição da [linha]: ");

            //Utiliza o metodo validaJogada para receber a posição escolhida pelo jogador.
            posLinha = validaEntrada();//Entrada da posição da linha já validada.

            //Mensagem solicitando o preenchimento de uma posição para a coluna.
            System.out.println("Escolha a posição da [coluna]: ");

            //Utiliza o metodo validaJogada para receber a posição escolhida pelo jogador.
            posColuna = validaEntrada();//Entrada da posição da coluna já validada.
            
            //Imprimi um espaço vazio, que será utilizado como separador
            System.out.println();
            
            //Invoca o metodo step, que gravará a jogada do jogador na matriz.
            round = step(M, posLinha, posColuna, gamer);
            
            if(!round){
                
                System.out.println("Essa posição já está ocupada! Jogue Novamente!");
                
            }
            
        }while(!round);//Verifica se a jogada do jogador foi validada.        
    }
    
    //O metodo fará a interação com o jogador, utiliza o metodo step.
    public static boolean verificaStatus(char M[][]){
        
        //A variavel Booleana será retornada pelo metodo.
        boolean fimJogo = false;//Indicando se o jogo deve continuar ou não.
        
        //Invoca o metodo step para verificar qual o status atual do jogo.
        int status = status(M);
        
        //Decidirá os acontecimentos do jogo de acordo com o retorno do metodo step.
        switch (status) {
            
            //Se o retorno for 0, significa empate no jogo.
            case 0:
                
                //Mensagem informando que o jogo foi um empate.
                System.out.println("\nEsse jogo foi um empate!");
                
                //A variavel fimJogo muda para true, indicando o fim do jogo.
                fimJogo = true;
                break;//Encerra o case.
            
            //Se o retorno for 1, significa que o jogador 'O' venceu a partida.
            case 1:
                
                //Mensagem informando que o jogador 'O' venceu a partida.
                System.out.println("\nO jogador 'O' venceu essa partida!");
                
                //A variavel fimJogo muda para true, indicando o fim do jogo.
                fimJogo = true;
                break;//Encerra o case.
            
            //Se o retorno for 2, significa que o jogador 'X' venceu a partida.
            case 2:
                
                //Mensagem informando que o jogador 'X' venceu a partida.
                System.out.println("\nO jogador 'X' venceu essa partida!");
                
                //A variavel fimJogo muda para true, indicando o fim do jogo.
                fimJogo = true;
                break;//Encerra o case.
        }
        
        return fimJogo;//Retorna se o jogo continua ou não.
    }
    
    //O metodo validará a entrada da posição escolhida pelo jogador.
    public static int validaEntrada(){        
                        
        //Invoca o metodo Scanner para ler dados de entrada do teclado.
        Scanner entradaDados = new Scanner(System.in);
        
        //A variavel receberá a entrada da posição escolhida pelo jogador.
        int numero;        
        
        //Validador de entrada de dados.
        do{
            
            //Utilizará o metodo Scanner para receber a entrada do jogador.
            numero = entradaDados.nextInt();//Recebe a posição escolhida pelo jogador.
            
            //Verifica se a posição escolhida é valida.
            if(numero < 0 || numero > 2){
                
                //Caso não seja, imprimi uma mensagem de aviso.
                System.out.println("\nEssa posição é invalida na grade do jogo!");
                
                //E solicita que o jogador jogue novamente.
                System.out.println("Escolha outra posição!");
                
            }
            
        }while(numero < 0 || numero > 2);//Verifica se a posição escolhida é valida.
        
        return numero;//Retorna o numero escolhido já validado.        
    }

    public static boolean finalizaJogo(){        
                
        //Invoca o metodo Scanner para ler dados de entrada do teclado.
        Scanner entradaDados = new Scanner(System.in);        
                
        //A variavel permitirá o jogador escolher jogar novamente ou sair.
        int opcaoJogarNovamente = 0;//0 para Jogar Novamente ou 1 para Sair do Jogo.
                
        //Variavel do tipo Booleano que permitirá o jogador jogar novamente.
        boolean jogarNovamente = true;//Muda para falso quando a partida acabar.
                    
        //Mensagem aparecerá ao final de cada partida.
        System.out.println("\nDeseja jogar novamente?\n");
        
        //Informa ao jogador ás opções disponiveis ao fim de cada partida.
        System.out.println("[0] Jogar Novamente");
        System.out.println("[1] Sair do Jogo");
        
        //Valida a opção escolhida pelo jogador.
        do{ 
            //Mensagem informando ao jogador.
            System.out.println("\nEscolha uma opção: ");
            
            //A variavel recebe a opção escolhida pelo jogador.
            opcaoJogarNovamente = entradaDados.nextInt();
            
            //Utilizado como separador de linhas
            System.out.println();
            
            //Verifica qual foi a opção escolhida pelo jogador.
            switch(opcaoJogarNovamente){

                //Caso a opção escolhida seja 0.
                case 0:

                    //A variavel jogarNovamente permanece true.
                    break;//Encerra o case e o laço se repete novamente.

                //Caso a opção escolhida seja 1.                
                case 1:

                    //A variavel jogarNovamente recebe false.
                    jogarNovamente = false;
                    break;//Encerra o case e o laço de repetição se finaliza.

                //Caso a opção escolhida não seja nem 0 e nem 1.    
                default:

                    //Mensagem informa o jogador.
                     System.out.println("Opção invalida.");                                           
            }
        
        //Caso a opção escolhida seja invalida o validador solicitará uma nova posição.
        }while(opcaoJogarNovamente < 0 || opcaoJogarNovamente > 1);
        
        return jogarNovamente;//Retorna se o jogo deve continuar ou não.
    }
}
