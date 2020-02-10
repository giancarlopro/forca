package br.edu.iff.jogoforca.dominio.jogador.emmemoria;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

/**
 * MemoriaJogadorRepository
 */
public class MemoriaJogadorRepository implements JogadorRepository {
    private static MemoriaJogadorRepository soleInstance = null;
    
    public static MemoriaJogadorRepository getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new MemoriaJogadorRepository();
    
        return soleInstance;
    }

    private List<Jogador> pool;
    
    private MemoriaJogadorRepository() {
        pool = new ArrayList<>();
    }

    @Override
    public long getProximoId() {
        return pool.size() + 1;
    }

    @Override
    public Jogador getPorId(Long id) {
        for (Jogador jogador: pool) {
            if (jogador.getId().equals(id))
                return jogador;
        }

        return null;
    }

    @Override
    public Jogador getPorNome(String nome) {
        for (Jogador jogador: pool){
            if (jogador.getNome().equals(nome))
                return jogador;
        }

        return null;
    }

    @Override
    public void inserir(Jogador jogador) throws RepositoryException {
        if (pool.contains(jogador))
            throw new RepositoryException("jogador já está no repositório");
    
        pool.add(jogador);
    }

    @Override
    public void atualizar(Jogador jogador) throws RepositoryException {
        if (!pool.removeIf((Jogador player) -> player.getId().equals(jogador.getId()))) {
            throw new RepositoryException("jogador não pôde ser atualizado");
        }

        pool.add(jogador);
    }

    @Override
    public void remover(Jogador jogador) throws RepositoryException {
        if (!pool.removeIf((Jogador player) -> player.getId().equals(jogador.getId()))) {
            throw new RepositoryException("jogador não pôde ser atualizado");
        }
    }
}