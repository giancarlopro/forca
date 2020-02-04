package br.edu.iff.bancodepalavras.dominio.letra.fabrica.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;

/**
 * LetraTexto
 */
public class LetraTexto extends Letra {

    protected LetraTexto(char codigo) {
        super(codigo);
    }

    @Override
    public void exibir(Object contexto) {
        System.out.print(this.getCodigo());
    }
}