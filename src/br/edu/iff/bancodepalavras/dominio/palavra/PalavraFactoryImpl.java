package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.EntityFactory;
import br.edu.iff.dominio.RepositoryException;

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
        if (soleInstance != null)
            throw new RuntimeException("createSoleInstance só pode ser chamado uma vez");

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