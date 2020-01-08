package br.edu.iff.dominio;

/**
 * ObjetoDominioImpl
 */
public abstract class ObjetoDominioImpl implements ObjetoDominio {
    private Long id;

    public ObjetoDominioImpl(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return this.id;
    }
}