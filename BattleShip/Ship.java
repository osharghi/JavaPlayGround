/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.ArrayList;

/**
 *
 * @author omidsharghi
 */
public class Ship {
    
    private int hitCount;
    private boolean isSunk;
    public ShipPanel p1;
    public ShipPanel p2;
    public ShipPanel p3;

    Ship(ShipPanel panel1, ShipPanel panel2, ShipPanel panel3)
    {
        this.hitCount = 0;
        this.isSunk = false;
        this.p1 = panel1;
        this.p2 = panel2;
        this.p3 = panel3;
    }
    
    public void incrementHitCount()
    {
        ++hitCount;
        
        if(hitCount == 3)
        {
            isSunk = true;
        } 
    }
    
    public boolean isSunk()
    {
        return isSunk;
    }
}
