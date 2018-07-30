/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageexplorer;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner; 
import java.lang.reflect.*;
import java.util.HashMap;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;


public class PackageExplorer {
    
    private final ArrayList<String> classList;
    private final HashMap<String, ClassData> classMap;
    
    PackageExplorer(ArrayList<String> classList)
    {
        this.classList = classList;
        classMap = new HashMap<>();
        
        for(int i = 0; i<classList.size(); i++)
        {
            classMap.put(classList.get(i), new ClassData());
        }        
        
        for(int i = 0; i<classList.size(); i++)
        {
            configureClassData(classList.get(i));            
        }  
    }
      
    public void displayMainMenu(boolean isIntro)
    {
      Scanner scan = new Scanner(System.in);
      if(isIntro)
      {
          System.out.println("\nWelcome to PackageExplorer - Main Menu");
          System.out.println("--------------------------------------");
      }
      else
      {
          System.out.println("\nPackageExplorer - Main Menu");
          System.out.println("----------------------------");
      }
      System.out.println("1. List all classes:");
      System.out.println("2. View a class"); 
      System.out.println("3. Save all classes"); 
      System.out.println("4. Load class info from xml");
      System.out.print("Enter your choice (1-4) or q to quit: ");
      String s = scan.next();
      
      boolean isSelectionValid = false;
       
      while(!isSelectionValid)
      {
        if(s.length()==1)  
        {
            switch (s) {
                case "q":
                    System.out.println("Goodbye!!");
                    System.exit(0);
                case "1":
                    isSelectionValid = true;
                    displayClasses();
                    break;
                case "2":
                    isSelectionValid = true;
                    viewAClass(false);
                    break;
                case "3":
                    isSelectionValid = true;
                    saveAllClassesToXML();
                    break;
                case "4":
                    isSelectionValid = true;
                    loadXML();
                    break;
                default:
                    System.out.print("Please enter either a number between 1 and 3 or q to quit: ");
                    s = scan.next();
                    isSelectionValid = false;
                    break;
            }
        }
        else
        {
          System.out.print("Please enter either a number between 1 and 3 or q to quit: ");
          s = scan.next();
          isSelectionValid = false;
        }
      }
    }
    
    private void displayClasses()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nList of classes:");
        System.out.println("-----------------");
        for(int i = 0; i<classList.size(); i++)
        {
            System.out.println((i+1) + ". " + classList.get(i));
        }
        
        System.out.print("Enter (1" + "-" + classList.size() + ")" + " to view details or m for main menu: ");
        String s = scan.next();
        
        boolean isSelectionValid = false;
        while(!isSelectionValid)
        {
            if(s.equals("m"))
            {
                displayMainMenu(false);
            }
            else
            {
                try
                {
                   int selection = Integer.parseInt(s);
                   if(selection>0 && selection<=classList.size())
                   {
                       isSelectionValid = true;
                       String className = getClassFromSelection(selection);
//                       displayClassDetails(className);
                       ClassData cObj = classMap.get(className);
                       displayClassDetails(cObj);
                   }
                   else
                   {
                       System.out.print("Enter (1" + "-" + classList.size() + ")" + " to view details or m for main menu: ");
                       s = scan.next();
                       isSelectionValid = false;
                   }
                }
                catch(NumberFormatException e)
                {
                    System.out.print("Enter (1" + "-" + classList.size() + ")" + " to view details or m for main menu: ");
                    s = scan.next();
                    isSelectionValid = false;
                }  
            }
        }
    }
    
    private String getClassFromSelection(int i)
    {
        return classList.get(i-1);
    }
    
    private void configureClassData(String className)
    {
        ClassData cObj = classMap.get(className);
        try
        {
            Class c = Class.forName(className);
            cObj.setName(c.getSimpleName());
            if(c.getSuperclass() != null)
            {
                cObj.setSuperClass(c.getSuperclass().getSimpleName());
            }
                        
            Class[] interfaces = c.getInterfaces();
            if(interfaces.length != 0)
            {
                for (Class intf : interfaces) {
                    cObj.addInterface(intf.getSimpleName());
                }
            }
            
            Field[] fieldsDeclared = c.getDeclaredFields();
            if(fieldsDeclared.length !=0)
            {
                for (Field fields : fieldsDeclared) {
                    String field = fields.getName() + ": " + Modifier.toString(fields.getModifiers());
                    cObj.addField(field);
                    //Check for providers
                    String other = fields.getType().getSimpleName();
                    ClassData otherObj = classMap.get(other);
                    if(otherObj !=null)
                    {
                        cObj.addProvider(other);
                        otherObj.addClient(c.getSimpleName());
                    }
                }
            }
            
            Method[] methodsDeclared = c.getDeclaredMethods();
            if(methodsDeclared.length != 0)
            {
                for (Method methods : methodsDeclared) {
                    String method = methods.getName() + ": " + Modifier.toString(methods.getModifiers());
                    cObj.addMethod(method);
                }
            }
        }
        catch (Exception e)
        {
           System.out.println(e.getMessage());
           e.printStackTrace();
        } 
    }
    
    private void viewAClass(boolean repeatAttempt)
    {
        Scanner scan = new Scanner(System.in);
        if(!repeatAttempt)
        {
            System.out.print("\nEnter a class name or m to return to main menu: ");
        }
        else {
            System.out.print("\nClass not found. Seach another class or "
                        + "enter m to return to main menu: ");
        }
        String s = scan.next();
        boolean classFound = false;
        
        if(s.equals("m"))
        {
            displayMainMenu(false);
        }
        else
        {
            String cap = s.substring(0, 1).toUpperCase() + s.substring(1);
            String low = s.substring(0, 1).toLowerCase() + s.substring(1);
            for(int i=0; i<classList.size(); i++)
            {       
                if(classList.get(i).equals(cap))
                {
//                    displayClassDetails(cap);
                    ClassData cObj = classMap.get(cap);
                    displayClassDetails(cObj);
                    break;
                }
                else if(classList.get(i).equals(low))
                {
//                    displayClassDetails(low);
                    ClassData cObj = classMap.get(low);
                    displayClassDetails(cObj);
                    break;
                }
            }
        viewAClass(true);    
        }
    }
    
//    private void displayClassDetails(String className)
    private void displayClassDetails(ClassData cObj)
    {        
        
//        ClassData cObj = classMap.get(className);
         
        System.out.println("\nClass Details");
        System.out.println("--------------");

       //Print Class
        System.out.println("\nName: " + cObj.getName());

       //Print Superclass
        System.out.print("\nSuperclass: ");

        if(cObj.getSuperClass() != null)
        {
             System.out.print(cObj.getSuperClass() + "\n");
        }
        else
        {
            System.out.print("None" + "\n");
        }

        //Print Interfaces
        ArrayList<String> interfaces = cObj.getInterfaces();
        System.out.println("\nInterfaces: ");
        if(interfaces.isEmpty())
        {
            System.out.println("None");
        }
        else
        {
             for(int i =0; i<interfaces.size(); i++)
             {
                 System.out.println(interfaces.get(i));
             }
        }

        //Print Declared Fields
        ArrayList<String> fields = cObj.getFields();
        System.out.println("\nDeclared Fields: ");
        if(fields.isEmpty())
        {
             System.out.println("None");
        }
        else
        {
            for(int j = 0; j<fields.size(); j++)
             {
                 System.out.println(fields.get(j));
             }
        }

        //Print Declared Methods
         ArrayList<String> methods = cObj.getMethods();
        System.out.println("\nDeclared Methods: ");
        if(methods.isEmpty())
        {
             System.out.println("None");   
        }
        else
        {
            for(int j = 0; j<methods.size(); j++)
             {
                 System.out.println(methods.get(j));
             }
        }

        //Print Providers
        ArrayList<String> providers = cObj.getProviders();
        System.out.println("\nProviders: ");
        if(providers.isEmpty())
        {
             System.out.println("None");
        }
        else
        {
            for(int j = 0; j<providers.size(); j++)
             {
                 System.out.println(providers.get(j));
             }
        }

        //Print Clients
        ArrayList<String> clients = cObj.getClients();
        System.out.println("\nClients: ");
        if(clients.isEmpty())
        {
            System.out.println("None\n");

        }
        else
        {
             for(int j = 0; j<clients.size(); j++)
             {
                 System.out.println(clients.get(j));
             }
             
             System.out.println("");
        }

        boolean isSelectionValid = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter s to save or m to return to main menu: ");
        String s = scan.next();
        while(!isSelectionValid)
        {
            if(s.length() == 1)
            {
                switch(s){
                    case "s":
                        isSelectionValid = true;
                        saveClassToXML(cObj);
                        break;
                    case"m":
                        isSelectionValid = true;
                        displayMainMenu(false);
                        break;
                    default:
                        System.out.print("Please enter s to save or m to return to main: "
                                + "menu: ");
                        s = scan.next();
                        isSelectionValid = false;
                        break;
                }   
            }
            else
            {
                System.out.print("Please enter s to save or m to return to main: "
                                + "menu: ");
                s = scan.next();
                isSelectionValid = false;
            }
        }
    } 
    
    private void saveAllClassesToXML()
    {
        boolean isInputValid = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        String s = scan.next();
        
        while(!isInputValid)
        {
            if(s.length() == 0 || s.equals("") ||s.equals(" "))
            {
                isInputValid = false;
                System.out.print("Please enter a valid file name: ");
                s = scan.next();
            }
            else
            {
                String fileName = s + ".xml";
                writeAllClassesToXML(fileName);
            }  
        }
    }
    
    private void writeAllClassesToXML(String fileName)
    {
        XMLEncoder enc=null;
        try{
            enc=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
        }catch(FileNotFoundException fileNotFound){
                System.out.println("Unable to save file.");
        }
        
        if(enc != null)
        {
            for(int i=0; i<classList.size(); i++)
            {
                ClassData cObj = classMap.get(classList.get(i));
                enc.writeObject(cObj);

            }
            enc.close();

            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Saved all class info in " + fileName + " at: " + s);
            displayMainMenu(false);
        }
        else
        {
            System.out.println("Unable to save classes");
            displayMainMenu(false);   
        }
    }
    
    private void saveClassToXML(ClassData cObj)
    {
        String fileName = cObj.getName() + ".xml";
        
        XMLEncoder enc=null;
        
        try{
            enc=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
        }catch(FileNotFoundException fileNotFound){
                System.out.println("Unable to save file.");
        }
        
        enc.writeObject(cObj);
        enc.close();

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Class has been saved as " + fileName + " at: " + s); 
        displayMainMenu(false);

    }
    
    private void loadXML()
    {
        boolean isInputValid = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter path to XML file or m to return to main menu: ");
        String s = scan.next();

        while(!isInputValid)
        {
            if(s.equals("m") || s.equals("M"))
            {
                displayMainMenu(false);
            }
            else
            {
                File file = new File(s);
                if (!file.isDirectory())
                {
                    DirectoryParser directoryParser = new DirectoryParser();
                    String ext = directoryParser.getFileExtension(file);
                    if(ext.equals("xml"))
                    {
                        System.out.println("Equals XML");
                        isInputValid = true;
                        decodeXML(file);
                    }
                    else
                    {
                        System.out.print("Please enter a valid path to XML file or m to return to main menu: ");
                        s = scan.next();
                    }
                }
                else
                {
                    System.out.print("Please enter a valid path to XML file or m to return to main menu: ");
                    s = scan.next();
                }
            }
        }
    }
    
    private void decodeXML(File file)
    {
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            ClassData classData = (ClassData) xmlDecoder.readObject();
            displayClassDetails(classData);
        }
        catch(FileNotFoundException fileNotFound){
                System.out.println("Unable to open file.");
        }
    }
}
