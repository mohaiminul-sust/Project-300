/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package this04;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Shibbir
 */
public class Life_Move extends Collition{
    
       public Random rand;
        public int x,y,k;    // x is x-axis grid number of Life so as y. k is no. of lebel 
        public int thread_no,move_toad,high_level_move_toad=150,low_level_move_toad=50;
        public int[] probable_position=new int[9];
        int[] surrounds_of_life=new int[8];
        int direction_of_food=0,direction_of_obs=0;
        public int move(int [] food_position,int[] obs_position){
            
            int direction =-5;
            set_probable_position(food_position,obs_position);
            
            int chek=rand.nextInt(240);
            for(int i=1;i<probable_position.length;++i){
                if(probable_position[i]>=chek){
                    direction=i;
                    break;
                }
            }
            
           // System.out.println("huda "+thread_no+" "+direction);
             if(direction==1){
                 x--;
                 y-=1;
            }
            
            else if(direction==2){
                 
                 y-=1;
            }
            else if(direction==3){
                 x++;
                 y-=1;
            }
            else if(direction==4){
                 
                x++;
            }
            else if(direction==5){
                 x++;
                 y++;
            }
            else if(direction==6){
                 
                y++;
            }
            else if(direction==7){
                 
                 x--;
                 y++;
            }
            else if(direction==8){
                 
                 x--;
            }
        
            
          k=x+y*100;
          return chek;
            //System.out.println("k="+k+" D="+direction);
          
        }
        private void set_probable_position(int[] food_position,int[] obs_position){
            
            
            probable_position[0]=0;
            if((x==0) && (y==0)){
                
                for(int i=1;i<probable_position.length;++i){
                    if(i>3 && i<7){
                        if(i==4)
                            probable_position[i]=80;
                        else if(i==5)
                            probable_position[i]=160;
                        else if(i==6)
                            probable_position[i]=240;
                            
                    }
                    else
                        probable_position[i]=-1;
                }
            }
            else if((x==99) && (y==0)){
               
               for(int i=1;i<probable_position.length;++i){
                    if(i>5 ){
                        if(i==6)
                            probable_position[i]=80;
                        else if(i==7)
                            probable_position[i]=160;
                        else if(i==8)
                            probable_position[i]=240;
                            
                    }
                    else
                        probable_position[i]=-1;
                
               }
            }
            else if((x==99) && (y==99)){
                for(int i=1;i<probable_position.length;++i){
                    
                        if(i==1)
                            probable_position[i]=80;
                        else if(i==2)
                            probable_position[i]=160;
                        else if(i==8)
                            probable_position[i]=240;
                            
                    
                    else
                        probable_position[i]=-1;
                
               }
            }
            
            else if((x==0) && (y==99)){
            for(int i=1;i<probable_position.length;++i){
                    if(i>1 && i<5 ){
                        if(i==2)
                            probable_position[i]=80;
                        else if(i==3)
                            probable_position[i]=160;
                        else if(i==4)
                            probable_position[i]=240;
                            
                    }
                    else
                        probable_position[i]=-1;
                
               }
            }
            
            else if((y==0) && ((x!=0) && (x!=99))){
                for(int i=1;i<probable_position.length;++i){
                    if(i>3 ){
                        if(i==4)
                            probable_position[i]=50;
                        else if(i==5)
                            probable_position[i]=100;
                        else if(i==6)
                            probable_position[i]=150;
                        else if(i==7)
                            probable_position[i]=200;
                        else if(i==8)
                            probable_position[i]=240;
                    }
                    else
                        probable_position[i]=-1;
                
               }
                
            }
            
            
               else if((y==99)&& ((x!=99) && (x!=0))){
                    for(int i=1;i<probable_position.length;++i){
                    
                        if(i==1)
                            probable_position[i]=50;
                        else if(i==2)
                            probable_position[i]=100;
                        else if(i==3)
                            probable_position[i]=150;
                        else if(i==4)
                            probable_position[i]=200;
                        else if(i==8)
                            probable_position[i]=240;
                    
                    else
                        probable_position[i]=-1;
                
               }
                
            }
               
               
               else if((x==99) && ((y!=0) && (y!=99))){
                for(int i=1;i<probable_position.length;++i){
                    
                        if(i==1)
                            probable_position[i]=50;
                        else if(i==2)
                            probable_position[i]=100;
                        else if(i==6)
                            probable_position[i]=150;
                        else if(i==7)
                            probable_position[i]=200;
                        else if(i==8)
                            probable_position[i]=240;
                    
                    else
                        probable_position[i]=-1;
                
               }
                
            }
               
                  else if((x==0) && ((y!=0) && (y!=99))){
                for(int i=1;i<probable_position.length;++i){
                    if(i>1  && i<7){
                        if(i==2)
                            probable_position[i]=50;
                        else if(i==3)
                            probable_position[i]=100;
                        else if(i==4)
                            probable_position[i]=150;
                        else if(i==5)
                            probable_position[i]=200;
                        else if(i==6)
                            probable_position[i]=240;
                    }
                    else
                        probable_position[i]=-1;
                
               }
                
            }
            
            
            else {
                      int retio_of_F_and_obs[]=new int[8];
                      retio_of_F_and_obs[0]=make_retio_of_food_and_obs(k-202, food_position, obs_position);
                      retio_of_F_and_obs[1]=make_retio_of_food_and_obs(k-200, food_position, obs_position);
                      retio_of_F_and_obs[2]=make_retio_of_food_and_obs(k-198, food_position, obs_position);
                      retio_of_F_and_obs[3]=make_retio_of_food_and_obs(k+2, food_position, obs_position);
                      retio_of_F_and_obs[4]=make_retio_of_food_and_obs(k+202, food_position, obs_position);
                      retio_of_F_and_obs[5]=make_retio_of_food_and_obs(k+200, food_position, obs_position);
                      retio_of_F_and_obs[6]=make_retio_of_food_and_obs(k+198, food_position, obs_position);
                      retio_of_F_and_obs[7]=make_retio_of_food_and_obs(k-2, food_position, obs_position);
                     int dir=maximum_position_find(retio_of_F_and_obs);
            
                     
                     
                     for(int i=1;i<probable_position.length;++i){
                if(i==1 && i==dir){
                    probable_position[1]=40;
                    probable_position[2]=80;
                    probable_position[8]=240;
                    
                }
                else if(i==8 && i==dir){
                    probable_position[i-1]=probable_position[i-2]+40;
                    probable_position[i]=probable_position[i-2]+80;
                    probable_position[1]=40;
                }
                else if(i==dir-1){
                    probable_position[i]=probable_position[i-1]+40;
                    probable_position[i+1]=probable_position[i-1]+80;
                    probable_position[i+2]=probable_position[i-1]+120;
                }
                else if(i!=dir && i!=dir-1 && i!=dir+1){
                    probable_position[i]=probable_position[i-1]+24;
                }
                /*    
                if(i==0)
                        probable_position[i]=30;
                    else if(i==probable_position.length-1)
                        probable_position[i]=250;
                    else
                        probable_position[i]=probable_position[i-1]+30;
                */
               }
                     probable_position[0]=250;
                 }
            
        }
        private void set_probability(){
            for(int i=0;i<probable_position.length;i++){
                
            }
        }
        
        private void set_direction_of_food_obs(){
            
            
        }
        public int make_retio_of_food_and_obs(int k,int[] food_position,int[] obs_position){
            int retio=0,food=1,obs=1;
            int flag=0;
            if(check_empty_position(food_position, k-101)==1)
                food++;
             if(check_empty_position(food_position, k-100)==1)
                food++;
             if(check_empty_position(food_position, k-99)==1)
                food++;
             if(check_empty_position(food_position, k-1)==1)
                food++;
             if(check_empty_position(food_position, k+1)==1)
                food++;
             if(check_empty_position(food_position, k+99)==1)
                food++;
             if(check_empty_position(food_position, k+100)==1)
                food++;
             if(check_empty_position(food_position, k+101)==1)
                food++;
             
            if(check_empty_position(obs_position, k-101)==1)
                food++;
             if(check_empty_position(obs_position, k-100)==1)
                food++;
             if(check_empty_position(obs_position, k-99)==1)
                food++;
             if(check_empty_position(obs_position, k-1)==1)
                food++;
             if(check_empty_position(obs_position, k+1)==1)
                food++;
             if(check_empty_position(obs_position, k+99)==1)
                food++;
             if(check_empty_position(obs_position, k+100)==1)
                food++;
             if(check_empty_position(obs_position, k+101)==1)
                food++;
             
             retio=food/obs;
            return retio;
        }
        
        public int maximum_position_find(int[] array){
            int max=0;
            int temp=array[0];
            for(int i=0;i<array.length;i++){
            if(array[i]>temp)
                temp=array[i];
        }
            int count_position=0;
            for(int i=0;i<array.length;++i){
            if(array[i]==temp)
                count_position++;
        }
            Random random=new Random();
            int max_position=random.nextInt(count_position);
            int count=0;
            for(int i=0;i<array.length;++i){
                if(array[i]==temp)
                    count++;
                if(count==max_position)
                    return i;
            }
            return max;
        }
        
        public int check_empty_position(int array[],int check_int){
        //System.out.println("zdnbkb "+check_int);
        for(int i=0;i<array.length;++i){
            if(array[i]==check_int)
                return 1;
        }
        return 0;
        
    }
       /* 
        private int check_surround(){
            for(int i=0;i<surrounds_of_life.length;++i){
            if(i==0){
                int direction_1=k-101;
                check_one_position(i, direction_1);
            }
            else if(i==1){
                 int direction_2=k-100;
                check_one_position(i, direction_2);
            }
            else if(i==2){
                 int direction_3=k-99;
                check_one_position(i, direction_3);
            }
                else if(i==3){
                 int direction_4=k+1;
                check_one_position(i, direction_4);
            }
            else if(i==4){
                 int direction_5=k+101;
                check_one_position(i, direction_5);
            }
            else if(i==5){
                 int direction_6=k+100;
                check_one_position(i, direction_6);
            }
            else if(i==6){
                 int direction_7=k+99;
                check_one_position(i, direction_7);
            }
                else if(i==7){
                 int direction_8=k-1;
                check_one_position(i, direction_8);
            }
        }
            return 0;
        }
        
        private void check_one_position(int i,int direction_no){
               int check=check_empty_position(food_position, direction_no);
                if(check==1){
                    surrounds_of_life[i]=1;
                }
                else{
                    check=check_empty_position(obs, direction_no);
                    if(check==1){
                        surrounds_of_life[i]=-1;
                    }
                    else
                        surrounds_of_life[i]=0;
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
        

   */

        
    
}
