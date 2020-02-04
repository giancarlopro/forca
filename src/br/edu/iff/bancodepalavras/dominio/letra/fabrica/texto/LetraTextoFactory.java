package br.edu.iff.bancodepalavras.dominio.letra.fabrica.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.fabrica.LetraFactoryImpl;

/**
 * LetraTextoFactory
 */
public class LetraTextoFactory extends LetraFactoryImpl {
    private static LetraTextoFactory soleInstance = null;

    /**
     * @return the soleInstance
     */
    public static LetraTextoFactory getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new LetraTextoFactory();

        return soleInstance;
    }

    private LetraTextoFactory() {}

    @Override
    protected Letra criarLetra(char codigo) {
        return new LetraTexto(codigo);
    }
}