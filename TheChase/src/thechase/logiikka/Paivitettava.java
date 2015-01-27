/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka;

/**
 * Rajapinta kaikille päivitettäville olioille. Helpottaa päivittämistä, kun voi
 * laittaa kaikki samaan listaan.
 * @author TheArctic
 */
public interface Paivitettava {
    public void paivita();
    public Paivitettava getPaivitettava();
}
