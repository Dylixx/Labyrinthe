import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * La classe <code>AlgoDeterm</code> est utilisee pour resoudre un labyrinthe
 * en effectuant un parcours en profondeur
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class AlgoDeterm {
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
     *  historique des coups
     */
	public static String[] historiqueCoup;

	/**
     * Constructeur destine a transmettre les valeurs de la grille et initialiser
     * l'historique des coups
     * 
     * @param tab le labyrinthe
     * @param xEntre,yEntre,xSortie,ySortie la position de l'entree et de la sortie
     */
	public AlgoDeterm (int[][] tab,int xEntre, int yEntre,int xSortie,int ySortie) {
		this.labyrinthe = tab;
		this.xEntre=xEntre;
		this.yEntre=yEntre;
		this.xSortie=xSortie;
		this.ySortie=ySortie;
		this.tenta=0;
		this.historiqueCoup = new String[10001];
	}

	/**
     * Renvoie le nombre de tentatives apres un parcours en profondeur, -1 si la sortie n'est pas
     * trouvee
     * 
     * @return le nombre de tentatives ou -1
     */
	public int resolver() {
		
		String coup;
		int taille = this.labyrinthe.length, positionActuelle_x=this.xEntre,positionActuelle_y=this.yEntre,nbverif=0,i=0;
		int[][] caseObstruee = new int[taille][taille];
		int[][] nombrePassage = new int[taille][taille];
		int[][] dirProvenance = new int[taille][taille];
		String[] liste={"droite","haut","gauche","bas"}; 
		while(positionActuelle_y!=this.ySortie || positionActuelle_x!=this.xSortie){
			coup = liste[i];
			if (verification(coup,positionActuelle_x,positionActuelle_y,taille,caseObstruee,nombrePassage)) {
				nombrePassage[positionActuelle_x][positionActuelle_y]++;
				nbverif=0;
				positionActuelle_x=Deplacement.deplacementX(coup,positionActuelle_x);
				positionActuelle_y=Deplacement.deplacementY(coup,positionActuelle_y);
				dirProvenance[positionActuelle_x][positionActuelle_y]=i;
				this.historiqueCoup[this.tenta]=coup;
				this.tenta++;
			}
			else {
				if (casesNoires(positionActuelle_x,positionActuelle_y,taille,caseObstruee,nombrePassage)==4) {
					caseObstruee[positionActuelle_x][positionActuelle_y]=1;
					coup=liste[(dirProvenance[positionActuelle_x][positionActuelle_y]+2)%4];
					nbverif=0;
					positionActuelle_x=Deplacement.deplacementX(coup,positionActuelle_x);
					positionActuelle_y=Deplacement.deplacementY(coup,positionActuelle_y);
					this.historiqueCoup[this.tenta]=coup;
					this.tenta++;
				}
				i++;
				i=i%4;
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
     * @param caseObstruee cases obstruees de la grille
     * @param nombrePassage nombre de passage sur chaque cases
     * @return true ou false si la case d'en face est un mur, un bord ou une case deja accedee
     */
	public boolean verification (String coup, int x, int y,int taille, int[][] caseObstruee, int[][] nombrePassage){
		if (coup=="haut") {
			if (y!=0) {
				if (this.labyrinthe[x][y-1]!=0 && caseObstruee[x][y-1]!=1 && nombrePassage[x][y-1]<1) {
					return true;
				}
			}
		}
		if (coup=="bas") {
			if (y!=taille-1) {
				if (this.labyrinthe[x][y+1]!=0 && caseObstruee[x][y+1]!=1 && nombrePassage[x][y+1]<1) {
					return true;
				}
			}
		}
		if (coup=="gauche") {
			if (x!=0) {
				if (this.labyrinthe[x-1][y]!=0 && caseObstruee[x-1][y]!=1 && nombrePassage[x-1][y]<1) {
					return true;
				}
			}
		}
		if (coup=="droite") {
			if (x!=taille-1) {
				if (this.labyrinthe[x+1][y]!=0 && caseObstruee[x+1][y]!=1 && nombrePassage[x+1][y]<1) {
					return true;
				}
			}
		}
		return false;
	}

	/**
     * Compte le nombre de cases inaccessibles autour de thésée
     *
     * @param x,y position actuelle
     * @param taille taille de la grille
     * @param caseObstruee cases obstruees de la grille
     * @param nombrePassage nombre de passage sur chaque cases
     * @return nombre de cases inaccessibles
     */
	public int casesNoires (int x, int y, int taille, int[][] caseObstruee, int[][] nombrePassage) {
		int caseN=0;
		if (y==0 || y==taille-1) {
			caseN++;
		}
		if (x==0 || x==taille-1) {
			caseN++;
		}
		if (y!=0) {
			if (this.labyrinthe[x][y-1] == 0 || caseObstruee[x][y-1] == 1 || nombrePassage[x][y-1]>=1) {
				caseN++;
			}
		}
		if (y!=taille-1) {
			if (this.labyrinthe[x][y+1] == 0 || caseObstruee[x][y+1] == 1 || nombrePassage[x][y+1]>=1) {
				caseN++;
			}
		}
        if (x!=0) {
			if (this.labyrinthe[x-1][y] == 0 || caseObstruee[x-1][y] == 1 || nombrePassage[x-1][y]>=1) {
				caseN++;
			}
		}
		if (x!=taille-1) {
			if (this.labyrinthe[x+1][y] == 0 || caseObstruee[x+1][y] == 1 || nombrePassage[x+1][y]>=1) {
				caseN++;
			}
		}
		return caseN;
	}
}
