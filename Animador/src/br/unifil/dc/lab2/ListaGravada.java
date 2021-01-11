package br.unifil.dc.lab2;

import javax.swing.JPanel;
import java.awt.*;
import java.util.List;

/**
 * Write a description of class ListaGravada here.
 * 
 * @author Maria Isabelly Santos, Pedro Rocha e Wellington
 * @version 26/04/2020
 */
public class ListaGravada implements Transparencia
{
    private int acumularespaço;

    /**
     * Constructor for objects of class ListaGravada
     */
    public ListaGravada(List<Integer> lista, List<Color> coresIndices, String nome) {
        this.lista = lista;
        this.nome = nome;
        this.coresIndices = coresIndices;
    }

    int[] toIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }
    
    public void pintar(Graphics2D pincel, JPanel contexto) {
        Dimension dim = contexto.getSize();

        // Cor do gráfico
        Color ligthtcyiano = new Color(25,255,255);

        
      //  lista
        int[] list = toIntArray(lista);

        //  quadrado

        //quadrado
        int alturaQuadrado = 500;
        int larguraQuadrado = 700;
        int[] eixoQuadrado = {50,50}; //eixo x e y
        final int X = 0;
        final int Y = 1;
        pincel.drawRect(eixoQuadrado[X],eixoQuadrado[Y],larguraQuadrado,alturaQuadrado);
        //quadrado
        pincel.setColor(Color.BLACK);
        pincel.setStroke(new BasicStroke(4));

        pincel.drawRect(eixoQuadrado[X],eixoQuadrado[Y],larguraQuadrado,alturaQuadrado);



        //linha pontilhada
        pincel.setColor(Color.RED);
        pincel.setStroke(dashed);
        pincel.drawLine(eixoQuadrado[X],alturaQuadrado+4,larguraQuadrado+eixoQuadrado[X],alturaQuadrado+4);

        //graficos
        pincel.setColor(Color.black);
        pincel.setStroke(new BasicStroke(4f));
        int alturaMaxima = alturaQuadrado - 100;
        int eixoYMinimo = 100;
        int[] espacoColunas = espColuna(list.length,larguraQuadrado); // 0 - espaço          1 - lagura da coluna
        int[] alturaColunas = alturaColunas(list,alturaMaxima);
        int[] eixoY = eixoYColunas(alturaColunas,alturaMaxima,eixoYMinimo);
        int acumulaPosicao = eixoQuadrado[X];

        for (int i=0;i<list.length;i++){
            acumulaPosicao += espacoColunas[0];
            pincel.setColor(Color.black);
            pincel.fillRect(acumulaPosicao-3,eixoY[i]-3,espacoColunas[1]+6,alturaColunas[i]+6);
            pincel.setColor(ligthtcyiano);
            pincel.fillRect(acumulaPosicao,eixoY[i],espacoColunas[1],alturaColunas[i]);
            acumulaPosicao += espacoColunas[1];

            int y = 200;
            int dimunuirX = 80;
            for (int j = 0; j < lista.size(); j++) {
                pincel.setColor(Color.BLACK);
                pincel.setFont(new Font("Arial", Font.BOLD, 20));
                pincel.drawString(" " + lista.get(i), acumulaPosicao - dimunuirX, 530);
            }

        }

     /*   // linha pontilhada limite
        pincel.drawLine(50,223,700,223); */

    }

    // metodo que retorna o maior elemento digitado
    private  int maiorElemento(int[] listaValores){
        int maior =0;

        for (int i=0;i<listaValores.length;i++ ){
            if (maior < listaValores[i])
                maior = listaValores[i];
        }

        return  maior;
    }

    // metodo retorno no indice 0 o espaço que deve ter entre cada coluna e no indice 1 a largura das colunas
    // 0 - espaço
    // 1 - lagura da coluna
    private int[] espColuna(int quantidadeColunas, int larguraQuadrado){ ;

        int entreColunas = ((larguraQuadrado * 30) /100) / (quantidadeColunas+1);
        int larguraColuna = ((larguraQuadrado * 70) /100) / quantidadeColunas;

        int[] retorno = {entreColunas, larguraColuna};
        return retorno;
    }

    //metodo retorna todos os valores de altura das colunas
    private int[] alturaColunas(int[] listaValores, int alturaMaxima){
        int maiorElemento = maiorElemento(listaValores);
        int porcentagem = 1;
        int cal = maiorElemento;
        int[] listaAlturas = new int[listaValores.length];
        if (maiorElemento > alturaMaxima){
            while (cal > alturaMaxima){
                porcentagem++;
                cal = maiorElemento - ((maiorElemento * porcentagem) / 100);
            }
        }

        for (int i=0;i<listaValores.length;i++){
            listaAlturas[i] = listaValores[i] - ((listaValores[i] * porcentagem) / 100);
        }
        return listaAlturas;

    }

    // metodo retorna todos os valores do eixo y das colunas
    private  int[] eixoYColunas(int[] alturaColunas, int alturaMaxima,int eixoYMinimo){

        int[] eicoYColunas = new int[alturaColunas.length];

        for (int i=0; i < alturaColunas.length;i++){
            eicoYColunas[i] = eixoYMinimo + (alturaMaxima - alturaColunas[i]);
        }
        return eicoYColunas;
    }


    final static float dash1[] = {5f}; // tamanho de cada bloco pontilhado

    // onde que ajusta a linha
    final static BasicStroke dashed = new BasicStroke(5f, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER, 1.0f, dash1, 0.0f);
    
    private List<Integer> lista;
    private List<Color> coresIndices;
    private String nome;
}
