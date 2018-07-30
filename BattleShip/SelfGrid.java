/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
 import java.util.List; 


/**
 *
 * @author omidsharghi
 */

/**
Represents the player's own grid
*/
public class SelfGrid extends BattleGrid {
    
    PlayerScreen pScreen;
    
    public SelfGrid(String name, PlayerScreen playerScreen) {
        super();
        this.pScreen = playerScreen;   
    }

    @Override
    protected JPanel getCell(int x, int y, JPanel parentPanel)
    {
        ShipPanel p1 = new ShipPanel();
        p1.setBackground(Color.black);
        p1.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        p1.setPreferredSize(new Dimension(20, 20));
        p1.componentNumber = 10*y+x;
        p1.isHit = false;

        p1.addMouseListener(new MouseAdapter() { 
          public void mousePressed(MouseEvent me) {
            
            int next = 10*(y)+(x+1);
            Component[] components = parentPanel.getComponents();
            ShipPanel p2 = (ShipPanel)components[next];
            ShipPanel p3 = (ShipPanel)components[next+1];
            pScreen.checkAndAddShips(p1, p2, p3);
            
          }
        }); 

        return p1;
    }
}
