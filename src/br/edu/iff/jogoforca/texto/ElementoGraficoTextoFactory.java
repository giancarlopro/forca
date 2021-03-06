package br.edu.iff.jogoforca.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.texto.LetraTextoFactory;
import br.edu.iff.jogoforca.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.texto.BonecoTextoFactory;

/**
 * ElementoGraficoTextoFactory
 */
public class ElementoGraficoTextoFactory implements ElementoGraficoFactory {
    private static ElementoGraficoTextoFactory soleInstance = null;

    /**
     * @return the soleInstance
     */
    public static ElementoGraficoTextoFactory getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new ElementoGraficoTextoFactory();

        return soleInstance;
    }
    
    private BonecoTextoFactory bonecoFactory;
    private LetraTextoFactory letraFactory;

    private ElementoGraficoTextoFactory() {
        bonecoFactory = BonecoTextoFactory.getSoleInstance();
        letraFactory = LetraTextoFactory.getSoleInstance();
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