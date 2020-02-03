package br.edu.iff.bancodepalavras.dominio.letra.imagem;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactoryImpl;

/**
 * LetraImagemFactory
 */
public class LetraImagemFactory extends LetraFactoryImpl {
    private LetraImagemFactory soleInstance = null;

    /**
     * @return the soleInstance
     */
    public LetraImagemFactory getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new LetraImagemFactory();

        return soleInstance;
    }

    private LetraImagemFactory() {}

    @Override
    protected Letra criarLetra(char codigo) {
        return new LetraImagem(codigo);
    }
}