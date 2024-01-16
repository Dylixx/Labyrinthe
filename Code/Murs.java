import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>Murs</code> est utilisee pour representer graphiquement
 * chaque case de la grille
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class Murs extends JComponent {
  /**
   *  booleens relatifs au placement de Thesee et de la sortie
   */
  public boolean placesortie,placethesee,survolAttente;
  /**
   *  Grille effective
   */
  public Grille gri;
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
   * @param so,th indique si thesee (ou la sortie) est sur la case
   */
	public Murs(Grille g, int indx, int indy, boolean so, boolean th) {
		this.gri=g;
    this.indx=indx;
    this.indy=indy;
    this.placesortie=so;
    this.placethesee=th;
    this.survolAttente=false;
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
      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    if (this.gri.tabGrille[this.indx][this.indy]==0) {
    	secondPinceau.fillRect(0,0,this.getWidth(),this.getHeight());
      repaint();
    }
    else {
    	secondPinceau.drawRect(0,0,this.getWidth(),this.getHeight());
      repaint();
    }
    if (this.gri.thx==indx && this.gri.thy==indy) {
      secondPinceau.fillOval(0,0,this.getWidth(),this.getHeight());
      repaint();
    }
    else {
      secondPinceau.drawRect(0,0,this.getWidth(),this.getHeight());
      repaint();
    }
    if (this.gri.sox==indx && this.gri.soy==indy) {
      secondPinceau.drawOval(0,0,this.getWidth(),this.getHeight());
      repaint();
    }
    else {
      secondPinceau.drawRect(0,0,this.getWidth(),this.getHeight());
      repaint();
    }

    if (this.survolAttente==true) {
      secondPinceau.setColor(Color.GREEN);
      secondPinceau.fillRect(0,0,this.getWidth(),this.getHeight());
      secondPinceau.setColor(Color.BLACK);
      repaint();
    }
  }
}