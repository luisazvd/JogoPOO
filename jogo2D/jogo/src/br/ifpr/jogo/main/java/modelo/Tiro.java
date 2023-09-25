package br.ifpr.jogo.main.java.modelo;

import javax.swing.ImageIcon;

public class Tiro extends ElementoGrafico {
    private static int VELOCIDADE = 5;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        this.carregar();
        this.setPosicaoEmX(posicaoPersonagemEmX);
        this.setPosicaoEmY(posicaoPersonagemEmY);

    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("jogo2D/jogo/src/br/ifpr/jogo/main/java/resources/flecha.png");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(this.getImagem().getWidth(null));
        this.setLarguraImagem(this.getImagem().getHeight(null));
    }

    public void atualizar() {
        this.setPosicaoEmY(this.getPosicaoEmY() - VELOCIDADE);
    }

    public Tiro get(int i) {
        return null;
    }
}