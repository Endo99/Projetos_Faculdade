package lab2.dc.unifil.br;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Realiza benchmarkings

        List<Medicao> medicoesSelectionSortCres = Cronometro.benchmarkCrescimentoAlgoritmo(
                1, 10, 1, 10,
                FabricaListas::fabricarListaIntegersCrescente,
                Classificadores::selectionSort
        );

        List<Medicao> medicoesSelectionSortDecre = Cronometro.benchmarkCrescimentoAlgoritmo(
                1, 10, 1, 10,
                FabricaListas::fabricarListaIntegersDecrescente,
                Classificadores::selectionSortDecrescente
        );

        List<Medicao> medicoesQuickSortCres = Cronometro.benchmarkCrescimentoAlgoritmo(
                1, 10, 1, 10,
                FabricaListas::fabricarListaIntegersCrescente,
                Classificadores::quicksort
        );

        List<Medicao> medicoesQuickSortDescre = Cronometro.benchmarkCrescimentoAlgoritmo(
                1, 10, 1, 10,
                FabricaListas::fabricarListaIntegersDecrescente,
                Classificadores::quicksortDecrescente
        );

        List<Medicao> medicoesMegeSortCresc = Cronometro.benchmarkCrescimentoAlgoritmo(
                1, 10, 1, 10,
                FabricaListas::fabricarListaIntegersDecrescente,
                Classificadores::mergesort
        );

        List<Medicao> medicoesMegeSortDescre = Cronometro.benchmarkCrescimentoAlgoritmo(
                1, 10, 1, 10,
                FabricaListas::fabricarListaIntegersDecrescente,
                Classificadores::mergesortDecrescente
        );

        List<Medicao> medicoesBubbleSortCresc = Cronometro.benchmarkCrescimentoAlgoritmo(
                1, 10, 1, 10,
                FabricaListas::fabricarListaIntegersDecrescente,
                Classificadores::bubbleSort
        );

        List<Medicao> medicoesBubbleSorDescre = Cronometro.benchmarkCrescimentoAlgoritmo(
                1, 10, 1, 10,
                FabricaListas::fabricarListaIntegersDecrescente,
                Classificadores::bubbleSortDecrescente
        );

        List<Medicao> medicoesInsertionSortCresc = Cronometro.benchmarkCrescimentoAlgoritmo(
                1, 10, 1, 10,
                FabricaListas::fabricarListaIntegersDecrescente,
                Classificadores::insertionSort
        );

        List<Medicao> medicoesInsertionSortDescre = Cronometro.benchmarkCrescimentoAlgoritmo(
                1, 10, 1, 10,
                FabricaListas::fabricarListaIntegersDecrescente,
                Classificadores::insertionSortDecrescente
        );

        // Plotta gráfico com resultados levantados
        TabelaTempos tt = new TabelaTempos();
        tt.setTitulo("Tempo para ordenação");
        tt.setEtiquetaX("Qtde elementos lista");
        tt.setEtiquetaY("Tempo (s)");
        tt.setLegendas("Quick Sort Decrescente");
        for (int i = 0; i < medicoesQuickSortDescre.size(); i++) {
            Medicao amostra = medicoesQuickSortDescre.get(i);

            tt.anotarAmostra(amostra.getN(),
                    amostra.getTempoSegundos());
        }
//        for (int i = 0; i < medicoesSelectionSortDecre.size(); i++) {
//            Medicao amostrasSelection = medicoesSelectionSortDecre.get(i);
//
//            tt.anotarAmostra(amostrasSelection.getN(),
//                    amostrasSelection.getTempoSegundos());
//        }
        tt.exibirGraficoXY();
    }


}
