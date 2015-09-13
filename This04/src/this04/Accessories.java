/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package this04;

import java.io.File;
import java.time.LocalDateTime;

/**
 *
 * @author Andromeda
 */
public class Accessories {

    public Accessories() {
        System.out.println("Accessories accessed at "+ LocalDateTime.now().toString());
    }
    
    
     
    public boolean createDir(String dir_name){
//        String usrdir = System.getProperty("user.dir");
       File new_dir= new File(dir_name);
       
       if(!new_dir.exists()){
           boolean result = false;
           
           try {
               result=new_dir.mkdir();
               if (result) {
                   System.out.println("Directory " + dir_name + " created!");
                   return true;
               }
           } catch (SecurityException se) {
               se.printStackTrace();
           }
           
       }
       return false;
       }
    
}
