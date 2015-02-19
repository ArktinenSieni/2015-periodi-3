
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
     * Piirtää kaikki Asia-oliot. Laudan koon ollessa pienempi kuin 100, 
     * piirretään lauta kymmenkertaisena, muutoin koko on yksi yhteen.
     *
     * @param graphics grafiikat
     */
    public void piirra(Graphics graphics) {
        if (lauta.getKartta().length < 100) {
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
        } else {
            for (int i = 0; i < lauta.getKartta().length; i++) {
                for (int j = 0; j < lauta.getKartta()[i].length; j++) {
                    if (lauta.getKartta()[i][j] == null) {
                        continue;
                    } else {
                        graphics.setColor(lauta.getKartta()[i][j].GetVari());
                        graphics.fillRect(j, i, 1, 1);
                    }
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
