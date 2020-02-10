package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

/**
 * PalavraAppService
 */
public class PalavraAppService {
    private static PalavraAppService soleInstance = null;

    public static void createSoleInstance(PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
        soleInstance = new PalavraAppService(palavraRepository, palavraFactory);
    }

    public static PalavraAppService getSoleInstance() {
        return soleInstance;
    }

    PalavraRepository repository;
    PalavraFactory factory;

    private PalavraAppService(PalavraRepository repository, PalavraFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public boolean novaPalavra(String palavra, Tema tema) {
        if (repository.getPalavra(palavra) != null)
            return true;

        Palavra word = factory.getPalavra(palavra, tema);

        try {
            repository.inserir(word);
        } catch (RepositoryException re) {
            return false;
        }

        return true;
    }
}