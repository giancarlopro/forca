package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;

/**
 * RodadaFactory
 */
public interface RodadaFactory {
    public Rodada getRodada(Jogador jogador);
}