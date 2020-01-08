package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;

/**
 * Rodada
 */
public class Rodada extends ObjetoDominioImpl {
    private static int maxPalavras = 3;
    private static int maxErros = 10;
    private static int pontosQuandoDescobreTodasAsPalavras = 100;
    private static int pontosPorLetraEncoberta = 15;

    private static BonecoFactory bonecoFactory = null;

    public static int getMaxPalavras() {
        return maxPalavras;
    }

    public static void setMaxPalavras(int max) {
        maxPalavras = max;
    }

    public static int getMaxErros() {
        return maxErros;
    }

    public static void setMaxErros(int max) {
        maxErros = max;
    }

    public static int getPontosQuandoDescobreTodasAsPalavras() {
        return pontosQuandoDescobreTodasAsPalavras;
    }

    public static void setPontosQuandoDescobreTodasAsPalavras(int pontos) {
        pontosQuandoDescobreTodasAsPalavras = pontos;
    }

    public static int getPontosPorLetraEncoberta() {
        return pontosPorLetraEncoberta;
    }

    public static void setPontosPorLetraEncoberta(int pontos) {
        pontosPorLetraEncoberta = pontos;
    }

    public static BonecoFactory getBonecoFactory() {
        return bonecoFactory;
    }

    public static void setBonecoFactory(BonecoFactory factory) {
        bonecoFactory = factory;
    }

    public static Rodada criar(Long id, List<Palavra> palavras, Jogador jogador) {
        return new Rodada(id, palavras, jogador);
    }

    public static Rodada recontituir(Long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
        return new Rodada(id, itens, erradas, jogador);
    }

    private List<Item> itens;
    private Jogador jogador;
    private Boneco boneco;

    private Set<Letra> certas;
    private Set<Letra> erradas;
    
    private Rodada(Long id, List<Palavra> palavras, Jogador jogador) {
        super(id);
        if (getBonecoFactory() == null) {
            throw new RuntimeException("bonecoFactory não foi setado.");
        }
        boneco = getBonecoFactory().getBoneco();

        this.jogador = jogador;
        this.certas = new HashSet<>();
        this.erradas = new HashSet<>();
        this.itens = new ArrayList<>(palavras.size());

        for (int i = 0; i < palavras.size(); i++) {
            this.itens.add(Item.criar(i, palavras.get(i)));
        }
    }

    private Rodada(Long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
        super(id);
        if (getBonecoFactory() == null) {
            throw new RuntimeException("bonecoFactory não foi setado.");
        }
        boneco = getBonecoFactory().getBoneco();

        this.jogador = jogador;
        this.certas = new HashSet<>();
        this.erradas = new HashSet<>();
        this.itens = new ArrayList<>(itens.size());

        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            this.itens.add(item);

            for (Letra correta: item.getLetrasDescobertas()) {
                this.certas.add(correta);
            }
        }

        for (Letra errada: erradas) {
            this.erradas.add(errada);
        }
    }

    public Jogador getJogador() {
        return this.jogador;
    }

    public Tema getTema() {
        return this.itens.get(0).getPalavra().getTema();
    }

    public List<Palavra> getPalavras() {
        List<Palavra> palavras = new ArrayList<>();
        for (Item i: itens) {
            palavras.add(i.getPalavra());
        }
        return palavras;
    }

    public int getNumPalavras() {
        return itens.size();
    }

    public Set<Letra> getTentativas() {
        Set<Letra> tentativas = new HashSet<>();
        tentativas.addAll(certas);
        tentativas.addAll(erradas);

        return tentativas;
    }

    public Set<Letra> getCertas() {
        return Collections.unmodifiableSet(certas);
    }

    public Set<Letra> getErradas() {
        return Collections.unmodifiableSet(erradas);
    }

    public int calcularPontos() {
        if (!descobriu())
            return 0;
        
        int pontos = getPontosQuandoDescobreTodasAsPalavras();

        for (Item item: itens) {
            pontos += item.calcularPontosLetrasEncobertas(getPontosPorLetraEncoberta());
        }

        return pontos;
    }

    public boolean arriscou() {
        for (Item item: itens)
            if (item.arriscou())
                return true;
        
        return false;
    }

    public boolean descobriu() {
        for (Item item: itens)
            if (!item.descobriu())
                return false;
        
        return true;
    }

    private boolean atingiuMaxErros() {
        return getQtdeTentativaRestantes() == 0;
    }

    public boolean encerrou() {
        if (arriscou() || descobriu() || atingiuMaxErros())
            return true;

        return false;
    }

    private void atualizarPontosDoJogador() {
        // TODO: jogador.setPontuacao tem visibilidade de pacote e aqui não é do mesmo pacote
        // int pontos = jogador.getPontuacao();
        // jogador.setPontuacao
    }

    public void tentar(char codigo) {
        if (encerrou())
            return;

        Map<Item, Boolean> acertou = new HashMap<>();
        LetraFactory factory = Palavra.getLetraFactory();

        for (Item item: itens) {
            if (item.tentar(codigo)) {
                certas.add(factory.getLetra(codigo));
                acertou.put(item, true);
            } else {
                acertou.put(item, false);
            }
        }

        if (!acertou.containsValue(true)) {
            erradas.add(factory.getLetra(codigo));
        }

        if (encerrou())
            atualizarPontosDoJogador();
    }

    public void arriscar(List<String> palavras) {
        if (encerrou())
            return;

        int aux = palavras.size() < itens.size()? palavras.size(): itens.size();

        for (int i = 0; i < aux; i++) {
            itens.get(i).arriscar(palavras.get(i));
        }

        if (encerrou())
            atualizarPontosDoJogador();
    }

    public void exibirItens(Object contexto) {
        for (Item item: itens)
            item.exibir(contexto);
    }

    public void exibirBoneco(Object contexto) {
        boneco.exibir(contexto, getQtdeErros());
    }

    public void exibirPalavras(Object contexto) {
        for (Palavra palavra: getPalavras())
            palavra.exibir(contexto);
    }

    public int getQtdeTentativaRestantes() {
        return getMaxErros() - erradas.size();
    }

    public int getQtdeErros() {
        return erradas.size();
    }

    public int getQtdeAcertos() {
        return certas.size();
    }

    public int getQtdeTentativas() {
        return getQtdeErros() + getQtdeAcertos();
    }
}