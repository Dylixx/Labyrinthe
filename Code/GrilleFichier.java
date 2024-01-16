import java.awt.*;
import javax.swing.*;
/**
 * La classe <code>GrilleFichier</code> cree graphiquement une grille par rapport a
 * un fichier
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class GrilleFichier{
	/**
     *  tableau a deux dimensions d'entiers representant le labyrinthe et ses murs (0)
     */
	public static int[][] lab;
	/**
     *  positions d'entree et de sortie 
     */
	public int yEntre,xEntre,ySortie,xSortie;
	/**
     * Constructeur destine a transmettre les valeurs de la grille et initialiser
     * l'historique des coups
     * 
     * @param tab le labyrinthe
     * @param xEntre,yEntre,xSortie,ySortie la position de l'entree et de la sortie
     */
	public GrilleFichier(int[][] tableau,int yEntre,int xEntre,int ySortie,int xSortie){
		this.lab = tableau;
		this.yEntre=yEntre;
		this.xEntre=xEntre;
		this.ySortie=ySortie;
		this.xSortie=xSortie;
	}

	/**
     * Dessine la grille par rapport au fichier choisi sur la fenetre
     * 
     * @param fenetre fenetre ou va s'afficher la grille
     */
	public void creationGrilleFichier(JFrame fenetre){
		int taille = this.lab.length,i,j;

		GridLayout cases = new GridLayout(taille,taille);
		JPanel grille = new JPanel();

		fenetre.setSize((taille*50)+400,taille*50);
		fenetre.setLocation(0,0);
		grille.setLayout(cases);

		for (i=0;i<taille;i++) {
			for (j=0;j<taille;j++) {
				JPanel panneau = new JPanel(new BorderLayout());
				MursFichier mur=new MursFichier(this,i,j); //On dessine dans la case
				panneau.add(mur); //Met le dessin au panel
				grille.add(panneau); //Met le JPanel panneau au JPanel de la grille
			}
		}
		fenetre.add(grille);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		


	}


}