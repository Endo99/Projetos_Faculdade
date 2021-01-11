package br.unifil.dc.lab2;

import java.util.List;
import java.util.ListIterator;

/**
 * Write a description of class AlgoritmosAnimados here.
 * 
 * @author Maria Isabelly Santos, Pedro Rocha e Wellington
 * @version 26/04/2020
 */
public class AlgoritmosAnimados {
    public static Gravador listaEstatica(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Valores da lista imutável");
        return anim;
    }

    public static Gravador pesquisaSequencial(List<Integer> valores, int chave) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Inicio de pesquisa sequencial");

        int i = 0;
        anim.gravarIndiceDestacado(valores, i, "Pesquisa sequencial");
        while (i < valores.size() && valores.get(i) != chave) {
            i++;
            anim.gravarIndiceDestacado(valores, i, "Pesquisa sequencial");
        }

        if (i < valores.size()) {
            anim.gravarIndiceDestacado(valores, i, "Chave encontrada");
        } else {
            anim.gravarLista(valores, "Chave não encontrada");
        }

        return anim;
    }


    public static Gravador classificarPorBolha(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Disposição inicial");

        boolean isPermuta;
        do {
            isPermuta = false;

            for (int i = 1; i < valores.size(); i++) {
                anim.gravarComparacaoSimples(valores, i - 1, i);
                if (valores.get(i - 1) > valores.get(i)) {
                    permutar(valores, i - 1, i);
                    anim.gravarPosTrocas(valores, i - 1, i);
                    isPermuta = true;
                }
            }
        } while (isPermuta);

        anim.gravarLista(valores, "Disposição final");
        return anim;

    }

    public static Gravador classificadorPorSelecao(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Disposição inicial");

        for (int i = 0; i < valores.size(); i++) {
            int menorIndice = menorElem(valores, i);
            permutar(valores, menorIndice, i);
            anim.gravarPosTrocas(valores, menorIndice, i);
        }

        anim.gravarLista(valores, "Disposição final");
        return anim;

    }

    private static int menorElem(List<Integer> num, int indiceInicial){
        Gravador anim = new Gravador();

        int menor = indiceInicial;
        for (int i = indiceInicial + 1; i < num.size(); i++) {
            anim.gravarComparacaoSimples(num, menor, i);
            if (num.get(menor) > num.get(i))
                menor = i;
        }
        return menor;

    }

    private static void permutar(List<Integer> lista, int x, int y) {
        Integer perm = lista.get(x);
        lista.set(x, lista.get(y));
        lista.set(y, perm);

    }
}