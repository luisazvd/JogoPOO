package br.ifpr.jogo.principal;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicToggleButtonUI;

public class Principal extends JFrame{
    public Principal(){
        setVisible(true);
        setTitle("Bacanudo");
        setSize(256, 256);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(ABORT);
    }
public static void main(String[] args) {
        Principal principal = new Principal();
        
    }
    
}
