
package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

/**
 * TemaFactoryImpl
 */
public class TemaFactoryImpl extends EntityFactory implements TemaFactory {
    private static TemaFactoryImpl soleInstance = null;

    public static void createSoleInstance(TemaRepository repository) {
        soleInstance = new TemaFactoryImpl(repository);
    }

    public static TemaFactoryImpl getSoleInstance() {
        if (soleInstance == null)
            throw new RuntimeException("createSoleInstance deve ser chamando antes de getSoleInstance");

        return soleInstance;
    }
    
    private TemaFactoryImpl(TemaRepository repository) {
        super(repository);
    }

    private TemaRepository getTemaRepository() {
        return (TemaRepository) getRepository();
    }

    @Override
    public Tema getTema(String nome) {
        Tema tema = Tema.criar(getProximoId(), nome);

        try {
            getTemaRepository().inserir(tema);
        } catch (RepositoryException re) {
            throw new RuntimeException("não foi possível salvar o tema no repositorio");
        }

        return tema;
    }
}