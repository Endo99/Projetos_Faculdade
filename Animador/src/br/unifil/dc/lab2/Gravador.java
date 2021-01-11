package br.unifil.dc.lab2;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Write a description of class Gravador here.
 *
 * @author Maria Isabelly Santos, Pedro Rocha e Wellington
 * @version 26/04/2020
 */
public class Gravador
{
    public Gravador() {
        this.seqGravacoes = new ArrayList<Transparencia>();
    }


    /**
     * @param lista Recebe uma lista atualizada.
     * @param nome Nome dado à ação para ser processada.
     */
    public void gravarLista(List<Integer> lista, String nome) {
        List<Color> cores = novaListaColors(lista.size(), Color.BLUE);
        ListaGravada gravacao = new ListaGravada(List.copyOf(lista), cores, nome);
        seqGravacoes.add(gravacao);
    }

    /**
     * @param lista Recebe uma lista atualizada.
     * @param i Variável usada no índice.
     * @param nome Nome dado à ação para ser processada.
     */
    public void gravarIndiceDestacado(List<Integer> lista, int i, String nome) {
        List<Color> cores = novaListaColors(lista.size(), Color.BLUE);
        cores.set(i, Color.YELLOW);
        ListaGravada gravacao = new ListaGravada(List.copyOf(lista), cores, nome);
        seqGravacoes.add(gravacao);
    }


    /**
     * @param lista Recebe uma lista atualizada.
     * @param i Variável usada na primeira comparação.
     * @param j Variável usada na segunda compração.
     */
    public void gravarComparacaoSimples(List<Integer> lista, int i, int j) {
        List<Color> cores = novaListaColors(lista.size(), Color.BLUE);
        cores.set(i, Color.GRAY);
        cores.set(j, Color.GRAY);
        ListaGravada gravacao = new ListaGravada(List.copyOf(lista), cores, "Comparação");
        seqGravacoes.add(gravacao);
    }


    /**
     * @param lista Recebe uma lista atualizada.
     * @param i Variável usada na primeira comparação.
     * @param j Variável usada na segunda compração.
     */
    public void gravarPosTrocas(List<Integer> lista, int i, int j) {
        List<Color> cores = novaListaColors(lista.size(), Color.BLUE);
        cores.set(i, Color.YELLOW);
        cores.set(j, Color.YELLOW);
        ListaGravada gravacao = new ListaGravada(List.copyOf(lista), cores, "Pós-troca");
        seqGravacoes.add(gravacao);
    }

    public ListIterator<Transparencia> getFilme() {
        return seqGravacoes.listIterator();
    }

    private static List<Color> novaListaColors(int numElems, Color cor) {
        ArrayList<Color> lista = new ArrayList<>(numElems);
        for (; numElems > 0; numElems--) lista.add(cor);
        return lista;
    }

    private List<Transparencia> seqGravacoes;
}
