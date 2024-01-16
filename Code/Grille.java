import java.awt.*;
import javax.swing.*;
import java.util.Random;
/**
 * La classe <code>Grille</code> est utilisee pour creer le labyrinthe effectif
 * 
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class Grille {
	/**
     *  tableau a deux dimensions d'entiers representant le labyrinthe et ses murs (0)
     */
	public static int[][] tabGrille;
	/**
     *  positions d'entree et de sortie 
     */
	public int thx,thy,sox,soy;
	/**
     * Constructeur uniquement destine a initialiser les valeurs de la grille a 0
     * 
     * @param taille la taille du labyrinthe
     */
	public Grille(int taille) {
		this.tabGrille = new int[taille][taille];
		this.thx=0;
		this.thy=0;
		this.sox=0;
		this.soy=0;
	}
	/**
     * Methode creant la grille
     * 
     * @param taille taille du labyrinthe
     * @param choix choix de generation de la grille (vide ou aleatoie)
     * @param fenetre fenetre ou sera representee la grille
     * @return rien
     */
	public void creationGrille (int taille, int choix,JFrame fenetre) {	
		Random rand = new Random();
		int i,j,caseg,ncas=0,thx=0,thy=0,sox=0,soy=0;
		int thesee = rand.nextInt(taille*taille);
		int sortie = rand.nextInt(taille*taille);
		boolean so=false,th=false;
		if (thesee==sortie) {
			sortie++;
		}
		GridLayout cases = new GridLayout(taille,taille);
		JPanel grille = new JPanel();
		
		fenetre.setSize((taille*50)+400,taille*50);
		fenetre.setLocation(0,0);
		grille.setLayout(cases);
		for (i=0;i<taille;i++) {
			for (j=0;j<taille;j++) {
				JPanel panneau = new JPanel(new BorderLayout());
				if (choix==0) {
					caseg=1;
					if (i==0 && j==0) {
						th=true;
						this.thx=j;
						this.thy=i;
					}
					if (i==taille-1 && j==taille-1) {
						so=true;
						this.sox=j;
						this.soy=i;
					}
				}
				else {
					caseg=rand.nextInt(3);
					if (caseg==0 && thesee==ncas) {
						caseg=1;
					}
					if (caseg!=0 && thesee==ncas) {
						th=true;
						this.thx=j;
						this.thy=i;
					}
					if (caseg==0 && sortie==ncas) {
						caseg=1;
					}
					if (caseg!=0 && sortie==ncas) {
						so=true;
						this.sox=j;
						this.soy=i;
					}
				}
				this.tabGrille[j][i]=caseg;
				Murs mur=new Murs(this,j,i,so,th);
				panneau.addMouseListener(new Modifications(mur,this,j,i));
				panneau.add(mur);
				so=false;
				th=false;
				ncas++;
				grille.add(panneau);
			}
		}
		MenuSecondaire.menuSecondaire(fenetre,grille,this);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		
	}
	
}