/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package this04;

/**
 *
 * @author Shibbir
 */
public class properties_of_life extends Life_Move{
    
        public String eat(LameLand c,int[] food_position1,int[] obstacle_position){
            String s=Thread.currentThread().getName();
            
            int check_position=check_empty_position(food_position1, k);
            
            if(check_position==1){
                if(move_toad<high_level_move_toad){
                    move_toad+=10;
                    return "food";
                   // System.out.println(s+"    MoveTaoad="+move_toad);
                }
            }
            else if(check_position==0){
                check_position=check_empty_position(obstacle_position, k);
                if(check_position==1){
                    move_toad-=5;
                    return "poison";
                  //  System.out.println(s+"            MoveTaoad="+move_toad);
                }
            }
                    
            return "nothing";

    }
}
