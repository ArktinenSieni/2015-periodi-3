/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.UI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import thechase.logiikka.Lauta;
import thechase.logiikka.Paivitettava;
import thechase.logiikka.asiat.Asia;

/**
 *
 * @author TheArctic
 */
public class Piirtoalusta extends JPanel implements Paivitettava {
    private Lauta lauta;
    
    public Piirtoalusta(Lauta lauta) {
        super.setBackground(Color.BLACK);
        this.lauta = lauta;
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        piirra(graphics);
    }
    
    /**
     * Piirtää kaikki Asia-oliot.
     * @param graphics 
     */
    public void piirra(Graphics graphics) {
        for (int i = 0; i < lauta.getKartta().length; i++) {
            for (int j = 0; j < lauta.getKartta()[i].length; j++) {
                if (lauta.getKartta()[i][j] == null) {
                    continue;
                } else {
                    graphics.setColor(lauta.getKartta()[i][j].GetVari());
                    graphics.fillRect(j * 10, i * 10, 10, 10);
                }
            }
        }
        
    }
    
    

    @Override
    public void paivita() {
        super.repaint();
    }

    @Override
    public Paivitettava getPaivitettava() {
        return this;
    }
    
}
