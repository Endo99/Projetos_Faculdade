package lab2.dc.unifil.br;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FabricaListas {

    /**
     * Cria uma lista de integers crescente, com quantidade de elementos especificável.
     * @param qtdeElems Quantidade de elementos da lista a ser gerada.
     * @return Uma lista cuja única característica pré-definida é ter elementos classificados
     * crescentemente.
     */
    public static List<Integer> fabricarListaIntegersCrescente(int qtdeElems) {
        return IntStream.range(0, qtdeElems).boxed().collect(Collectors.toList());
        //throw new RuntimeException("O aluno ainda não implementou esse método.");
    }

    /**
     * Cria uma lista de integers decrescente, com quantidade de elementos especificável.
     * @param qtdeElems Quantidade de elementos da lista a ser gerada.
     * @return Uma lista cuja única característica pré-definida é ter elementos classificados
     * decrescentemente.
     */
    public static List<Integer> fabricarListaIntegersDecrescente(int qtdeElems) {
        List<Integer> listaIntegerDecrescente = IntStream.range(0, qtdeElems).boxed().collect(Collectors.toList());
        listaIntegerDecrescente.sort((Integer x, Integer y) -> Integer.compare(x, y));
        return listaIntegerDecrescente;
        //throw new RuntimeException("O aluno ainda não implementou esse método.");
    }

    /**
     * Cria uma lista de integers, com quantidade de elementos especificável.
     * @param qtdeElems Quantidade de elementos da lista a ser gerada.
     * @return Uma lista com elementos aleatórios e tamanho pré-definido.
     */
    public static List<Integer> fabricarListaIntegersAleatoria(int qtdeElems) {


        return fabricarListaIntegersAleatoria(qtdeElems, rngPadrao);
    }

    /**
     * Cria uma lista de integers, com quantidade de elementos especificável.
     * @param qtdeElems Quantidade de elementos da lista a ser gerada.
     * @param rng Gerador de números aleatórios a ser utilizado para construir a lista.
     * @return Uma lista com elementos aleatórios e tamanho pré-definido.
     */
    public static List<Integer> fabricarListaIntegersAleatoria(int qtdeElems, Random rng) {

        return IntStream.range(0, qtdeElems).boxed().collect(Collectors.toList());
        // throw new RuntimeException("O aluno ainda não implementou esse método.");
    }



    private static Random rngPadrao = new Random("Pipeline de integers.".hashCode());

    /**
     * Ninguém pode construir instâncias dessa classe, que é meramente um conjunto
     * de utilidade de listas.
     */
    private FabricaListas() {}
}
