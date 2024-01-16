import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * La classe <code>PeutAvancer</code> est utilisee pour avancer dans la
 * grille lorsque le mode manuel de l'algo deterministe est active
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class PeutAvancer implements KeyListener {
	/**
     *  Chaine de caractere contenant le mode, "automatique" ou "manuel"
     */
	public String mode;
	/**
     *  Tableau de chaines de caractere contenant l'historique des coups
     *  de l'algorithme deterministe
     */
	public String[] histo;
	/**
     *  positions d'entree et de sortie 
     */
	public int thx,thy,sox,soy;
	/**
     *  nombre de tentatives a afficher apres visualisation
     */
	public int i;
	/**
     *  grille sur laquelle se base l'algorithme
     */
	public Grille gri;
	/**
     *  nombre de tentatives a afficher sur la fenetre
     */
	public JLabel nbTent;
	/**
     * Constructeur uniquement destine a transmettre les informations
     * de l'algorithme deterministe
     * 
     * @param mode le mode de deplacement
     * @param historiqueCoup historique des coups de l'algorithme
     * @param gri grille de l'algorithme
     */
	public PeutAvancer(String mode,String[] historiqueCoup, Grille gri, JLabel nbTent) {
		this.nbTent=nbTent;
		this.gri=gri;
		this.mode=mode;
		this.histo=historiqueCoup;
		this.thx=gri.thx;
		this.thy=gri.thy;
		this.sox=gri.sox;
		this.soy=gri.soy;
		this.i=0;
	}
	/**
     * Methode vide, pas d'evenement lors d'un appui maintenu
     * 
     * @return rien
     */
	public void keyPressed(KeyEvent e) {}
	/**
     * Methode vide, pas d'evenement lorsqu'une touche est relachee
     * 
     * @return rien
     */
  	public void keyReleased(KeyEvent e) {}
  	/**
     * Avance dans la grille si le mode est défini comme "manuel" lorsqu'une
     * touche est appuyée
     * 
     * @return rien
     */
  	public void keyTyped(KeyEvent e) {
  	    if (mode=="manuel") {

  	    	if (this.gri.thx==this.gri.sox && this.gri.thy==this.gri.soy) {
  	    		this.nbTent.setText(i+" tentatives");
  	    		this.gri.thx=this.thx;
  	    		this.gri.thy=this.thy;
  	    	}
  	    	else {
  	    		this.gri.thx=Deplacement.deplacementX(this.histo[i],this.gri.thx);
  	    		this.gri.thy=Deplacement.deplacementY(this.histo[i],this.gri.thy);
  	    		i++;
  	    	}
  	    }
  	}
}