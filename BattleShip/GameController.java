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
public class GameController {
    
    StateManager stateManager;
    PlayerScreen p1;
    PlayerScreen p2;
    PlayerScreen currentPlayerScreen;
    PlayerScreen enemyPlayerScreen;
    private static GameController instance = null;
    
    private GameController() {
       
    }

    public static GameController getInstance() {
      if(instance == null) {
         instance = new GameController();
      }
    
      return instance;
    }
   
    public void setStateManager(StateManager stateMgr)
    {
       if(stateManager == null)
       {
            stateManager = stateMgr;
       }
    }
    
    public void addUsers(PlayerScreen p1Screen, PlayerScreen p2Screen)
    {
        p1 = p1Screen;
        p2 = p2Screen;
    }
    
    void checkAndUpdateHit(int x, ShipPanel attackGridShipPanel)
    {
        ArrayList<Ship> enemyShips;
        
        if(stateManager.inP1AttackState())
        {
            enemyShips = p2.getShips();
            enemyPlayerScreen = p2;
            currentPlayerScreen = p1;   
        }
        else // in P2AttackState
        {
            enemyShips = p1.getShips();
            enemyPlayerScreen = p1;
            currentPlayerScreen = p2;
        }
        
        for(int i = 0; i<5; i++)
        {
            Ship ship = enemyShips.get(i);
            if (ship.p1.componentNumber == x)
            {
                ship.p1.isHit = true;
                ship.incrementHitCount();
                if (ship.isSunk())
                {
                    enemyPlayerScreen.decrementMyFloatingShips();
                    currentPlayerScreen.incrementNumOfEnemySunk();
                    updateSunkColor(ship);
                }
                attackGridShipPanel.isHit = true;
                attackGridShipPanel.setBackground(Color.red);
                break;
            } 
            else if (ship.p2.componentNumber == x)
            {
                ship.p2.isHit = true;
                ship.incrementHitCount();
                if (ship.isSunk())
                {
                    enemyPlayerScreen.decrementMyFloatingShips();
                    currentPlayerScreen.incrementNumOfEnemySunk();
                    updateSunkColor(ship);
                }
                attackGridShipPanel.isHit = true;
                attackGridShipPanel.setBackground(Color.red);
                break;
            }
            else if (ship.p3.componentNumber == x)
            {
                ship.p3.isHit = true;
                ship.incrementHitCount();
                if (ship.isSunk())
                {
                    enemyPlayerScreen.decrementMyFloatingShips();
                    currentPlayerScreen.incrementNumOfEnemySunk();
                    updateSunkColor(ship);
                }
                attackGridShipPanel.isHit = true;
                attackGridShipPanel.setBackground(Color.red);
                break;
            }
            else
            {
                attackGridShipPanel.isHit = false;
                attackGridShipPanel.setBackground(Color.blue);
            }
        }
    }
    
    public void updateSunkColor(Ship ship)
    {
        ship.p1.setBackground(Color.red);
        ship.p2.setBackground(Color.red);
        ship.p3.setBackground(Color.red);
    }
    
    void toggleState()
    {
        if (stateManager.isGameOver(p1.getNumOfEnemySunkShips(), p2.getNumOfEnemySunkShips()))
        {
            
            p1.showScreen();
            p2.showScreen();
        }
        else if (stateManager.inP1SetupState())
        {
            p1.hideScreen();
            stateManager.toggleState();
            p2.showScreen();
        }
        else if (stateManager.inP2SetupState())
        {
            p2.hideScreen();
            stateManager.toggleState();
            p1.showScreen();
        }
        else if (stateManager.inP1AttackState())
        {
            p1.hideScreen();
            stateManager.toggleState();
            p2.showScreen();
        }
        else if (stateManager.inP2AttackState())
        {
            p2.hideScreen();
            stateManager.toggleState();
            p1.showScreen();
        }
    }
    
    public boolean checkIfGameIsOver()
    {
        return stateManager.isGameOver;
    }
    
    public String determineWinner()
    {
        if(p1.getNumOfEnemySunkShips() == 5)
        {
            return "Player 1";
        }
        else
        {
            return "Player 2";
        }
    }
}
