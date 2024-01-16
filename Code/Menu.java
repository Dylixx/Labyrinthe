import javax.swing.*;
import java.awt.*;
import java.lang.*;
/**
 * La classe <code>Menu</code> affiche le menu principal
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class Menu {
   /**
     * cree la fenetre puis le menu de depart et ses boutons
     * 
     */
   public static void main (String[] args){
      
      ButtonGroup groupe = new ButtonGroup();
      JRadioButton rb1 = new JRadioButton("pleine");
      JRadioButton rb2 = new JRadioButton("vide");
      JButton b1 = new JButton("Créer une grille");
      JButton b2 = new JButton("Charger une grille");
      JTextField champ = new JTextField(10);
      JFrame fenetre = new JFrame();
      JPanel panelMenu = new JPanel();
      
      BoutonMenu ctrl = new BoutonMenu (panelMenu,fenetre,champ);

      groupe.add(rb1);
      groupe.add(rb2);
      fenetre.setSize(1920, 1080);
      fenetre.setLocation(0, 0);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.add(panelMenu);
      panelMenu.setBounds(40,80,200,200);
      panelMenu.add(b2);
      panelMenu.add(b1);
      panelMenu.add(champ);
      panelMenu.add(rb1);
      panelMenu.add(rb2);
      /*ajouter des boutons au panneau, ajouter à la fenetre, ajouter ActionListener aux boutons : */ 
      b1.addActionListener(ctrl);
      b2.addActionListener(ctrl);
      rb1.addActionListener(ctrl);
      rb2.addActionListener(ctrl);
      fenetre.setVisible(true);
   }
}