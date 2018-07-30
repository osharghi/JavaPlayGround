/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Color;
import java.util.ArrayList;
/**
 *
 * @author omidsharghi
 */
public class PlayerData {
    
    private int myFloatingShips;
    private int mySunkShips;
    private int numOfEnemySunk;
    

    PlayerData(){
        
        myFloatingShips = 0;
        mySunkShips = 0;
        numOfEnemySunk = 0;
    }
    
    public int numOfFloatingShips()
    {
        return myFloatingShips;
    }
    
    public int numOfMySunkShips()
    {
        return mySunkShips;
    }
    
    public int numOfEnemySunk()
    {
        return numOfEnemySunk;
    }

    public void incrementMyFloatingShips()
    {
        ++myFloatingShips;
    }
    
    public void decrementMyFloatingShips()
    {
        --myFloatingShips;
        ++mySunkShips;
    }
    
    public void incrementNumOfEnemySunk()
    {
        ++numOfEnemySunk;
    } 
}
