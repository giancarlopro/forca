package br.edu.iff.dominio.repositorio.memoria;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.palavra.repositorio.memoria.MemoriaPalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.bancodepalavras.dominio.tema.repositorio.memoria.MemoriaTemaRepository;
import br.edu.iff.dominio.RepositoryFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.jogador.repositorio.memoria.MemoriaJogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.jogoforca.dominio.rodada.repositorio.memoria.MemoriaRodadaRepository;

/**
 * MemoriaRepositoryFactory
 */
public class MemoriaRepositoryFactory implements RepositoryFactory {
    private static MemoriaRepositoryFactory soleInstance = null;

    public static MemoriaRepositoryFactory getSoleInstance() {
        if (soleInstance == null)
            soleInstance = new MemoriaRepositoryFactory();

        return soleInstance;
    }

    private MemoriaRepositoryFactory() {}

    @Override
    public PalavraRepository getPalavraRepository() {
        return MemoriaPalavraRepository.getSoleInstance();
    }

    @Override
    public TemaRepository getTemaRepository() {
        return MemoriaTemaRepository.getSoleInstance();
    }

    @Override
    public RodadaRepository getRodadaRepository() {
        return MemoriaRodadaRepository.getSoleInstance();
    }

    @Override
    public JogadorRepository getJogadorRepository() {
        return MemoriaJogadorRepository.getSoleInstance();
    }
}