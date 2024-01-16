import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * La classe <code>BoutonMenuS</code> affecte les actions a realiser
 * lors de l'activation des boutons du menu secondaire
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class BoutonMenuS implements ActionListener {
    /**
     *  panneaux representant les boutons du menu secondaire et la grille
     */
    public JPanel panel,grid;
    /**
     *  fenetre actuelle
     */
    public JFrame fenetre;     
    /**
     *  grille effective
     */
    public Grille gri;
    /**
     *  champs de texte relatifs aux choix de taille/de nom de fichier
     */
    public JTextField champ,file;
    /**
     *  permet de savoir si la grille sera vide ou remplie aleatoirement
     */
    public int selected;
    /**
     *  positions d'entree et de sortie
     */
    public int xEntre,yEntre,xSortie,ySortie;
    /**
     *  affichage du resultat des algorithmes
     */
    public JLabel nbTent;
    /**
     *  mode de defilement de l'algorithme deterministe
     */
    public String mode;

    /**
     * Constructeur uniquement destine a transmettre les informations de la fenetre
     * 
     * @param p,grid les panneaux de la fenetre contenant le menu et la grille
     * @param frame fenetre actuelle
     * @param gri grille actuelle
     * @param champ,file champs de texte a remplir avec ses preference de taille/de nom de fichier
     * @param nbTent affichage du nombre de tentatives d'un algorithme
     */
    public BoutonMenuS (JPanel p,JPanel grid,JFrame frame,Grille gri,JTextField champ,JTextField file,JLabel nbTent) {
        this.mode="automatique";
        this.panel = p; 
        this.fenetre = frame;
        this.gri=gri;
        this.champ = champ;
        this.file=file;
        this.xEntre=xEntre;
        this.yEntre=yEntre;
        this.xSortie=xSortie;
        this.ySortie=ySortie;
        this.grid=grid;
        this.nbTent=nbTent;
        this.selected=1;
    }
    
    /**
     * Dicte les actions a performer lors de l'interaction avec les
     * boutons du menu secondaire
     * 
     * @param e evenement
     */
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        int valeur;
        String mot;
        
        if (source == "pleine") {
            this.selected=1;
        } 
        if (source == "vide") {
            this.selected=0;
        }  
        if (source == "automatique") {
            this.mode="automatique";
        }  
        if (source == "manuel") {
            this.mode="manuel";
        }   
        if(source == "Nouvelle Grille" ){
            mot = this.champ.getText();
            valeur = Integer.parseInt(mot);
            Grille gr = new Grille(valeur);
            this.fenetre.remove(panel);
            fenetre.setVisible(false);
            fenetre.getContentPane().removeAll();
            fenetre.getContentPane().revalidate();
            fenetre.getContentPane().repaint(); 
            fenetre.setVisible(true);
            gr.creationGrille(valeur,this.selected,this.fenetre);    
        }
            
        if (source == "Algo aleatoire") {  
            int somme=0,i=0;
            while (i != 100 && somme != -1) {
                AlgoAleatoire alea = new AlgoAleatoire(this.gri.tabGrille,this.gri.thx,this.gri.thy,this.gri.sox,this.gri.soy);
                somme+=alea.randomResolver();
                i++;
            }
            this.nbTent.setText("Moyenne de "+somme/i+" coups");
        }

	    if (source == "Algo deterministe") {
            int i=0;
            AlgoDeterm deter = new AlgoDeterm(this.gri.tabGrille,this.gri.thx,this.gri.thy,this.gri.sox,this.gri.soy);
            
            KeyListener[] keyListeners = this.fenetre.getKeyListeners();
            for (KeyListener kl : keyListeners) {
                this.fenetre.removeKeyListener(kl);
            }
            PeutAvancer pa = new PeutAvancer(this.mode,deter.historiqueCoup,this.gri,this.nbTent);
            this.fenetre.addKeyListener(pa);
            this.fenetre.requestFocusInWindow();
            i=deter.resolver();
            if (pa.mode=="automatique") {
                this.nbTent.setText(i+" tentatives");
            }

        }
            if(source == "Sauvegarder" ){
                Sauvegarde.sauvegardeGrille(this.file,this.gri);

            }

        }
    }
