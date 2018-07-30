/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageexplorer;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;


/**
 *
 * @author omidsharghi
 */
public class DirectoryParser {
    
    public ArrayList<String> listFilesForFolder(final File folder) {
        ArrayList<String> classList = new ArrayList<String>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) 
            {
                listFilesForFolder(fileEntry);
            } 
            else 
            {
                if(getFileExtension(fileEntry).equals("class"))
                {
                  String className = fileEntry.getName();
                  className = className.substring(0, className.lastIndexOf('.'));
                  if(className.indexOf("$")<0)
                  {
                    classList.add(className);
                  }
                } 
            }
        }
        return classList;
    }
  
    public String getFileExtension(File file) {
        String name = file.getName();
            try {
                return name.substring(name.lastIndexOf(".") + 1);
            } catch (Exception e) {
            return "";
        }
     }
    
}
