/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author omidsharghi
 */
public class P2SetUpState implements GameState {
    
    public String title = "Player 2 Setup";
    
    @Override
    public String getTitle(){
        return title;
    }
    
    @Override
    public String getInstructions()
    {
        return "Pick 5 positions on the blue grid for your ships to be placed.";
    }
    
}
