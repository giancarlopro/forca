package br.edu.iff.bancodepalavras.dominio.palavra.memoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.RepositoryException;

/**
 * MemoriaPalavraRepository
 */
public class MemoriaPalavraRepository implements PalavraRepository {
    private static MemoriaPalavraRepository soleInstance = null;

    /**
     * @return the soleInstance
     */
    public static MemoriaPalavraRepository getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new MemoriaPalavraRepository();

        return soleInstance;
    }

    private List<Palavra> pool;

    private MemoriaPalavraRepository() {
        pool = new ArrayList<>();
    }


    @Override
    public long getProximoId() {
        return pool.size() + 1;
    }

    @Override
    public Palavra getPorId(long id) {
        for (Palavra palavra: pool) {
            if (palavra.getId().equals(id))
                return palavra;
        }

        throw new RuntimeException("id inexistente");
    }

    @Override
    public List<Palavra> getPorTema(Tema tema) {
        List<Palavra> result = new ArrayList<>();

        for (Palavra palavra: pool) {
            if (palavra.getTema().equals(tema))
                result.add(palavra);
        }

        return result;
    }

    @Override
    public List<Palavra> getTodas() {
        return Collections.unmodifiableList(pool);
    }

    @Override
    public Palavra getPalavra(String palavra) {
        for (Palavra word: pool) {
            if (word.comparar(palavra))
                return word;
        }

        throw new RuntimeException("palavra não encontrada");
    }

    @Override
    public void inserir(Palavra palavra) throws RepositoryException {
        if (pool.contains(palavra))
            throw new RepositoryException("palavra já está no repositório");
    
        pool.add(palavra);
    }

    @Override
    public void atualizar(Palavra palavra) throws RepositoryException {
        if (!pool.removeIf((Palavra word) -> word.getId().equals(palavra.getId()))) {
            throw new RepositoryException("palavra não pôde ser atualizada");
        }

        pool.add(palavra);
    }

    @Override
    public void remover(Palavra palavra) throws RepositoryException {
        if (!pool.removeIf((Palavra word) -> word.getId().equals(palavra.getId()))) {
            throw new RepositoryException("palavra não pôde ser removida");
        }
    }
}