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
public abstract class BattleGrid extends JPanel {
    public BattleGrid() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel self = new JPanel();
        self.setLayout(new GridLayout(0,10));
        for (int i = 0; i < 10; i++)
            for(int j =0; j < 10; j++) {
                self.add(getCell(j, i, self));
            }
        this.add(self);
    }
    protected abstract JPanel getCell(int x, int y, JPanel parentPanel);
}
