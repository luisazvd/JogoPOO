package br.ifpr.jogo.main.java.modelo;

import javax.swing.ImageIcon;

public class NaveMae extends ElementoGrafico {
    private static int VELOCIDADE = 1;

    public NaveMae(int xAleatorio, int yAleatorio) {
        this.carregar();
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("jogo2D/jogo/src/br/ifpr/jogo/main/java/resources/navemae.png");
        super.setImagem(carregando.getImage());
    }

    public void atualizar() {
        if (this.getPosicaoEmX() < 0) {
            int y = (int) (Math.random() * PrimeiraFase.ALTURA_DA_JANELA);
            super.setPosicaoEmX(PrimeiraFase.LARGURA_DA_JANELA);
            super.setPosicaoEmY(y);
        } else {
            super.setPosicaoEmX(super.getPosicaoEmX() - VELOCIDADE);
        }
    }
}
