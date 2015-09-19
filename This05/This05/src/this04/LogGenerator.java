/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package this04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shibbir
 */
public class LogGenerator {
    PrintWriter writer = null;
    
    
   public void LG(String file_name) {
       
       try {
           
           writer = new PrintWriter(file_name, "UTF-8");
           
       } catch (FileNotFoundException | UnsupportedEncodingException ex) {
           Logger.getLogger(LogGenerator.class.getName()).log(Level.SEVERE, null, ex);
       }
    } 
   
   public void write(String t){
       writer.println(t);
   }
   
   public void closefile(){
       writer.close();
   }
   
  
       
   }



