package br.unifil.dc.lab2;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;
import java.util.ListIterator;

/**
 * Write a description of class Tocador here.
 * 
 * @author Maria Isabelly Santos, Pedro Rocha e Wellington
 * @version 26/04/2020
 */
public class Tocador extends JPanel {

    public Tocador(ListIterator<Transparencia> quadrosFilme) {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        carregarFilme(quadrosFilme);
    }
    public Tocador() {
        this(null);
    }
    
    public void carregarFilme(ListIterator<Transparencia> quadrosFilme) {
        this.quadrosFilme = quadrosFilme;
        this.quadroAtual = null;
        numQuadro = 0;
    }
    
    public void avancarFilme() {
        if (quadrosFilme.hasNext()) {
            quadroAtual = quadrosFilme.next();
            numQuadro++;
        }
    }
    
    public void voltarFilme() {
        if (quadrosFilme.hasPrevious()) {
            quadroAtual = quadrosFilme.previous();
            numQuadro--;
        }
    }
    
    public void rebobinarFilme() {
        while (quadrosFilme.hasPrevious()) {
            quadroAtual = quadrosFilme.previous();
            numQuadro--;
        }
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D pincel = (Graphics2D) g;


        if (quadroAtual != null) {
            quadroAtual.pintar(pincel, this);
        } else {
            pincel.setColor(Color.black);
            pincel.setFont(new Font("Arial", Font.BOLD,40));
            pincel.setFont(new Font("Arial", Font.ITALIC,40));
            pincel.drawString("O Filme ainda não iniciou", 150,300);
        }

        pincel.setFont(new Font("Arial", Font.BOLD,15));
        pincel.drawString("Quadro " + numQuadro, 700,570);
    }

    private int numQuadro = 0;
    private Transparencia quadroAtual = null;
    private ListIterator<Transparencia> quadrosFilme = null;
}
