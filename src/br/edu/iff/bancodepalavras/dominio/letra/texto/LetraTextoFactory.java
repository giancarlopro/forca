package br.edu.iff.bancodepalavras.dominio.letra.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;

/**
 * LetraTextoFactory
 */
public class LetraTextoFactory implements LetraFactory {
    @Override
    public Letra getLetra(char codigo) {
        return new LetraTexto(codigo);
    }

    @Override
    public Letra getLetraEncoberta() {
        return new LetraTexto('*');
    }
}