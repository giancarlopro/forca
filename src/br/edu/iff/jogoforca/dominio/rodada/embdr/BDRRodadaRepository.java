package br.edu.iff.jogoforca.dominio.rodada.embdr;

import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

/**
 * BDRRodadaRepository
 */
public class BDRRodadaRepository implements RodadaRepository {
    private static BDRRodadaRepository soleInstance = null;

    public static BDRRodadaRepository getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new BDRRodadaRepository();

        return soleInstance;
    }

    private BDRRodadaRepository() {}

    @Override
    public long getProximoId() {
        return 0;
    }

    @Override
    public Rodada getPorId(Long id) {
        return null;
    }

    @Override
    public List<Rodada> getPorJogador(Jogador jogador) {
        return null;
    }

    @Override
    public void inserir(Rodada rodada) throws RepositoryException {
        throw new RepositoryException("Não implementado");
    }

    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {
        throw new RepositoryException("Não implementado");
    }

    @Override
    public void remover(Rodada rodada) throws RepositoryException {
        throw new RepositoryException("Não implementado");
    }
}