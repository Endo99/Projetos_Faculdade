package lab2.dc.unifil.br;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Cronometro {

    /**
     * Faz benchmarkings do algoritmo que recebe uma entrada N, inicialmente igual a nInicial,
     * até nFinal, incrementando a nPasso. Retorna uma lista com todas essas medições, classificada
     * do menor N ao maior.
     *
     * @param nInicial Valor escalar de N inicialmente.
     * @param nFinal Valor escalar de N que interrompe as medições.
     * @param nPasso Quantidade de incremento em N a cada iteração de medições.
     * @param repeticoes Quantidade de vezes que cada medição é feita. Quanto maior o valor,
     *                   mais precisa a medição, mas mais demorado o processo total.
     * @param fabricadorCobaias Método que cria estruturas de dados aceitas como entrada pelo
     *                          algoritmo em teste, com dimensão configurável para permitir o
     *                          benchmarking em crescimento.
     * @param algoritmo Algoritmo a ser testado.
     * @param <T> Tipo da estrutura de dados do algoritmo.
     * @return Lista com medições de tempo, classificada do menor ao maior N.
     */
    public static <T> List<Medicao> benchmarkCrescimentoAlgoritmo(
            int nInicial, int nFinal, int nPasso, int repeticoes,
            Function<Integer, T> fabricadorCobaias,
            Consumer<T> algoritmo) {

            int medicao = 1;
            List<Medicao> listaMedicoes = new ArrayList<Medicao>();

            for (int i = nInicial; i < nFinal; i+=nPasso) {
                final int number = i;
                Supplier<T> sp = () -> fabricadorCobaias.apply(number);
                listaMedicoes.add(new Medicao(medicao, benchmarkAlgoritmo(sp, algoritmo, repeticoes)));
                medicao++;
                nInicial= nInicial + nPasso;
        }
            //throw new RuntimeException("O aluno ainda não implementou essa funcionalidade.");
        return listaMedicoes;
    }


    /**
     * Retorna o menor tempo, que rebece um Supplier recriadorCobaia, Consumer algoritmo, int repetições.
     * @param recriadorCobaia Método que recria estruturas de dados aceitas pelo algoritmo em teste, com dimensão configurável para permitir o benchmarking.
     * @param algoritmo Algoritmo a ser testado.
     * @param repeticoes  Tantas vezes que irá ser executado o algoritmo.
     * @param <T>   Tipo da estrutura de dados do algoritmo.
     * @return O tempo medido do algoritmo testado.
     */
    public static <T> double benchmarkAlgoritmo(Supplier<T> recriadorCobaia, Consumer<T> algoritmo, int repeticoes) {
        Cronometro cron = new Cronometro();
        double menorTempo = Double.POSITIVE_INFINITY;
        for (int i = 0; i < repeticoes; i++) {
            T cobaia = recriadorCobaia.get();

            cron.zerar();
            cron.iniciar();
            algoritmo.accept(cobaia);
            double ultimoTempo = cron.parar();

            menorTempo = Math.min(menorTempo, ultimoTempo);
        }

        return menorTempo;
    }

    /**
     * Construtor padrão da classe.
     */
    public Cronometro() {

        tempoInicio = 0;
        tempoFim = 0;
        tempoTranscorrido = 0;
        cadenciado = true;

       // throw new RuntimeException("O aluno ainda não implementou essa funcionalidade.");
    }
    
    /**
     * Inicia ou reinicia a contagem de tempo. Nunca zera o último estado do contador. Se o tempo já
     * estiver correndo, não faz nada.
     */
    public void iniciar() {

        if(cadenciado){
            cadenciado = false;
            tempoInicio = System.nanoTime();
        }

        //throw new RuntimeException("O aluno ainda não implementou essa funcionalidade.");
    }
    
    /**
     * Para a contagem de tempo e retorna uma leitura do tempo decorrido.
     * 
     * @return Tempo decorrido até o momento da parada, em milissegundos.
     */
    public double parar() {

        tempoFim = System.nanoTime();
        tempoTranscorrido += tempoFim - tempoInicio;
        cadenciado = true;
        return tempoTranscorrido;

        //throw new RuntimeException("O aluno ainda não implementou essa funcionalidade.");
    }
    
    /**
     * Retorna o tempo decorrido contado até então, independente se está parado ou correndo. Não
     * altera o estado de contagem (parado/correndo).
     * 
     * @return Tempo decorrido contado pelo cronômetro, em milissegundos.
     */
    public double lerTempoEmMilissegundos() {

        double tempoParcial  = System.nanoTime();
        return tempoTranscorrido + (tempoParcial - tempoInicio);

        //throw new RuntimeException("O aluno ainda não implementou essa funcionalidade.");
    }
    
    /**
     * Zera o contador de tempo do cronômetro. Se o cronômetro estava em estado de contagem, ele é
     * parado.
     */
    public void zerar() {

        tempoFim = 0;
        tempoInicio = 0;
        tempoTranscorrido = 0;
        cadenciado = true;
        //throw new RuntimeException("O aluno ainda não implementou essa funcionalidade.");
    }
    
    // Atributos da classe são declarados aqui
    double tempoInicio;
    double tempoFim;
    double tempoTranscorrido;
    boolean cadenciado;
}
