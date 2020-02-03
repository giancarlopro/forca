package br.edu.iff.bancodepalavras.dominio.palavra.factory;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;

/**
 * PalavraFactory
 */
public interface PalavraFactory {
    public Palavra getPalavra(String palavra, Tema tema);
}