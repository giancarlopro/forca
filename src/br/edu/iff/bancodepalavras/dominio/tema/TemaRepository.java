package br.edu.iff.bancodepalavras.dominio.tema;

import java.util.List;

import br.edu.iff.dominio.Repository;
import br.edu.iff.dominio.RepositoryException;

/**
 * TemaRepository
 */
public interface TemaRepository extends Repository {
    public Tema getPorId(Long id);
    public List<Tema> getPorNome(String nome);
    public List<Tema> getTodos();
    public void inserir(Tema tema) throws RepositoryException;
    public void atualizar(Tema tema) throws RepositoryException;
    public void remover(Tema tema) throws RepositoryException;
}