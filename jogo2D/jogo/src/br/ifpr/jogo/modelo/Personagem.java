package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Personagem extends ElementoGrafico {
    private static final int DESLOCAMENTO = 10;
    private static final int POSICAO_INICIAL_EM_X = 300;
    private static final int POSICAO_INICIAL_EM_Y = 450;
    private int deslocamentoEmX;
    private int deslocamentoEmY;
    private ArrayList<Tiro> tiros;
    private ArrayList<SuperTiro> superTiros;
    public int vidas;

    public Personagem() {
        this.deslocamentoEmX = 0;
        this.deslocamentoEmY = 0;
        setPosicaoEmX(POSICAO_INICIAL_EM_X);
        setPosicaoEmY(POSICAO_INICIAL_EM_Y);
        this.tiros = new ArrayList<Tiro>();
        this.superTiros = new ArrayList<SuperTiro>();
        this.vidas = 3;
    }

    public void atualizar() {
            this.setPosicaoEmX((this.getPosicaoEmX() + this.getDeslocamentoEmX()));
            this.setPosicaoEmY((this.getPosicaoEmY() + this.getDeslocamentoEmY()));
    }

    public void carregar() {
        ImageIcon carregador = new ImageIcon("imagens\\pnave.png");
        setImagem(carregador.getImage());
        setAlturaImagem(getImagem().getWidth(null));
        setLarguraImagem(getImagem().getHeight(null));
        setPosicaoEmX(POSICAO_INICIAL_EM_X);
        setPosicaoEmY(POSICAO_INICIAL_EM_Y);

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
        int frenteDaNave = this.getPosicaoEmX() + this.getLarguraImagem() / 2;
        Tiro tiro = new Tiro(frenteDaNave, this.getPosicaoEmY());
        this.tiros.add(tiro);
    }

    public void superAtirar() {
        int frenteDaNave = this.getPosicaoEmX() + this.getLarguraImagem() / 2;
        SuperTiro superTiro = new SuperTiro(frenteDaNave, this.getPosicaoEmY());
        this.superTiros.add(superTiro);
    }

    public void dispararTiro() {

        atirar();
    }

    public void dispararSuperTiro() {
        superAtirar();
    }

    public Rectangle getBounds() {
        return null;
    }

    public void setVisivel(boolean b) {
    }

    public void morrer() {
    }

    public int getDeslocamentoEmX() {
        return this.deslocamentoEmX;
    }

    public void setDeslocamentoEmX(int deslocamentoEmX) {
        this.deslocamentoEmX = deslocamentoEmX;
    }

    public int getDeslocamentoEmY() {
        return this.deslocamentoEmY;
    }

    public void setDeslocamentoEmY(int deslocamentoEmY) {
        this.deslocamentoEmY = deslocamentoEmY;
    }

    public ArrayList<Tiro> getTiros() {
        return tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = new ArrayList<Tiro>();
        this.tiros = tiros;
    }

    public ArrayList<SuperTiro> getSuperTiros() {
        return superTiros;
    }

    public void setSuperTiros(ArrayList<SuperTiro> superTiros) {
        this.superTiros = superTiros;
    }

    public void reduzirVida() {
        vidas--;
    }

    public int getVidas() {
        return vidas;
    }

    public void reiniciarVidas() {
        vidas = 3;
    }

}