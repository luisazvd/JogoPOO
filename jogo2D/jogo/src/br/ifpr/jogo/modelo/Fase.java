package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
    private Image fundo;
    private Personagem personagem;

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon carregando = new ImageIcon("imagens\\fundo.jpg");
        this.fundo = carregando.getImage();

        personagem = new Personagem();
        personagem.carregar();

        addKeyListener(new TecladoAdapter());

        Timer timer = new Timer(5, this);
        timer.start();

    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(this.fundo, 0, 0, null);
        graficos.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), personagem.getPosicaoEmY(), null);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.atuzaliza();
        repaint();

    }

    private class TecladoAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            personagem.teclaP(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            personagem.tecla(e);
        }
    }
}