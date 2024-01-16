import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>MenuSecondaire</code> permet d'afficher le menu present
 * a cote de la grille
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class MenuSecondaire {
   /**
     * met en place les boutons du menu secondaire dans un panneau
     * puis sur la fenetre
     * 
     */
   public static void menuSecondaire (JFrame fenetre,JPanel grille, Grille laby){
      JLabel nbTent = new JLabel("Selectionnez un algo");
      JButton bt1 = new JButton("Nouvelle Grille");
      JTextField champ = new JTextField(10);
      JTextField file = new JTextField(20);
      JButton bt3 = new JButton("Sauvegarder");
      JButton bt4 = new JButton("Algo aleatoire");
      JButton bt5 = new JButton("Algo deterministe");
      JRadioButton rb1 = new JRadioButton("pleine");
      JRadioButton rb2 = new JRadioButton("vide");
      JRadioButton rb3 = new JRadioButton("automatique");
      JRadioButton rb4 = new JRadioButton("manuel");
      ButtonGroup gr1 = new ButtonGroup();
      ButtonGroup gr2 = new ButtonGroup();

      GridLayout grid = new GridLayout(4,4);
      JPanel panelMenuCote = new JPanel();
      panelMenuCote.setLayout(grid);
      gr1.add(rb1);
      gr1.add(rb2);
      gr2.add(rb3);
      gr2.add(rb4);
      fenetre.add(panelMenuCote, BorderLayout.WEST);
      fenetre.add(grille, BorderLayout.CENTER);  
      
      BoutonMenuS ctrl2 = new BoutonMenuS (panelMenuCote,grille,fenetre,laby,champ,file,nbTent);
      panelMenuCote.setBounds(40,80,200,200);
      
      //panelMenuCote.add(bt2);
      panelMenuCote.add(bt5);
      panelMenuCote.add(rb3);
      panelMenuCote.add(rb4);
      panelMenuCote.add(bt4); //bouton Algo aléatoire
      panelMenuCote.add(bt3); //Sauvegarder
      panelMenuCote.add(file); //nom du fichier
      panelMenuCote.add(bt1); //Nouvelle Grille
      panelMenuCote.add(champ); //taille grille
      panelMenuCote.add(rb1);
      panelMenuCote.add(rb2);
      panelMenuCote.add(nbTent);
      //ajout des actionListener pour BoutonMenuS
      bt1.addActionListener(ctrl2);
      bt3.addActionListener(ctrl2);
      bt4.addActionListener(ctrl2);
      bt5.addActionListener(ctrl2);
      rb1.addActionListener(ctrl2);
      rb2.addActionListener(ctrl2);
      rb3.addActionListener(ctrl2);
      rb4.addActionListener(ctrl2);
      //bt2.addActionListener(ctrl2);


      
      
        
      


     
      /*ajouter des boutons au panneau, ajouter à la fenetre, ajouter ActionListener aux boutons : */ 

      


     
  }

}
