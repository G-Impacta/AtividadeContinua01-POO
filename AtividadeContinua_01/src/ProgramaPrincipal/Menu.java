package ProgramaPrincipal;

/*
Autores:

Caio Victor dos Santos - 1904013
Cristhian Ocampo Quinteiro – 1902919
Mirelly Simões Barbosa - 1903911
Thiago Souza do Amparo – 1904089

*/

import static MetodosJogo.Metodos.exibirGrade;
import static MetodosJogo.Metodos.finalizaJogo;
import static MetodosJogo.Metodos.initialize;
import static MetodosJogo.Metodos.roundGamer;
import static MetodosJogo.Metodos.status;
import static MetodosJogo.Metodos.step;
import static MetodosJogo.Metodos.verificaStatus;
import java.util.Scanner;

public class Menu {
    
    //Implementação do procedimento para executar a lógica do jogo, metodo (game).
    public static void main(String[] args) {
        
        //Invoca o metodo Scanner para ler dados de entrada do teclado.
        Scanner entradaDados = new Scanner(System.in);
        
        //Variavel do tipo Booleano que permitirá o jogador jogar novamente.
        boolean jogarNovamente = true;//Muda para falso quando a partida acabar.
        
        //O Laço se repetirá enquanto o jogador optar por jogar novamente.
        while(jogarNovamente){//Enquanto a variavel jogarNovamente for true.
            
            //Mensagem de boas vindas.
            System.out.println("Bem vindo ao JOGO DA VELHA!\n");
            
            //Utiliza o metodo initialize para criar uma matriz 3x3.
            char grade[][] = initialize();//Armazena a matriz criada na variavel.           
            
            //As variaveis armazenam os simbolos que representam os jogadores.
            char playerOne = 'O';//Player 1 utiliza o simbolo 'O'.
            char playerTwo = 'X';//Player 2 utiliza o simbolo '1'.            
                        
            //Informa o jogador que começa o jogo.
            System.out.println("O jogador '" + playerOne + "' inicia a partida!");
            
            //O laço simula ás rodadas do jogo.
            for(int i = 0; i < 5; i++){//Sendo duas jogadas por rodada.
                
                //Invoca o metodo roundGamer que fará toda a interação com o jogador.
                roundGamer(grade, playerOne);//Esse round pertence ao primeiro jogador.
                
                //Invoca o metodo exibirGrade, que exibira a grade do jogo.
                exibirGrade(grade);//A grade do jogo se trata da matriz do jogo.
                
                //Invoca o metodo verificaStatus que fará a interação com o jogador.
                boolean fimJogo = verificaStatus(grade);// Verifica se o jogo continua.
                
                //Caso a variavel fimJogo retorne true.
                if(fimJogo){
                    break;//O jogo termina.
                }          
                
                //Simula nove jogadas, a quantidade de celulas na matriz.
                if(i == 4){//Quando o laço atingir a nona rodada.
                    verificaStatus(grade);// Verifica se o jogo continua.
                    break;//O jogo termina.
                }                
                                
                //Invoca o metodo roundGamer que fará toda a interação com o jogador.
                roundGamer(grade, playerTwo);//Esse round pertence ao segundo jogador.
                
                //Invoca o metodo exibirGrade, que exibira a grade do jogo.
                exibirGrade(grade);//A grade do jogo se trata da matriz do jogo.
                
                //Invoca o metodo verificaStatus que fará a interação com o jogador.
                fimJogo = verificaStatus(grade);// Verifica se o jogo continua.
                
                //Caso a variavel fimJogo retorne true.
                if(fimJogo){
                    break;//O jogo termina.
                }                
            }
            
            //Utiliza o metodo finalizaJogo para fazer a interação com o jogador.
            jogarNovamente = finalizaJogo();//Caso o jogador escolha, o jogo será encerrado.            
        }        
    }    
}
