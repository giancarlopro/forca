package br.edu.iff.bancodepalavras.dominio.letra.fabrica;

import java.util.HashMap;
import java.util.Map;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;

/**
 * LetraFactoryImpl
 */
public abstract class LetraFactoryImpl {
    private Letra encoberta = null;
    private Map<Character, Letra> pool;

    protected LetraFactoryImpl() {
        pool = new HashMap<>();
        encoberta = criarLetra('*');
    }

    protected abstract Letra criarLetra(char codigo);

    public final Letra getLetra(char codigo) {
        Letra letra = pool.get(codigo);

        if (letra == null) {
            letra = criarLetra(codigo);
            pool.put(codigo, letra);
        }

        return letra;
    }

    public final Letra getLetraEncoberta() {
        return encoberta;
    }
}