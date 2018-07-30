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
public class GameOverState implements GameState {
    
    public String title = "Game Over";
    
    @Override
    public String getTitle(){
        return title;
    }
    
    @Override
    public String getInstructions()
    {
        return "Game Over";
    }
}
