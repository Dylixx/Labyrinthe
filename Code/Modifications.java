import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * La classe <code>Modifications</code> permet de modifier la grille 
 * en cliquant dessus
 * 
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class Modifications implements MouseListener {
	/**
     *  mur sur lequel on a clique
     */
	public Murs mur;
	public Grille gri;
	public static boolean theseeEnAttente,sortieEnAttente;
	public boolean pose;
	public int x,y;
	public Modifications (Murs m, Grille g, int x, int y) {
		this.x=x;
		this.y=y;
		this.mur=m;
		this.gri=g;
		this.theseeEnAttente=false;
        this.sortieEnAttente=false;
        this.pose=false;
	}
	public void mouseClicked(MouseEvent evenement) {

		if (this.theseeEnAttente==true) {
			if (this.mur.placesortie==false) {
				this.theseeEnAttente=false;
				this.mur.placethesee=true;
				this.pose=true;
				this.gri.thx=x;
				this.gri.thy=y;
			}
		}
		if (this.sortieEnAttente==true) {
			if (this.mur.placethesee==false) {
				this.sortieEnAttente=false;
				this.mur.placesortie=true;
				this.pose=true;
				this.gri.sox=x;
				this.gri.soy=y;
			}
		}
		if (this.mur.placethesee==true && this.pose==false) {
			this.theseeEnAttente=true;
			this.mur.placethesee=false;
		}
		if (this.mur.placesortie==true && this.pose==false) {
			this.sortieEnAttente=true;
			this.mur.placesortie=false;
		}
		this.pose=false;
		if (this.gri.tabGrille[x][y]>0 && this.mur.placethesee==false && this.mur.placesortie==false) {
			if (this.theseeEnAttente==false  && this.sortieEnAttente==false) {
				this.gri.tabGrille[this.x][this.y]=0;
			}
		}
		else {
			this.gri.tabGrille[this.x][this.y]=1;
		}
		System.out.println(""+this.gri.thx+" "+this.gri.thy);
	}          
	public void mouseEntered(MouseEvent evenement) {
		if (this.sortieEnAttente==true || this.theseeEnAttente==true) {
			this.mur.survolAttente=true;
		}
	}   
	public void mouseExited(MouseEvent evenement) {
		if (this.mur.survolAttente==true) {
			this.mur.survolAttente=false;
		}
	}         
	public void mousePressed(MouseEvent evenement) {}     
	public void mouseReleased(MouseEvent evenement) {}

}