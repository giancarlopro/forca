package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorNaoEncontradoException;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

/**
 * RodadaAppService
 */
public class RodadaAppService {
    private static RodadaAppService soleInstance = null;

    public static void createSoleInstance(RodadaFactory factory, RodadaRepository repository, JogadorRepository jogadorRepository) {
        soleInstance = new RodadaAppService(factory, repository, jogadorRepository);
    }

    public static RodadaAppService getSoleInstance() {
        return soleInstance;
    }

    private RodadaFactory factory;
    private RodadaRepository repository;
    private JogadorRepository jogadorRepository;

    private RodadaAppService(RodadaFactory factory, RodadaRepository repository, JogadorRepository jogadorRepository) {
        this.factory = factory;
        this.repository = repository;
        this.jogadorRepository = jogadorRepository;
    }

    public Rodada novaRodada(Jogador jogador) {
        return factory.getRodada(jogador);
    }

    public Rodada novaRodada(Long idJogador) throws JogadorNaoEncontradoException {
        Jogador jogador = jogadorRepository.getPorId(idJogador);

        if (jogador == null) throw new JogadorNaoEncontradoException(idJogador.toString());

        return novaRodada(jogador);
    }

    public Rodada novaRodada(String nomeJogador) throws JogadorNaoEncontradoException {
        Jogador jogador = jogadorRepository.getPorNome(nomeJogador);

        if (jogador == null) throw new JogadorNaoEncontradoException(nomeJogador);

        return novaRodada(jogador);
    }

    public boolean salvarRodada(Rodada rodada) {
        try {
            repository.inserir(rodada);
            return true;
        } catch (RepositoryException re) {
            return false;
        }
    }
}