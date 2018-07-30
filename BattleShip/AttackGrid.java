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

/**
 *
 * @author omidsharghi
 */
/**
Represents the player's own grid
*/
public class AttackGrid extends BattleGrid {
    PlayerScreen pScreen;
    
    public AttackGrid(String name, PlayerScreen playerScreen) {
        super();
        this.pScreen = playerScreen;
    }

    @Override
    protected JPanel getCell(int x, int y, JPanel parentPanel)
    {
        ShipPanel p1 = new ShipPanel();
        p1.setBackground(Color.black);
        p1.setBorder(BorderFactory.createLineBorder(Color.lightGray, 5));
        p1.setPreferredSize(new Dimension(20, 20));
        p1.componentNumber = 10*y+x;
        p1.isHit = false;

        p1.addMouseListener(new MouseAdapter() { 
            
          public void mousePressed(MouseEvent me) {
              
                Color color = p1.getBackground();
                if(color != Color.blue)
                {
                    pScreen.attackAttempted(p1);
                }
          } 
          
        }); 

        return p1;
    }
}
