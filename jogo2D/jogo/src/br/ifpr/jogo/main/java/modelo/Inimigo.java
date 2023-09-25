package br.ifpr.jogo.main.java.modelo;


import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Inimigo extends ElementoGrafico{
    private static int VELOCIDADE = 4;
    private boolean vivo;

    public Inimigo (int xAleatorio, int yAleatorio) {
        this.carregar();
        setPosicaoEmX(xAleatorio);
        setPosicaoEmY(yAleatorio);
        this.vivo = true;
    }

    public void carregar() {
        ImageIcon loading = new ImageIcon("jogo2D/jogo/src/br/ifpr/jogo/main/java/resources/inimigo1.png");
        this.setImagem(loading.getImage());
        this.setAlturaImagem(this.getImagem().getWidth(null));
        this.setLarguraImagem(this.getImagem().getHeight(null));

    }
    public void atualizar() {
        if (!vivo){
            return;
        }
        this.setPosicaoEmY(this.getPosicaoEmY() + VELOCIDADE);
    }


    public boolean isVivo() {
        return this.vivo;
    }

    public boolean getVivo() {
        return this.vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }


    public Rectangle getBounds() {
         return new Rectangle(getPosicaoEmX(), getPosicaoEmY(), getImagem().getWidth(null), getImagem().getHeight(null));
    }
    
}