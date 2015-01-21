/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase;

import thechase.UI.TekstiUI;
import thechase.logiikka.Lauta;
import thechase.logiikka.asiat.Hahmo;

/**
 *
 * @author TheArctic
 */
public class Thechase {
    private Lauta lautaTesti;
    private Hahmo hahmoTesti;
    private TekstiUI UITesti;
    
    public Thechase() {
        this.lautaTesti = new Lauta(20, 20);
        this.hahmoTesti = new Hahmo(lautaTesti);
        this.UITesti = new TekstiUI(lautaTesti);
    }
    
    public void kaynnista() {
        UITesti.piirra();
    }
}
