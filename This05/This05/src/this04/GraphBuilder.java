/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package this04;

import org.LiveGraph.dataFile.write.DataStreamWriter;
import org.LiveGraph.dataFile.write.DataStreamWriterFactory;

/**
 *
 * @author Andromeda
 */
public class GraphBuilder {
    
    public static final String dir = System.getProperty("user.dir");
  
    
      DataStreamWriter GraphBuilderInit(DataStreamWriter out, String name, String info){
        //write construct
        System.out.println("LiveLog initiating....");
        
        out= DataStreamWriterFactory.createDataWriter(dir, name);
        //set value separator
        out.setSeparator(";");
        //set info
        out.writeFileInfo(info);
        
        System.out.println("Livelog initiation complete...");
         
        //returning the modified datawriter object
        return out;
    }
    
    
    public void setColumn(DataStreamWriter out, String columns[]){
        //add data series
       for(String column : columns){
           System.out.println("adding "+column);
           out.addDataSeries(column);
       }
        System.out.println("Data series added...");
    }
    
    public void writeData(DataStreamWriter out, Double values[]){
        //set-up data values
        for(Double value : values){
            out.setDataValue(value);
            System.out.println("Writing....." + value);
        }
        //write to disk
        out.writeDataSet();
        
        //check IOErrors
        if(out.hadIOException()){
            out.getIOException().printStackTrace();
            out.resetIOException();
        }
    }
    
    public void closeGraph(DataStreamWriter out){
        out.close();
    }
    
}
