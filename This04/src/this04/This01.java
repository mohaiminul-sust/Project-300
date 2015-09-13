/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package this04;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Shibbir
 */
public class This01 {

    /**
     * this is the main class of this project
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
      System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
     
 ThreadCon t=new ThreadCon();
   //t.close_lg();
 t.threadEngine();
        System.out.println("okey!");
    }
    
}
