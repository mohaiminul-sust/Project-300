/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package this04;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Shibbir
 * 
 */
/**
 * 
 * properties contains properties of life. Food for Life
 */
public class properties extends food{
    int[] obstacle_position=new int[200];                    
    LogGenerator rock_log=new LogGenerator();
    
    /**
     * gen_obstacle is a function for generating Obstacle in LameLand
     * @param c 
     */
    public void gen_obstacle(LameLand c){
        
        Random rand = new Random();
      
       // obstacle_position=new int[200];
        for(int i=0;i<obstacle_position.length;++i)
            obstacle_position[i]=-1;
        
        for(int ii=0;ii<obstacle_position.length;++ii){
            int flag=1;
            int random=0;
            //obstacle_position[ii]=rand.nextInt(10000);
             while(flag==1){
                   // random=rand.nextInt(2500)+7500;
                   random=rand.nextInt(10000); 
                 flag=check_empty_position(obstacle_position, random);
                    if(flag==0)
                        flag=check_empty_position(food_position, random);
                  
                }
             obstacle_position[ii]=random;
              
           
            c.label[obstacle_position[ii]].setBorder(javax.swing.BorderFactory.createLineBorder(Color.red, 100)); //Set a label as a position of obstacle with color red
        }
        
    }
    
    public int[] return_obs_position(){
        return obstacle_position;
    }
    

    
}
