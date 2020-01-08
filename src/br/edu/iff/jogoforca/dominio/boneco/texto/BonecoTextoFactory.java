package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;

/**
 * BonecoTextoFactory
 */
public class BonecoTextoFactory implements BonecoFactory {
    @Override
    public Boneco getBoneco() {
        return BonecoTexto.getSoleInstance();
    }
}