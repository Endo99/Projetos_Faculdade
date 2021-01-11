package lab2.dc.unifil.br;

public class Medicao {

    public Medicao(int n, double tempoSegundos) {
        this.n = n;
        this.tempoSegundos = tempoSegundos;
    }

    public int getN() {
        return n;
    }

    public double getTempoSegundos() {
        return tempoSegundos;
    }

    private int n;
    private double tempoSegundos;
}
