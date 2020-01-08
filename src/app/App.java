package app;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.texto.LetraTextoFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.jogoforca.dominio.boneco.texto.BonecoTextoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;

public class App {
    public static void main(String[] args) throws Exception {
        Palavra.setLetraFactory(new LetraTextoFactory());
        Rodada.setBonecoFactory(new BonecoTextoFactory());

        Jogador jogador = Jogador.criar(1L, "Giancarlo");

        Tema tema = Tema.criar(1L, "Frutas");

        List<Palavra> palavras = new ArrayList<>();
        palavras.add(Palavra.criar(1L, "banana", tema));
        palavras.add(Palavra.criar(2L, "manga", tema));
        palavras.add(Palavra.criar(3L, "morango", tema));

        Rodada rodada = Rodada.criar(1L, palavras, jogador);
        rodada.exibirItens(null);
        System.out.println();
        rodada.tentar('a');
        rodada.tentar('b');
        rodada.tentar('n');
        rodada.tentar('m');
        rodada.tentar('r');
        rodada.tentar('o');
        rodada.tentar('g');

        rodada.exibirItens(null);
        System.out.println();

        if (rodada.descobriu()) {
            System.out.print("Descobriu");
        } else {
            System.out.print("Não descobriu");
        }
    }
}