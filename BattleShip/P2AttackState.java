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
public class P2AttackState implements GameState{
    
    public String title = "Player 2 Attack";
    boolean attackPlaced;
   
    P2AttackState()
    {

        attackPlaced = false;
    }
    
    @Override
    public String getTitle(){
        return title;
    }
    
    @Override
    public String getInstructions()
    {
        return "Pick a position on the gray grid to sink an enemy ship then "
                + "press 'Next'";
    }
    
}
