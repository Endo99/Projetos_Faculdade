package lab2.dc.unifil.br;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Function;

public class Classificadores {
    /**
     * Ordena a lista com o método Selection Sort
     * @param lista recebe uma lista de Integer e classifica em crescente
     */
    public static void selectionSort(List<Integer> lista) {

        for (int i = 0; i < lista.size(); i++) {
            int menorIdc = encontrarIndiceMenorList(lista, i);
            permutar(lista, menorIdc, i);
        }
    }

    /**
     * Ordena a lista com o método Selection Sort
     * @param lista recebe uma lista de Integer e classifica em decrescente
     */
    public static void selectionSortDecrescente(List<Integer> lista) { // Melhor caso: 2n^2 + 7n + 1, Pior caso: 3n^2 + 7n + 1

        for (int i = 0; i < lista.size(); i++) { // 2 * n
            int menorIdc = encontrarIndiceMenorListInverso(lista, i); // 2 * n
            permutar(lista, menorIdc, i); // n * 3
        }
    }

    /**
     * Ordena a lista com o método Insertion Sort
     * @param lista recebe uma lista de Integer e classifica em crescente
     */
    public static void insertionSort(List<Integer> lista) { // Melhor caso: Ω(n), Pior caso: O(n^2).

        for (int i = 1; i < lista.size(); i++) { //  // g(1 + n-1) -> g(n) -> Ω(n) | O(n) -> Θ(n)
            Integer elem = lista.get(i); // 1 * Ω(n) -> Ω(n) | O(n) -> Θ(n)

            int j = i; // Ω(n) | O(n) -> Θ(n)
            while (j > 0 && lista.get(j - 1) > elem) { // Ω(n) | O(n) * O(n) -> O(n^2)
                lista.set(j, lista.get(j - 1)); // O(n^2)

                j--; // O(n^2)
            }

            lista.set(j, elem); // Ω(n) | O(n) -> Θ(n)
        }

    }

    /**
     * Ordena a lista com o método Insertion Sort
     * @param lista recebe uma lista de Integer e classifica em decrescente
     */
    public static void insertionSortDecrescente(List<Integer> lista) {

        for (int i = 1; i < lista.size(); i++) {
            Integer elem = lista.get(i);

            int j = i;
            while (j > 0 && lista.get(j - 1) < elem) {
                lista.set(j, lista.get(j - 1));

                j--;
            }

            lista.set(j, elem);
        }

    }


    /**
     * Ordena a lista com o método BubbleSort
     * @param lista Recebe uma lista de Integer e classifica em crescente
     */
    public static void bubbleSort(List<Integer> lista) { // Melhor caso: 2n + 1, Pior caso: 5n^2 - 2n.
        boolean houvePermuta;
        do {
            houvePermuta = false; // n

            for (int i = 1; i < lista.size(); i++) { // n*n
                if (lista.get(i - 1) > lista.get(i)) {// // n-1 (n)
                    permutar(lista, i - 1, i); // n-1 (n) * 3
                    houvePermuta = true; // n-1 (n)
                }
            }
        } while (houvePermuta); // n
    }

    /**
     * Ordena a lista com o método BubbleSort
     * @param lista Recebe uma lista de Integer e classifica em decrescente
     */
    public static void bubbleSortDecrescente(List<Integer> lista) {
        boolean houvePermuta;
        do {
            houvePermuta = false;

            for (int i = 1; i < lista.size(); i++) {
                if (lista.get(i - 1) < lista.get(i)) {
                    permutar(lista, i - 1, i);
                    houvePermuta = true;
                }
            }
        } while (houvePermuta);
    }


    /**
     * Ordena a lista com o método QuickSort
     * @param lista Recebe uma lista de Integer e classifica em crescente
     */
    public static void quicksort(List<Integer> lista) { quicksort(lista, (vs) -> vs.get(rng.nextInt(vs.size()))); }

    public static void quicksort(List<Integer> lista, Function<List<Integer>, Integer> escolhedorPivo) { // Melhor caso: 10n + 10 , Pior caso:
        // Caso base
        if (lista.size() <= 1) return; // n + 1

        // Casos de subdivisão recursiva
        Integer pivo = escolhedorPivo.apply(lista); // 1
        int idxPivo = reorganizar(lista, pivo, (l, r) -> l.compareTo(r)); // 9n + 6

        quicksort(lista.subList(0, idxPivo)); // 1
        quicksort(lista.subList(idxPivo + 1, lista.size())); // 1
    }

    /**
     * Reorganiza a lista, com um pivo e compara o pivo, se o indice for maior, inseri no lado direito e se for menor,
     * inseri no lado direito.
     * @param lista Recebe uma lista para organizar
     * @param pivo  Valor que será como uma ajuda.
     * @param cmp   Compara dois elementos.
     * @return Retorna uma lista Organazinada crescente.
     */
    private static int reorganizar(List<Integer> lista, Integer pivo, Comparator<Integer> cmp) { // Melhor caso: 9n + 6, Pior caso: 13n + 1
        int l = 0, r = lista.size() - 1; // 1
        while (true) { // 2 * n
            while (cmp.compare(lista.get(l), pivo) < 0) l++; // 2 * n
            while (cmp.compare(lista.get(r), pivo) > 0) r--; // 2 * n

            if (l < r) { //2 * n
                permutar(lista, l, r); // 2 * n * 3
            } else return l; // 2 * n
        }
    }

    /**
     * Ordena a lista com o método QuickSort
     * @param lista Recebe uma lista de Integer e classifica em decrescente
     */
    public static void quicksortDecrescente(List<Integer> lista) { quicksortDecrescente(lista, (vs) -> vs.get(rng.nextInt(vs.size()))); }

    public static void quicksortDecrescente(List<Integer> lista, Function<List<Integer>, Integer> escolhedorPivo) {
        // Caso base
        if (lista.size() <= 1) return;

        // Casos de subdivisão recursiva
        Integer pivo = escolhedorPivo.apply(lista);
        int idxPivo = reorganizarDecrescente(lista, pivo, (l, r) -> l.compareTo(r));

        quicksort(lista.subList(0, idxPivo));
        quicksort(lista.subList(idxPivo + 1, lista.size()));
    }

    /**
     * Reorganiza a lista, com um pivo e compara o pivo, se o indice for maior, inseri no lado direito e se for menor,
     * inseri no lado direito.
     * @param lista Recebe uma lista para organizar
     * @param pivo  Valor que será como uma ajuda.
     * @param cmp   Compara dois elementos.
     * @return Retorna uma lista Organazinada crescente.
     */
    private static int reorganizarDecrescente(List<Integer> lista, Integer pivo, Comparator<Integer> cmp) {
        int l = 0, r = lista.size() - 1;
        while (true) {
            while (cmp.compare(lista.get(l), pivo) > 0) l++;
            while (cmp.compare(lista.get(r), pivo) < 0) r--;

            if (l < r) {
                permutar(lista, l, r);
            } else return l;
        }
    }

    /**
     * Ordena a lista com o método MergeSort
     * @param lista Recebe uma lista de Integer e classifica em crescente
     */
    public static void mergesort(List<Integer> lista) { // Pior caso: 7n log n + 12 log n -> g(7n log n + 12 log n) -> O(n log n)
        // Casos base
        if (lista.size() <= 1) return;

        // Casos de subdivisão recursiva
        final int idxMeioLista = lista.size() / 2;
        List<Integer> esquerda = lista.subList(0, idxMeioLista);
        mergesort(esquerda);

        List<Integer> direita = lista.subList(idxMeioLista, lista.size());
        mergesort(direita);

        merge(lista, esquerda, direita);
    }

    /**
     * Classifica uma lista em ordem crescente.
     * @param lista Recebe uma lista de Integer.
     * @param esquerda  Recebe uma lista para ordenar em um lado, o lado menor.
     * @param direita   Recebe uma lista para ordenar em um lado, o lado maior.
     */
    private static void merge(List<Integer> lista, List<Integer> esquerda, List<Integer> direita) { // Pior caso: 7n + 6
        List<Integer> merged = new ArrayList<>(lista);

        int idxE = 0, idxD = 0, idxL = 0;
        while (idxE < esquerda.size() && idxD < direita.size()) {
            if (esquerda.get(idxE) < direita.get(idxD)) {
                merged.set(idxL, esquerda.get(idxE));
                idxE++;
            } else {
                merged.set(idxL, direita.get(idxD));
                idxD++;
            }
            idxL++;
        }

        int idxF;
        List<Integer> faltantes;
        if (idxE < esquerda.size()) {
            faltantes = esquerda;
            idxF = idxE;
        } else {
            faltantes = direita;
            idxF = idxD;
        }

        while (idxF < faltantes.size()) {
            merged.set(idxL, faltantes.get(idxF));
            idxL++; idxF++;
        }

        for (int i = 0; i < lista.size(); i++) { // n + 1
            lista.set(i, merged.get(i));  // n
        }
    }

    /**
     * Ordena a lista com o método MergeSort
     * @param lista Recebe uma lista de Integer e classifica em decrescente
     */
    public static void mergesortDecrescente(List<Integer> lista) {
        // Casos base
        if (lista.size() <= 1) return;

        // Casos de subdivisão recursiva
        final int idxMeioLista = lista.size() / 2;
        List<Integer> esquerda = lista.subList(0, idxMeioLista);
        mergesort(esquerda);

        List<Integer> direita = lista.subList(idxMeioLista, lista.size());
        mergesort(direita);

        mergeDecrescente(lista, esquerda, direita);
    }

    /**
     * Classifica uma lista em ordem crescente.
     * @param lista Recebe uma lista de Integer.
     * @param esquerda  Recebe uma lista para ordenar em um lado, o lado menor.
     * @param direita   Recebe uma lista para ordenar em um lado, o lado maior.
     */
    private static void mergeDecrescente(List<Integer> lista, List<Integer> esquerda, List<Integer> direita) {
        List<Integer> merged = new ArrayList<>(lista);

        int idxE = 0, idxD = 0, idxL = 0;
        while (idxE < esquerda.size() && idxD < direita.size()) {
            if (esquerda.get(idxE) < direita.get(idxD)) {
                merged.set(idxL, esquerda.get(idxE));
                idxE++;
            } else {
                merged.set(idxL, direita.get(idxD));
                idxD++;
            }
            idxL++;
        }

        int idxF;
        List<Integer> faltantes;
        if (idxE < esquerda.size()) {
            faltantes = esquerda;
            idxF = idxE;
        } else {
            faltantes = direita;
            idxF = idxD;
        }

        while (idxF < faltantes.size()) {
            merged.set(idxL, faltantes.get(idxF));
            idxL++; idxF++;
        }

        for (int i = 0; i < lista.size(); i++) {
            lista.set(i, merged.get(i));
        }
    }

    /**
     * Encontra o menor índice numa lista de Integer.
     * @param lista Recebe uma lista
     * @param indice O indice que será testado
     * @return  O índice menor.
     */
    private static int encontrarIndiceMenorListInverso(List<Integer> lista, int indice) { // Melhor caso: 3
        int menor = indice;
        for  (int i = indice+1; i < lista.size(); i++) {
            if (lista.get(menor) < lista.get(i)) {
                menor = i;
            }
        }
        return menor;
    }

    /**
     * Encontra o menor índice numa lista de Integer.
     * @param lista Recebe uma lista
     * @param indice O indice que será testado
     * @return  O índice menor.
     */
    private static int encontrarIndiceMenorList(List<Integer> lista, int indice) {
        int menor = indice;
        for  (int i = indice+1; i < lista.size(); i++) {
            if (lista.get(menor) > lista.get(i)) {
                menor = i;
            }
        }
        return menor;
    }

    /**
     * Permuta dois objetos.
     * @param lista Lista que vai conter os números a ser permutado.
     * @param a O indice que será avaliado.
     * @param b O indice que será trocado.
     */
    private static void permutar(List<Integer> lista, int a, int b) { // Melhor caso : 3
        Integer permutador = lista.get(a); //1
        lista.set(a, lista.get(b)); //1
        lista.set(b, permutador); //1
    }

    private static boolean isOrdenada(List<Integer> lista) {
        for (int i = 1; i < lista.size(); i++)
            if (lista.get(i - 1) > lista.get(i))
                return false;

        return true;
    }

    private static Random rng = new Random("Seed constante repetível".hashCode());
}