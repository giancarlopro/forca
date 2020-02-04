package br.edu.iff.dominio.repositorio.dbrelacional;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.dominio.RepositoryFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;

/**
 * DBRRepositoryFactory
 */
public class DBRRepositoryFactory implements RepositoryFactory {
    private static DBRRepositoryFactory soleInstance = null;

    public static DBRRepositoryFactory getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new DBRRepositoryFactory();

        return soleInstance;
    }

    private DBRRepositoryFactory() {}

    @Override
    public PalavraRepository getPalavraRepository() {
        return null;
    }

    @Override
    public TemaRepository getTemaRepository() {
        return null;
    }

    @Override
    public RodadaRepository getRodadaRepository() {
        return null;
    }

    @Override
    public JogadorRepository getJogadorRepository() {
        return null;
    }
}