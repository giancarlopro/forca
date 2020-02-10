package br.edu.iff.bancodepalavras.dominio.tema;

import java.util.List;

/**
 * TemaAppService
 */
public class TemaAppService {
    private static TemaAppService soleInstance = null;

    public static void createSoleInstance(TemaRepository TemaRepository, TemaFactory TemaFactory) {
        soleInstance = new TemaAppService(TemaRepository, TemaFactory);
    }

    public static TemaAppService getSoleInstance() {
        return soleInstance;
    }

    TemaRepository repository;
    TemaFactory factory;

    private TemaAppService(TemaRepository repository, TemaFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public Tema novoTema(String nome) {
        List<Tema> temas = repository.getPorNome(nome);

        if (temas.size() != 0)
            return temas.get(0);

        return factory.getTema(nome);
    }
}