import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
/**
 * La classe <code>Lecture</code> cree un tableau de grille par rapport a
 * un fichier
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class Lecture {
    /**
     * cree une grille en lisant le fichier en parametre sur la fenetre
     * 
     * @param nomFichier nom du fichier a exploiter
     * @param fenetre fenetre ou sera affichee la grille
     */
    public static void lireFichier(String nomFichier,JFrame fenetre) {
        int taille=0, xEntre=0, yEntre=0, xSortie=0, ySortie=0, nbBits;
        int[][] tableau=null;
        try {
            FileInputStream fichier = new FileInputStream(nomFichier);

            int octetActuel = fichier.read();
            taille = (int) octetActuel;

            octetActuel = fichier.read();
            yEntre = (int) octetActuel;

            octetActuel = fichier.read();
            xEntre = (int) octetActuel;

            octetActuel = fichier.read();
            ySortie = (int) octetActuel;

            octetActuel = fichier.read();
            xSortie = (int) octetActuel;
            octetActuel = fichier.read();

            nbBits = taille*taille;
            tableau = new int[taille][taille];

            int bitsLus = 0;
            int k=7;
            for (int i = 0; i < taille && bitsLus < nbBits; i++) {
                // On va décomposer en binaire ce qu'il y a dans l'octet pour lire bit par bit en isolant les bits sur le bit de poids faible pour que ca fasse que 1 ou 0
                for (int j = 0; j < taille && bitsLus < nbBits; j++) {
                    if(k>=0 && bitsLus < nbBits){
                        int bit = (octetActuel >> k) & 1;
                        tableau[i][j]=bit;
                        bitsLus++;
                        k--;
                    }else if(k<0 && bitsLus < nbBits){
                        k=7;
                        octetActuel = fichier.read();
                        int bit = (octetActuel >> k) & 1;
                        tableau[i][j]=bit;
                        bitsLus++;
                        k--;
                    }
                }

            }
            try {
                fichier.close();
            } catch (IOException e) {
                System.out.println("Erreur fermeture");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        GrilleFichier grid = new GrilleFichier(tableau,yEntre,xEntre,ySortie,xSortie);
        grid.creationGrilleFichier(fenetre);
    }
}