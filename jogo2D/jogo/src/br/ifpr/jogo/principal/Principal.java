package br.ifpr.jogo.principal;

import javax.swing.JFrame;
import br.ifpr.jogo.modelo.PrimeiraFase;

public class Principal extends JFrame {
    public Principal() {
        PrimeiraFase fase = new PrimeiraFase();
        super.add(fase);
        super.setTitle("Invaders Universe");
        super.setSize(1100, 542);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);

    }

    public static void main(String[] args) {
        new Principal();

    }

}
