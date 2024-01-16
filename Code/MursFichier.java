import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>MursFichier</code> dessine les murs de la grille séléctionnée
 * avec un fichier
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */

public class MursFichier extends JComponent {
    /**
     *  Etat de la case (0 : mur)
     */
	  public int id;
    /**
     *  Grille effective
     */
    public GrilleFichier gri;
    /**
     *  position actuelle
     */
    public int indx,indy;
	  
    /**
     * Constructeur uniquement destine a attribuer les valeurs de la grille a la
     * position indx, indy
     *  
     * @param g grille effective
     * @param indx,indy position actuelle
     */
    public MursFichier(GrilleFichier g, int indy, int indx) {
		    this.gri=g;
        this.indx=indx;
        this.indy=indy;
	}
  /**
   * dessinant le contenu de la case selon les valeurs du tableau de grille
   * et des coordonnes de Thesee/de la sortie
   * 
   * @param pinceau pinceau
   * @return rien
   */
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    if (this.isOpaque()) {
      secondPinceau.setColor(Color.BLACK);
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    if (this.gri.lab[this.indy][this.indx]==1) {
        secondPinceau.fillRect(0,0,this.getWidth(),this.getHeight());
      repaint();
    }
    else {
        secondPinceau.drawRect(0,0,this.getWidth(),this.getHeight());
      repaint();
    }
    if (indx==this.gri.xEntre && indy==this.gri.yEntre) {
      secondPinceau.fillOval(0,0,this.getWidth(),this.getHeight());
      repaint();
    }

    if (indx==this.gri.xSortie && indy==this.gri.ySortie) {
      secondPinceau.drawOval(0,0,this.getWidth(),this.getHeight());
      repaint();
    }
  }
}