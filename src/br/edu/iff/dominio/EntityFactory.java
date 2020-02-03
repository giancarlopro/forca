package br.edu.iff.dominio;

import br.edu.iff.dominio.repository.Repository;

/**
 * EntityFactory
 */
public abstract class EntityFactory {
    private Repository repository;

    protected EntityFactory(Repository repository) {
        this.repository = repository;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected Long getProximoId() {
        return repository.getProximoId();
    }
}