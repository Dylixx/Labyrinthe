import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.File;

/**
 * La classe <code>BoutonMenu</code> affecte les actions a realiser
 * lors de l'activation des boutons du menu principal
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class BoutonMenu implements ActionListener {
    public JPanel panel;
    public JFrame fenetre;     
    public JTextField champ;
    public int selected;
    public BoutonMenu (JPanel p,JFrame frame,JTextField champ) {
        this.panel=p; 
        this.fenetre=frame;
        this.champ = champ;
        this.selected = 1;
    }

    /**
     * Dicte les actions a performer lors de l'interaction avec les
     * boutons du menu
     * 
     * @param e evenement
     */
    public void actionPerformed(ActionEvent e) {
  	    int valeur;
        String mot;
        String source = e.getActionCommand();
        if (source=="pleine") {
           this.selected=1;
        }
        if (source=="vide") {
            this.selected=0;
        }
        if(source == "Créer une grille" ){
          mot = this.champ.getText();
          valeur = Integer.parseInt(mot);
          Grille gr = new Grille(valeur);
          this.fenetre.remove(panel);
          gr.creationGrille(valeur,this.selected,this.fenetre);
        }

        if(source == "Charger une grille" ){
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            String fileName=null;
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fileName = selectedFile.getName();
            }     
            this.fenetre.remove(panel);
            Lecture.lireFichier(fileName,this.fenetre);

        }
    }
}