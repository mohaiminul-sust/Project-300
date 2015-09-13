/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package this04;

import java.awt.Color;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Shibbir
 */

public class food {
      int[] food_position= new int[400];  // This array contains position of food
      public int[] position_of_lives=new int[1000];   //position of life in LameLand... Thread-2's position will be written like that position_of_lives[2]=k of Thread-2
        public int[] birth_gap_of_life=new int[1000];
        public int[] total_move_toad=new int[1000];
    
      /**
       * 
       * gen_food method generate food and set coordinate  in food_position 
 colour of food is red
       
 e 4 region in thisForm 1st regLameLande y=0 to y=24, 2nd y=25 to y=49, 3rd y=50 to y=74, 4th y=75 to y=99 for well distributed food 
     * @param c
       */
    public void gen_food (LameLand c){
       
        for(int i=0; i<food_position.length;++i){
            food_position[i]=-1;
        }
        Random rand=new Random();
        int flag=1;
        int l=0;
        int random=0;
        for(l=0;l<400;++l){
            if(l<100){
              
                while(flag==1){
                    random=rand.nextInt(2500);
                    flag=check_empty_position(food_position, random);
                    
                }
                flag=1;
               
            }
            else if(l>=100 && l<200){
                
                                while(flag==1){
                    random=rand.nextInt(2500)+2500;
                    flag=check_empty_position(food_position, random);
                     
                }
                flag=1;
            }
            else if(l>=200 && l<300){
               
                    while(flag==1){
                    random=rand.nextInt(2500)+5000;
                    flag=check_empty_position(food_position, random);
                     
                }
                   flag=1;
            }
            else if(l>=300 && l<400){
               
                    while(flag==1){
                    random=rand.nextInt(2500)+7500;
                    flag=check_empty_position(food_position, random);
                     
                }
                 flag=1;
            }
            food_position[l]=random;
           // System.out.println("Food Position"+l+"="+food_position[l]);
             c.label[food_position[l]].setBorder(javax.swing.BorderFactory.createLineBorder(Color.green, 100));
            
        }
        
        
 
    }
    public int check_empty_position(int array[],int check_int){
        //System.out.println("zdnbkb "+check_int);
        for(int i=0;i<array.length;++i){
            if(array[i]==check_int)
                return 1;
        }
        return 0;
        
    }
    public int[] return_fodd_position(){
        return food_position;
    }
    

      
}
