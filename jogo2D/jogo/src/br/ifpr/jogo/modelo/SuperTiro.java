package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class SuperTiro  extends ElementoGrafico{
    private static int VELOCIDADE = 7;

    public SuperTiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
       this.carregar();
       this.setPosicaoEmX(posicaoPersonagemEmX);
       this.setPosicaoEmY(posicaoPersonagemEmY);

    }

     public void carregar() {
        ImageIcon carregando = new ImageIcon("imagens/machado.png");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(this.getImagem().getWidth(null));
        this.setLarguraImagem(this.getImagem().getHeight(null));
    }
    
     public void atualizar() {
        this.setPosicaoEmY(this.getPosicaoEmY() - VELOCIDADE);
    }

}