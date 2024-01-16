import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

/**
 * La classe <code>Sauvegarde</code> permet de sauvegarder la grille sous
 * la forme d'un fichier
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class Sauvegarde {
	/**
     * Effectue la sauvegarde de la grille
     * @param fichier champ ou est contenu le nom du fichier
     * @param gri grille a sauvegarder
     */
	public static void sauvegardeGrille (JTextField fichier,Grille gri){
		int taille = gri.tabGrille.length,i,j;
		byte premierOctet = (byte) taille;
		System.out.println("premier : "+premierOctet);
		byte yThesee = (byte) gri.thy;
		System.out.println("deuxieme : "+yThesee);
		byte xThesee = (byte) gri.thx;
		System.out.println("troisieme : "+xThesee);
		byte yExit = (byte) gri.soy;
		System.out.println("quatrieme : "+yExit);
		byte xExit = (byte) gri.sox;
		System.out.println("cinquieme : "+xExit);
		String nomFichier = fichier.getText();
		int[][] vraiGrille = gri.tabGrille.clone();
		for (i = 0; i < gri.tabGrille.length; i++) {
    		vraiGrille[i] = gri.tabGrille[i].clone();
		}

		RotationTableau.rotateArray(vraiGrille);

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(nomFichier);
			DataOutputStream dos = new DataOutputStream(fos);

			try{
				dos.writeByte(premierOctet);
				dos.writeByte(yThesee);
				dos.writeByte(xThesee);
				dos.writeByte(yExit);
				dos.writeByte(xExit);
			}catch(IOException e){
				System.out.println("Erreur ecriture");
			}
		
		// Ecrire les données de la grille dans les bits restants
		int bitsRemaining = 8;
		byte currentByte = 0;
		
		for (i = 0; i < vraiGrille.length; i++) {
    		for (j = 0; j < vraiGrille.length; j++) {
    			System.out.print(vraiGrille[i][j]);
        		if (vraiGrille[i][j] == 1) {
            		currentByte |= (1 << (bitsRemaining - 1));
        		}

        		bitsRemaining--;
        		if (bitsRemaining == 0) {
           			try{
           				dos.writeByte(currentByte);
           				bitsRemaining = 8;
            			currentByte = 0;
           			}catch(IOException e){
           				System.out.println("Erreur ecriture");
           			}
           		}   			
        	}
        	System.out.print("\n");
    	}
	

		// Si nous avons encore des bits non écrits, écrire le dernier octet partiellement rempli
		if (bitsRemaining > 0) {
			try{
				dos.writeByte(currentByte);
			}catch(IOException e){
				System.out.println("Erreur ecriture");
			}
		}

		try{
			fos.close();
		}catch (IOException e) {
			System.out.println("Erreur fermeture");
		}}catch(FileNotFoundException e){
			System.out.println("Erreur ouverture");
		}

	}


}