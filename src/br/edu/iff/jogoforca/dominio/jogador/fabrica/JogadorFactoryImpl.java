package br.edu.iff.jogoforca.dominio.jogador.fabrica;

import br.edu.iff.dominio.EntityFactory;
import br.edu.iff.dominio.RepositoryException;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;

/**
 * JogadorFactoryImpl
 */
public class JogadorFactoryImpl extends EntityFactory implements JogadorFactory {
    private static JogadorFactoryImpl soleInstance = null;

    public static void createSoleInstance(JogadorRepository repository) {
        soleInstance = new JogadorFactoryImpl(repository);
    }

    public static JogadorFactoryImpl getSoleInstance() {
        return soleInstance;
    }

    private JogadorFactoryImpl(JogadorRepository repository) {
        super(repository);
    }

    private JogadorRepository getJogadorRepository() {
        return (JogadorRepository) getRepository();
    }

    @Override
    public Jogador getJogador(String nome) {
        Jogador jogador = Jogador.criar(getProximoId(), nome);

        try {
            getJogadorRepository().inserir(jogador);
        } catch (RepositoryException re) {
            throw new RuntimeException("não foi possível salvar o jogador no repositorio");
        }

        return jogador;
    }
}