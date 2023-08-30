package br.ifpr.jogo.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class PrimeiraFase extends Fases {
    private Personagem personagem;
    private Timer timer;
    protected static final int ALTURA_DA_JANELA = 542;
    protected static final int LARGURA_DA_JANELA = 1100;
    private boolean podeAtirar = true;
    private ArrayList<Inimigo> inimigos;
    private int temporizador = 0;
    private int QUANTIDADE_INIMIGOS = 15;
    boolean emJogo = true;
    private int pontuacao = 0;
    private Image imagemVida;
    private ArrayList<Image> vidasImagens;


    public PrimeiraFase() {
        super();
        ImageIcon carregandoFundo1 = new ImageIcon("imagens/fundo.jpg");
        this.fundo1 = carregandoFundo1.getImage();

        personagem = new Personagem();
        personagem.carregar();

        ImageIcon carregandoFundo2 = new ImageIcon("imagens/fundo2.png");
        this.fundo2 = carregandoFundo2.getImage();

        ImageIcon carregadorVida = new ImageIcon("imagens/escudo.png");
        imagemVida = carregadorVida.getImage();
        vidasImagens = new ArrayList<>();
        for (int i = 0; i < personagem.getVidas(); i++) {
            vidasImagens.add(imagemVida);
        }

        this.inicializaInimigos();
        this.inicializaElementosGraficosAdicionais();

        timer = new Timer(DELAY, this);
        timer.start();
    }



    @Override
    public void inicializaInimigos() {
        inimigos = new ArrayList<Inimigo>();

        for (int i = 0; i < QUANTIDADE_INIMIGOS; i++) {
            int y = (int) (Math.random() * 800 - 1024);
            int x = (int) (Math.random() * 650 + 30);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }
    }

    @Override
public void inicializaElementosGraficosAdicionais() {
    super.naveMaes = new ArrayList<NaveMae>();
    for (int i = 0; i < QUANTIDADE_NVMAE; i++) {
        int x = (int) (Math.random() * LARGURA_DA_JANELA);
        int y = (int) (Math.random() * ALTURA_DA_JANELA);
        NaveMae navemae = new NaveMae(x, y);
        super.naveMaes.add(navemae);
    }
}

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        if (emJogo) {
            graphics.drawImage(fundo1, 0, 0, null);

            for (NaveMae navemae : naveMaes) {
                graphics.drawImage(navemae.getImagem(), navemae.getPosicaoEmX(), navemae.getPosicaoEmY(), this);
            }

            graphics.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), this.personagem.getPosicaoEmY(),
                    this);
            ArrayList<Tiro> tiros = personagem.getTiros();
            ArrayList<SuperTiro> superTiros = personagem.getSuperTiros();

            for (Tiro tiro : tiros) {
                tiro.carregar();
                graphics.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }

            for (SuperTiro superTiro : superTiros) {
                superTiro.carregar();
                graphics.drawImage(superTiro.getImagem(), superTiro.getPosicaoEmX(), superTiro.getPosicaoEmY(), this);
            }

            for (Inimigo inimigo : inimigos) {
                inimigo.carregar();
                graphics.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }
        } else {
            verificarVidas();
        }

        graphics.setColor(Color.GRAY);
        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        graphics.drawString("Pontos: " + pontuacao, 10, 20);
        desenharVidas(g);

        graphics.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        temporizador++;
        personagem.atualizar();

        for (NaveMae naveMae : this.naveMaes) {
            naveMae.atualizar();
        }

        ArrayList<Tiro> tiros = personagem.getTiros();
        for (int i = tiros.size() - 1; i >= 0; i--) {
            Tiro tiro = tiros.get(i);
            if (tiro.getPosicaoEmY() >= ALTURA_DA_JANELA || !tiro.getVisivel()) {
                tiros.remove(tiro);
            } else {
                tiro.atualizar();
            }
        }

        ArrayList<SuperTiro> superTiros = personagem.getSuperTiros();
        for (int i = superTiros.size() - 1; i >= 0; i--) {
            SuperTiro superTiro = superTiros.get(i);
            if (superTiro.getPosicaoEmY() >= ALTURA_DA_JANELA || !superTiro.getVisivel()) {
                superTiros.remove(superTiro);
            } else {
                superTiro.atualizar();
            }
        }

        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo inimigo = this.inimigos.get(i);
            if (inimigo.getPosicaoEmY() > 800 || !inimigo.getVisivel()) {
                inimigos.remove(inimigo);
                int y = (int) (Math.random() * 800 - 1024);
                int x = (int) (Math.random() * 650 + 30);
                Inimigo inimigos = new Inimigo(x, y);
                this.inimigos.add(inimigos);
            } else {

                inimigo.atualizar();
            }
        }

        verificarVidas();
        this.verificarColisoes();
        trocarImagemFundo();
        


        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && podeAtirar) {
            personagem.dispararTiro();
            podeAtirar = false;
        } else {
            personagem.mover(e);
        }
        if (e.getKeyCode() == KeyEvent.VK_Q && podeAtirar && temporizador >= 200) {
            personagem.dispararSuperTiro();
            podeAtirar = false;
            temporizador = 0;
        } else {
            personagem.mover(e);

            int posX = personagem.getPosicaoEmX();
            int posY = personagem.getPosicaoEmY();

            int larguraPersonagem = personagem.getImagem().getWidth(null);
            int alturaPersonagem = personagem.getImagem().getHeight(null);

            if (posX < 0) {
                posX = 0;
            } else if (posX + larguraPersonagem > 1100) {
                posX = getWidth() - larguraPersonagem;
            }

            if (posY < 0) {
                posY = 0;
            } else if (posY + alturaPersonagem > 542) {
                posY = getHeight() - alturaPersonagem;
            }

            personagem.setPosicaoEmX(posX);
            personagem.setPosicaoEmY(posY);
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (e.getKeyCode() == KeyEvent.VK_R) {;
            emJogo = true;
            personagem.setVisivel(true);
            personagem.reiniciarVidas();
            pontuacao = 0;
            fundo1 = fundo1;
            inicializaInimigos();
            
            
        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            emJogo = false;
            personagem.setVisivel(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            podeAtirar = true;
        }
        personagem.parar(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void verificarColisoes() {
        Rectangle formaPersonagem = personagem.getRectangle();

        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();
            if (formaInimigo.intersects(formaPersonagem)) {
                if (!vidasImagens.isEmpty()) {
                vidasImagens.remove(vidasImagens.size() - 1);
            }
                this.personagem.setVisivel(false);
                inimigo.setVisivel(false);
                pontuacao = 0;
                personagem.reduzirVida();

            }

            ArrayList<Tiro> tiros = personagem.getTiros();
            for (int j = 0; j < tiros.size(); j++) {
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if (formaInimigo.intersects(formaTiro)) {
                    inimigo.setVisivel(false);
                    tiro.setVisivel(false);
                    pontuacao += 10;
                }
            }
            ArrayList<SuperTiro> superTiros = personagem.getSuperTiros();
            for (int k = 0; k < superTiros.size(); k++) {
                SuperTiro superTiro = superTiros.get(k);
                Rectangle formaSuperTiro = superTiro.getRectangle();
                if (formaInimigo.intersects(formaSuperTiro)) {
                    inimigo.setVisivel(false);
                    superTiro.setVisivel(false);
                    pontuacao += 20;
                }
            }

        }
    }

    private void verificarVidas() {
        if (personagem.getVidas() <= 0) {
            emJogo = false;
            personagem.setVisivel(false);
        }
    }
    private void desenharVidas(Graphics g) {
        int posXInicial = 10;
        int posY = ALTURA_DA_JANELA - imagemVida.getHeight(null) - 45;

        for (int i = 0; i < personagem.getVidas(); i++) {
            int posX = posXInicial + i * (imagemVida.getWidth(null) + 10);
            g.drawImage(imagemVida, posX, posY, null);
        }
    }

    private void trocarImagemFundo() {
        if (pontuacao < 200) {
            fundo1 = fundo1;
        } else {
            fundo1 = fundo2;
        }
    }
}