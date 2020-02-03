package br.edu.iff.jogoforca.dominio.rodada;

import java.util.List;

import br.edu.iff.dominio.Repository;
import br.edu.iff.dominio.RepositoryException;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;

/**
 * RodadaRepository
 */
public interface RodadaRepository extends Repository {
    public Rodada getPorId(Long id);
    public List<Rodada> getPorJogador(Jogador jogador);
    public void inserir(Rodada rodada) throws RepositoryException;
    public void atualizar(Rodada rodada) throws RepositoryException;
    public void remover(Rodada rodada) throws RepositoryException;
}