package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

/**
 * BonecoTexto
 */
public class BonecoTexto implements Boneco {
    private static BonecoTexto soleInstance = null;

    private static String[] partesNome = { "cabeça", "olho esquerdo", "olho direito", "nariz", "boca", "tronco", "braço esquerdo",
            "braço direito", "perna esquerda", "perna direita" };

    public static BonecoTexto getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new BonecoTexto();

        return soleInstance;
    }

    private BonecoTexto() {
    }

    @Override
    public void exibir(Object contexto, int partes) {
        for (int i = 0; i < partes; i++) {
            System.out.print(partesNome[i]);

            if ((i + 1) != partes)
                System.out.print(", ");
        }
    }
}