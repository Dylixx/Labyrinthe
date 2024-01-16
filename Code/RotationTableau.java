import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

/**
 * La classe <code>RotationTableau</code> est utilisee pour effectuer une rotation
 * sur un tableau (pour qu'il soit conforme a la sauvegarde)
 *  
 * @version 1.1
 * @author Oscar Williatte et Edouard Schnur
 */
public class RotationTableau {

    /**
     * Effectue une rotation sur le tableau
     * @param arr tableau a tourner
     */
    public static void rotateArray(int[][] arr) {
    int n = arr.length;
    // faire la transposition du tableau
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
    }
    // inverser les colonnes
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n/2; j++) {
            int temp = arr[i][j];
            arr[i][j] = arr[i][n-j-1];
            arr[i][n-j-1] = temp;
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n / 2; j++) {
            int temp = arr[i][j];
            arr[i][j] = arr[i][n - j - 1];
            arr[i][n - j - 1] = temp;
        }
    }

    for(int i = 0; i<n;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j]==0){
                arr[i][j]=1;
            }else{
                arr[i][j]=0;
            }
            
        }
    }


}
}

