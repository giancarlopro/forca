package br.edu.iff.bancodepalavras.dominio.letra.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactoryImpl;

/**
 * LetraTextoFactory
 */
public class LetraTextoFactory extends LetraFactoryImpl {
    private LetraTextoFactory soleInstance = null;

    /**
     * @return the soleInstance
     */
    public LetraTextoFactory getSoleInstance() {
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