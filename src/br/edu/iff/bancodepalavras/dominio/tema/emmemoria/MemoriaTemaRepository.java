package br.edu.iff.bancodepalavras.dominio.tema.emmemoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.repository.RepositoryException;

/**
 * MemoriaTemaRepository
 */
public class MemoriaTemaRepository implements TemaRepository {
    private static MemoriaTemaRepository soleInstance = null;

    public static MemoriaTemaRepository getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new MemoriaTemaRepository();

        return soleInstance;
    }

    private List<Tema> pool;

    private MemoriaTemaRepository() {
        pool = new ArrayList<>();
    }

    @Override
    public long getProximoId() {
        return pool.size() + 1;
    }

    @Override
    public Tema getPorId(Long id) {
        for (Tema tema: pool) {
            if (tema.getId().equals(id))
                return tema;
        }

        return null;
    }

    @Override
    public List<Tema> getPorNome(String nome) {
        List<Tema> result = new ArrayList<>();

        for (Tema tema: pool) {
            String lowerName = tema.getNome().toLowerCase();
            if (lowerName.contains(nome.toLowerCase()))
                result.add(tema);
        }

        return result;
    }

    @Override
    public List<Tema> getTodos() {
        return Collections.unmodifiableList(pool);
    }

    @Override
    public void inserir(Tema tema) throws RepositoryException {
        if (pool.contains(tema))
            throw new RepositoryException("tema já está no repositório");

        pool.add(tema);
    }

    @Override
    public void atualizar(Tema tema) throws RepositoryException {
        if (!pool.removeIf((Tema theme) -> theme.getId().equals(tema.getId()))) {
            throw new RepositoryException("tema não pôde ser atualizado");
        }

        pool.add(tema);
    }

    @Override
    public void remover(Tema tema) throws RepositoryException {
        if (!pool.removeIf((Tema theme) -> theme.getId().equals(tema.getId()))) {
            throw new RepositoryException("tema não pôde ser removido");
        }
    }
}