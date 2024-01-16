import java.util.Random;
/**
 * La classe <code>AlgoAleatoire</code> est utilisee pour resoudre un labyrinthe
 * en empruntant des directions aleatoires
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class AlgoAleatoire {
	/**
     *  tableau a deux dimensions d'entiers representant le labyrinthe et ses murs (0)
     */
	public int[][] labyrinthe;
	/**
     *  positions d'entree et de sortie 
     */
	public int xEntre,yEntre,xSortie,ySortie;
	/**
     *  nombre de tentatives
     */
	public int tenta;

	/**
     * Constructeur uniquement destine a transmettre les valeurs de la grille
     * 
     * @param tab le labyrinthe
     * @param xEntre,yEntre,xSortie,ySortie la position de l'entree et de la sortie
     */
	public AlgoAleatoire (int[][] tab,int xEntre, int yEntre,int xSortie,int ySortie) {
		this.labyrinthe = tab;
		this.xEntre=xEntre;
		this.yEntre=yEntre;
		this.xSortie=xSortie;
		this.ySortie=ySortie;
		this.tenta=0;
	}
	/**
     * Renvoie le nombre de tentatives apres un parcours aleatoire, -1 si la sortie n'est pas
     * trouvee
     * 
     * @return le nombre de tentatives ou -1
     */
	public int randomResolver() {

		Random rand = new Random();
		String coup;
		int taille = this.labyrinthe.length, positionActuelle_x=this.xEntre,positionActuelle_y=this.yEntre,nbverif=0;
		String[] liste={"haut","bas","gauche","droite"};
		while(positionActuelle_y!=this.ySortie || positionActuelle_x!=this.xSortie){
			coup = liste[rand.nextInt(4)];
			if (verification(coup,positionActuelle_x,positionActuelle_y,taille)) {
				nbverif=0;
				positionActuelle_x=Deplacement.deplacementX(coup,positionActuelle_x);
				positionActuelle_y=Deplacement.deplacementY(coup,positionActuelle_y);
				this.tenta++;
			}
			nbverif++;
			if (this.tenta>10000 || nbverif>100) {
				return -1;
			}
		}
		return this.tenta;
	}

	/**
     * Verifie si la case sur laquelle on s'apprete a passer est accessible
     *
     * @param coup le coup joue
     * @param x,y position actuelle
     * @param taille taille de la grille
     * @return true ou false si la case d'en face est un mur ou un bord
     */
	public boolean verification (String coup, int x, int y,int taille){
		if (coup=="haut") {
			if (y!=0) {
				if (this.labyrinthe[x][y-1] !=0) {
					return true;
				}
			}
		}
		if (coup=="bas") {
			if (y!=taille-1) {
				if (this.labyrinthe[x][y+1] !=0) {
					return true;
				}
			}
		}
		if (coup=="gauche") {
			if (x!=0) {
				if (this.labyrinthe[x-1][y] !=0) {
					return true;
				}
			}
		}
		if (coup=="droite") {
			if (x!=taille-1) {
				if (this.labyrinthe[x+1][y] !=0) {
					return true;
				}
			}
		}
		return false;
	}
}
