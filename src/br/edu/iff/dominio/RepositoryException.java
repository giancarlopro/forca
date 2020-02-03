package br.edu.iff.dominio;

/**
 * RepositoryException
 */
public class RepositoryException extends Exception{
    private static final long serialVersionUID = 1L;

    public RepositoryException() {
        super();
    }

    public RepositoryException(String message) {
        super(message);
    }
}