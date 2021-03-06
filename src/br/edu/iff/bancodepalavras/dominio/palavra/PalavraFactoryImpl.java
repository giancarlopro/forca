package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

/**
 * PalavraFactoryImpl
 */
public class PalavraFactoryImpl extends EntityFactory implements PalavraFactory {
    private static PalavraFactoryImpl soleInstance = null;

    /**
     * @return the soleInstance
     */
    public static PalavraFactoryImpl getSoleInstance() {
        if (soleInstance == null)
            throw new RuntimeException("createSoleInstance deve ser chamando antes de getSoleInstance");

        return soleInstance;
    }

    public static void createSoleInstance(PalavraRepository repository) {
        soleInstance = new PalavraFactoryImpl(repository);
    }

    private PalavraFactoryImpl(PalavraRepository repository) {
        super(repository);
    }

    private PalavraRepository getPalavraRepository() {
        return (PalavraRepository) getRepository();
    }

    @Override
    public Palavra getPalavra(String palavra, Tema tema) {
        Palavra word = Palavra.criar(getProximoId(), palavra, tema);

        try {
            getPalavraRepository().inserir(word);
        } catch (RepositoryException re) {
            throw new RuntimeException("não foi possível salvar a palavra no repositorio");
        }

        return word;
    } 
}