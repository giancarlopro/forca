package br.edu.iff.dominio.imagem;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.imagem.LetraImagemFactory;
import br.edu.iff.dominio.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.imagem.BonecoImagemFactory;

/**
 * ElementoGraficoImagemFactory
 */
public class ElementoGraficoImagemFactory implements ElementoGraficoFactory {
    private static ElementoGraficoImagemFactory soleInstance = null;

    /**
     * @return the soleInstance
     */
    public static ElementoGraficoImagemFactory getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new ElementoGraficoImagemFactory();

        return soleInstance;
    }

    private BonecoImagemFactory bonecoFactory;
    private LetraImagemFactory letraFactory;

    private ElementoGraficoImagemFactory() {
        bonecoFactory = BonecoImagemFactory.getSoleInstance();
        letraFactory = LetraImagemFactory.getSoleInstance();
    }

    @Override
    public Boneco getBoneco() {
        return bonecoFactory.getBoneco();
    }

    @Override
    public Letra getLetra(char codigo) {
        return letraFactory.getLetra(codigo);
    }

    @Override
    public Letra getLetraEncoberta() {
        return letraFactory.getLetraEncoberta();
    }
}