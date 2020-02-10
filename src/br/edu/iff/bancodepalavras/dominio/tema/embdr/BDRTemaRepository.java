package br.edu.iff.bancodepalavras.dominio.tema.embdr;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.repository.RepositoryException;

/**
 * BDRTemaRepository
 */
public class BDRTemaRepository implements TemaRepository {
    private static BDRTemaRepository soleInstance = null;

    public static BDRTemaRepository getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new BDRTemaRepository();

        return soleInstance;
    }

    private BDRTemaRepository() {}

    @Override
    public long getProximoId() {
        return 0;
    }

    @Override
    public Tema getPorId(Long id) {
        return null;
    }

    @Override
    public List<Tema> getPorNome(String nome) {
        return null;
    }

    @Override
    public List<Tema> getTodos() {
        return null;
    }

    @Override
    public void inserir(Tema tema) throws RepositoryException {
        throw new RepositoryException("Não implementado");
    }

    @Override
    public void atualizar(Tema tema) throws RepositoryException {
        throw new RepositoryException("Não implementado");
    }

    @Override
    public void remover(Tema tema) throws RepositoryException {
        throw new RepositoryException("Não implementado");
    }
}