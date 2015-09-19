/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package this04;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import javafx.scene.layout.Border;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Shibbir
 */
public class LameLand extends JFrame{
    JLabel[] label;
    JPanel panel;
    Icon m;
    
   // label =new JLabel[100];
    public LameLand(){
        super("LameLand");
       // m=new ImageIcon("life.png");
        label=new JLabel[10000];
        panel=new JPanel();
        panel.setLayout(new GridLayout(100, 100));
      // label[0]=new JLabel();
      // panel.add(label[0]);
        for(int i=0;i<10000;++i){
           //hread.sleep(1000);
            label[i]=new JLabel();

         
    label[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
           // if(i==10)
          // label[i].setBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 100));
            panel.add(label[i]);
        }
        add(panel);

        
    }
    
   


    
}
