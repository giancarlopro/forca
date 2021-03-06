package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraAppService;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaAppService;
import br.edu.iff.jogoforca.Aplicacao;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaAppService;

public class App {
    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void println() {
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Aplicacao aplicacao = Aplicacao.getSoleInstance();

        JogadorFactory jogadorFactory = aplicacao.getJogadorFactory();

        TemaAppService temaAppService = TemaAppService.getSoleInstance();
        Tema tema = temaAppService.novoTema("Cores");

        PalavraAppService palavraAppService = PalavraAppService.getSoleInstance();
        palavraAppService.novaPalavra("azul", tema);
        palavraAppService.novaPalavra("amarelo", tema);
        palavraAppService.novaPalavra("verde", tema);

        Jogador jogador = jogadorFactory.getJogador("Giancarlo");

        RodadaAppService rodadaAppService = RodadaAppService.getSoleInstance();
        Rodada rodada = rodadaAppService.novaRodada(jogador);

        while (!rodada.encerrou()) {
            println("Tema: " + rodada.getTema().getNome());
            println("Erros: " + rodada.getQtdeErros() + "/" + Rodada.getMaxErros());
            print("Tentativas: ");
            for (Letra tentativa: rodada.getTentativas()) {
                tentativa.exibir(null);
                print(" ");
            }
            println();

            rodada.exibirItens(null);
            println();
            rodada.exibirBoneco(null);
            println();

            print("Faça um palpite (0 para arriscar): ");
            char codigo = sc.next().charAt(0);

            if (codigo == '0') {
                List<String> palavras = new ArrayList<>();

                println("Você está arriscando!");
                for (int i = 0; i < rodada.getNumPalavras(); i++) {
                    print("Palavra " + (i+1) + ": ");
                    String palavra = sc.next();
                    palavras.add(palavra);
                }

                rodada.arriscar(palavras);
            } else {
                rodada.tentar(codigo);
            }
            println();
        }

        if (rodada.descobriu()) {
            println("Parabéns, você descobriu!");
            rodada.exibirPalavras(null);
        } else {
            println("Que pena, não foi dessa vez.");
        }
        println("Você fez " + rodada.calcularPontos() + " pontos nessa rodada!");

        sc.close();
    }
}