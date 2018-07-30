/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageexplorer;
import java.lang.reflect.*;
import java.util.ArrayList;

/**
 *
 * @author omidsharghi
 */
public class ClassData {
    
    private String name;
    private String superClass;
    private ArrayList<String> interfaces;
    private ArrayList<String> methods;
    private ArrayList<String> fields;
    private ArrayList<String> providers;
    private ArrayList<String> clients;
    
    public ClassData()
    {
        interfaces = new ArrayList<>();
        methods = new ArrayList<>();
        fields = new ArrayList<>();
        providers = new ArrayList<>();
        clients = new ArrayList<>();
    }
    
    public void setName(String cName)
    {
        name = cName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setSuperClass(String superName)
    {
        superClass = superName;
    }
    
    public String getSuperClass()
    {
        return superClass;
    }
    
    public void addInterface(String iName)
    {
        interfaces.add(iName);
    }
    
    public void setInterfaces(ArrayList<String> interfaces)
    {
        this.interfaces = interfaces;
    }
    
    public ArrayList<String> getInterfaces()
    {
        return interfaces;
    }
    
    public void addMethod(String mName)
    {
        methods.add(mName);
    }
    
    public void setMethods(ArrayList<String> methods)
    {
        this.methods = methods;   
    }
    
    public ArrayList<String> getMethods()
    {
        return methods;
    }
    
    public void addField(String fName)
    {
        fields.add(fName);    
    }
    
    public void setFields(ArrayList<String> fields)
    {
        this.fields = fields;   
    }
    
    public ArrayList<String> getFields()
    {
        return fields;
    }
    
    public void addProvider(String pName)
    {
        providers.add(pName);    
    }
    
    public void setProviders(ArrayList<String> providers)
    {
        this.providers = providers;    
    }
    
    public ArrayList<String> getProviders()
    {
        return providers;
    }
    
    public void addClient(String cName)
    {
        clients.add(cName);    
    }
    
    public void setClients(ArrayList<String> clients)
    {
        this.clients = clients;    
    }
    
    public ArrayList<String> getClients()
    {
        return clients;
    }
}
