/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageexplorer;

import java.io.File;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 *
 * @author omidsharghi
 */
public class PackageExplorerDemo {

    public static void main(String[] args) {
                
        //Test directories
        //java -cp "PackageExplorer.jar:/Users/omidsharghi/Desktop/TestClass/"  packageexplorer.PackageExplorerDemo /Users/omidsharghi/Desktop/TestClass/
        //java -cp "PackageExplorer.jar:/Users/omidsharghi/Desktop/CIS_Classes/CS151/Homework/HW4/BattleShip\ Project/BattleShip/build/classes/battleship/"  packageexplorer.PackageExplorerDemo /Users/omidsharghi/Desktop/CIS_Classes/CS151/Homework/HW4/BattleShip\ Project/BattleShip/build/classes/battleship/
        
      ArrayList<String> classList = new ArrayList<String>();
      DirectoryParser dirParse = new DirectoryParser();
            
      //Code below is good to go
      if(args.length != 0)
      {
            final File folder = new File(args[0]);
            classList = dirParse.listFilesForFolder(folder);      
            PackageExplorer pExplorer = new PackageExplorer(classList);
            pExplorer.displayMainMenu(true);
      }
      else
      {
         Path currentRelativePath = Paths.get("");
         String s = currentRelativePath.toAbsolutePath().toString(); 
         final File folder = new File(s);
         classList = dirParse.listFilesForFolder(folder); 
         if(!classList.isEmpty())
         {
            PackageExplorer pExplorer = new PackageExplorer(classList);
            pExplorer.displayMainMenu(true);
         }
         else
         {
            System.out.println("No classes in directory. Quitting.");
            System.exit(0); 
         }
      }
      
    }
    
}
