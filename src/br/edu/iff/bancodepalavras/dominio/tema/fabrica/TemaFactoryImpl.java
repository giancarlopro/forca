
package br.edu.iff.bancodepalavras.dominio.tema.fabrica;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.dominio.EntityFactory;
import br.edu.iff.dominio.RepositoryException;

/**
 * TemaFactoryImpl
 */
public class TemaFactoryImpl extends EntityFactory implements TemaFactory {
    private static TemaFactoryImpl soleInstance = null;

    public static void createSoleInstance(TemaRepository repository) {
        soleInstance = new TemaFactoryImpl(repository);
    }

    public static TemaFactoryImpl getSoleInstance() {
        return soleInstance;
    }
    
    protected TemaFactoryImpl(TemaRepository repository) {
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