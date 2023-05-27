package br.ifpr.jogo.modelo;

import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class Personagem {
    private int posicaoEmX;
    private int posicaoEmY;
    private int deslocamentoEmX;
    private int deslocamentoEmY;
    private Image imagem;
    private int larguraImagem;
    private int alturaImagem;
    private boolean eVisivel;

    public Personagem() {
        this.posicaoEmX = 100;
        this.posicaoEmY = 100;
        this.eVisivel = true;
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("imagens\\pnave.png");
        this.imagem = carregando.getImage();
        this.alturaImagem = this.imagem.getWidth(null);
        this.larguraImagem = this.imagem.getHeight(null);
    }

    public void update() {
        posicaoEmX += deslocamentoEmX;
        posicaoEmY += deslocamentoEmY;
    }

    public Rectangle getBounds() {
        return new Rectangle(posicaoEmX, posicaoEmY, larguraImagem, alturaImagem);
    }

    public void keyPressed(KeyEvent teclado) {
        int tecla = teclado.getKeyCode();

        if (tecla == KeyEvent.VK_UP) {
            deslocamentoEmY = -15;
        }
        if (tecla == KeyEvent.VK_DOWN) {
            deslocamentoEmY = 15;
        }

        if (tecla == KeyEvent.VK_LEFT) {
            deslocamentoEmX = -15;
        }
        if (tecla == KeyEvent.VK_RIGHT) {
            deslocamentoEmX = 15;
        }
    }

    public void keyReleased(KeyEvent teclado) {
        int tecla = teclado.getKeyCode();

        if (tecla == KeyEvent.VK_UP || tecla == KeyEvent.VK_DOWN) {
            deslocamentoEmY = 0;
        }
        if (tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_RIGHT) {
            deslocamentoEmX = 0;
        }
        Fase fase = (Fase) SwingUtilities.getRoot(teclado.getComponent());
        fase.repaint();
    }

    public int getPosicaoEmX() {
        return posicaoEmX;
    }

    public void setPosicaoEmX(int posicaoEmX) {
        this.posicaoEmX = posicaoEmX;
    }

    public int getPosicaoEmY() {
        return posicaoEmY;
    }

    public void setPosicaoEmY(int posicaoEmY) {
        this.posicaoEmY = posicaoEmY;
    }

    public int getDeslocamentoEmX() {
        return deslocamentoEmX;
    }

    public void setDeslocamentoEmX(int deslocamentoEmX) {
        this.deslocamentoEmX = deslocamentoEmX;
    }

    public int getDeslocamentoEmY() {
        return deslocamentoEmY;
    }

    public void setDeslocamentoEmY(int deslocamentoEmY) {
        this.deslocamentoEmY = deslocamentoEmY;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getLarguraImagem() {
        return larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }

    public boolean iseVisivel() {
        return eVisivel;
    }

    public void seteVisivel(boolean eVisivel) {
        this.eVisivel = eVisivel;
    }

}
