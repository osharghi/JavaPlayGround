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
public class BattleShip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        StateManager stateManager = new StateManager();
        PlayerScreen player1Screen = new PlayerScreen("Player1", true, stateManager);
        PlayerScreen player2Screen = new PlayerScreen("Player2", false, stateManager);
        GameController gc = GameController.getInstance();
        gc.setStateManager(stateManager);
        gc.addUsers(player1Screen, player2Screen);
        
        
    }
    
}
