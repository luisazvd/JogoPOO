package br.ifpr.jogo.main.java.modelo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class Fases extends JPanel implements ActionListener, KeyListener {
    public static final int DELAY = 5;
    public static final int ALTURA_DA_JANELA = 542;
    public static final int QUANTIDADE_INIMIGOS = 20;
    public int QUANTIDADE_NVMAE = 2;

    protected Image fundo1, fundo2;
    protected Personagem personagem;
    protected Timer timer;
    protected boolean podeAtirar = true;
    protected ArrayList<Inimigo> inimigos;
    protected ArrayList<NaveMae> naveMaes;
    protected int temporizador = 0;
    boolean emJogo = true;

    public Fases() {
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(this);
        this.emJogo = true;
    }

    public abstract void inicializaInimigos();

    public abstract void inicializaElementosGraficosAdicionais();

    public abstract void verificarColisoes();

    @Override
    public abstract void keyTyped(KeyEvent e);

    @Override
    public abstract void keyPressed(KeyEvent e);

    @Override
    public abstract void keyReleased(KeyEvent e);

    @Override
    public abstract void actionPerformed(ActionEvent e);

    public boolean isEmJogo() {
        return emJogo;
    }

    public void setEmJogo(boolean emJogo) {
        this.emJogo = emJogo;
    }

}