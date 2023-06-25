package br.ifpr.jogo.modelo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Personagem {
    private int posicaoEmX, posicaoEmY;
    private int deslocamentoEmX, deslocamentoEmY;
    private int larguraImagem, alturaImagem;
    private Image imagem;
    private static final int DESLOCAMENTO = 10;
    private static final int POSICAO_INICIAL_EM_X = 300;
    private static final int POSICAO_INICIAL_EM_Y = 450;
    private ArrayList<Tiro> tiros;

    public Personagem() {
        this.posicaoEmX = POSICAO_INICIAL_EM_X;
        this.posicaoEmY = POSICAO_INICIAL_EM_Y;
        this.tiros = new ArrayList<Tiro>();
    }

    public void carregar() {
        ImageIcon carregador = new ImageIcon("imagens\\pnave.png");
        this.imagem = carregador.getImage();
        this.alturaImagem = this.imagem.getWidth(null);
        this.larguraImagem = this.imagem.getHeight(null);
    }

    public void atualizar() {
        this.posicaoEmX = this.posicaoEmX + this.deslocamentoEmX;
        this.posicaoEmY = this.posicaoEmY + this.deslocamentoEmY;
    }

    public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_UP || codigo == KeyEvent.VK_W) {
            deslocamentoEmY = -DESLOCAMENTO;
        }
        if (codigo == KeyEvent.VK_DOWN || codigo == KeyEvent.VK_S) {
            deslocamentoEmY = DESLOCAMENTO;
        }
        if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) {
            deslocamentoEmX = -DESLOCAMENTO;
        }
        if (codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) {
            deslocamentoEmX = DESLOCAMENTO;
        }
    }

    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_UP || codigo == KeyEvent.VK_W) {
            deslocamentoEmY = 0;
        }

        if (codigo == KeyEvent.VK_DOWN || codigo == KeyEvent.VK_S) {
            deslocamentoEmY = 0;
        }

        if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) {
            deslocamentoEmX = 0;
        }

        if (codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) {
            deslocamentoEmX = 0;
        }
    }

    public void atirar() {
        int frenteDaNave = this.posicaoEmX + (this.larguraImagem / 2);
        int meioDaNave = this.posicaoEmY;
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
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

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public static int getDeslocamento() {
        return DESLOCAMENTO;
    }

    public static int getPosicaoInicialEmX() {
        return POSICAO_INICIAL_EM_X;
    }

    public static int getPosicaoInicialEmY() {
        return POSICAO_INICIAL_EM_Y;
    }

    public ArrayList<Tiro> getTiros() {
        return tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }

}