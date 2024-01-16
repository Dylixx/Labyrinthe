/**
 * La classe <code>Deplacement</code> est utilisee pour effectuer un deplacement
 * dans les algorithme de resolution de labyrinthe
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class Deplacement {
	/**
     * Renvoie le deplacement eventuel en X
     *
     * @return deplacement en X
     */
	public static int deplacementX(String coup,int posX) {
		if (coup=="gauche") {
			posX--;
		}
		if (coup=="droite") {
			posX++;
		}
		return posX;
	}

	/**
     * Renvoie le deplacement eventuel en Y
     *
     * @return deplacement en Y
     */
	public static int deplacementY(String coup,int posY) {
		if (coup=="haut") {
			posY--;
		}
		if (coup=="bas") {
			posY++;
		}
		return posY;
	}
}