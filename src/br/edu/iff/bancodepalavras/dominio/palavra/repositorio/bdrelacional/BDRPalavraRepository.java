package br.edu.iff.bancodepalavras.dominio.palavra.repositorio.bdrelacional;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.RepositoryException;

/**
 * BDRPalavraRepository
 */
public class BDRPalavraRepository implements PalavraRepository {
    private static BDRPalavraRepository soleInstance = null;

    /**
     * @return the soleInstance
     */
    public static BDRPalavraRepository getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new BDRPalavraRepository();

        return soleInstance;
    }

    private BDRPalavraRepository() {}

    @Override
    public long getProximoId() {
        return 0;
    }

    @Override
    public Palavra getPorId(long id) {
        return null;
    }

    @Override
    public List<Palavra> getPorTema(Tema tema) {
        return null;
    }

    @Override
    public List<Palavra> getTodas() {
        return null;
    }

    @Override
    public Palavra getPalavra(String palavra) {
        return null;
    }

    @Override
    public void inserir(Palavra palavra) throws RepositoryException {}

    @Override
    public void atualizar(Palavra palavra) throws RepositoryException {}

    @Override
    public void remover(Palavra palavra) throws RepositoryException {}
}