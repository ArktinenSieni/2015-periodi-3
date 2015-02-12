/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.asiat;

import java.awt.Color;
import java.awt.Point;

/**
 * Pohjustaa jokaiselle asialle, esteelle, hahmolle sijainnin.
 * @author TheArctic
 * 
 */
public interface Asia {
    /**
     * Palauttaa sijainnin. X:llä 0 on vasen- ja maksimi oikealaita.
     * Y:llä 0 on ylä- ja maksimi on alalaita. 
     * @return Palauttaa sijainnin. Paikalla 0 on x-, ja 1 y-parametri.
     * 
     */
    public Point sijainti();
    /**
     * Kertoo voiko Asian yli kulkea.
     * @return Onko ylitettävä vai ei?
     */
    public boolean ylitettava();
    /**
     * Palauttaa värin. Helpottaa graafisen käyttöliittymän ruudun värittämistä.
     * @return Asia:n väri
     */
    public Color GetVari();
    
    
}
