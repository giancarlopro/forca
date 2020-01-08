package br.edu.iff.jogoforca.dominio.boneco.imagem;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

/**
 * BonecoImagem
 */
public class BonecoImagem implements Boneco {
    private static BonecoImagem soleInstance = null;

    public static BonecoImagem getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new BonecoImagem();

        return soleInstance;
    }

    private BonecoImagem() {
    }

    @Override
    public void exibir(Object contexto, int partes) {
    }
}