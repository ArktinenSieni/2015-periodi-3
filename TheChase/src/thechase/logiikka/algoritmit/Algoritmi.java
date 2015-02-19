
package thechase.logiikka.algoritmit;

import thechase.logiikka.Suunta;

/**
 * Rajapinta reitinhakualgoritmeille.
 * @author TheArctic
 */
public interface Algoritmi {
    /**
     * Antaa ruudun mihin suuntaan hahmo etenee.
     * 
     * @return liikuttava suunta
     */
    public Suunta etene();
    
}
