package br.edu.iff.bancodepalavras.dominio.letra;

/**
 * LetraFactory
 */
public interface LetraFactory {
    public Letra getLetra(char codigo);
    public Letra getLetraEncoberta();
}