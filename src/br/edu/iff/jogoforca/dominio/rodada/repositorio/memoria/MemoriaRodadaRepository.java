package br.edu.iff.jogoforca.dominio.rodada.repositorio.memoria;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.dominio.RepositoryException;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;

/**
 * MemoriaRodadaRepository
 */
public class MemoriaRodadaRepository implements RodadaRepository {
    private static MemoriaRodadaRepository soleInstance = null;

    public static MemoriaRodadaRepository getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new MemoriaRodadaRepository();

        return soleInstance;
    }

    private List<Rodada> pool;

    private MemoriaRodadaRepository() {
        pool = new ArrayList<>();
    }

    @Override
    public long getProximoId() {
        return pool.size() + 1;
    }

    @Override
    public Rodada getPorId(Long id) {
        for (Rodada rodada: pool) {
            if (rodada.getId().equals(id))
                return rodada;
        }

        throw new RuntimeException("id inexistente");
    }

    @Override
    public List<Rodada> getPorJogador(Jogador jogador) {
        List<Rodada> result = new ArrayList<>();

        for (Rodada rodada: pool) {
            if (rodada.getJogador() == jogador)
                result.add(rodada);
        }

        return result;
    }

    @Override
    public void inserir(Rodada rodada) throws RepositoryException {
        if (pool.contains(rodada))
            throw new RepositoryException("rodada já está no repositório");
    
        pool.add(rodada);
    }

    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {
        if (!pool.removeIf((Rodada round) -> round.getId().equals(rodada.getId()))) {
            throw new RepositoryException("rodada não pôde ser atualizada");
        }

        pool.add(rodada);
    }

    @Override
    public void remover(Rodada rodada) throws RepositoryException {
        if (!pool.removeIf((Rodada round) -> round.getId().equals(rodada.getId()))) {
            throw new RepositoryException("rodada não pôde ser removida");
        }
    }
}