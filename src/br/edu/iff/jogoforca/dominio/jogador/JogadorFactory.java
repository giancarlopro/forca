package br.edu.iff.jogoforca.dominio.jogador;

/**
 * JogadorFactory
 */
public interface JogadorFactory {
    public Jogador getJogador(String nome);
}