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
class StateManager  
{
    static int counter = 0; 
    static private GameState currentState;
    static P1SetUpState p1SetUpState;
    static P2SetUpState p2SetUpState;
    static P1AttackState p1AttackState;
    static P2AttackState p2AttackState;
    static GameOverState gameOverState;
    boolean isGameOver;
    
    StateManager()
    {
        p1SetUpState  = new P1SetUpState();
        p2SetUpState  = new P2SetUpState();
        p1AttackState = new P1AttackState();
        p2AttackState = new P2AttackState();
        gameOverState = new GameOverState();
        currentState = p1SetUpState;
        isGameOver = false;
    }
    
    public String getStateTitle()
    {
        return currentState.getTitle();
    }
    
    public String getStateInstructions()
    {
        return currentState.getInstructions();
    }
    
    public void attackPlaced(boolean attacked)
    {
        if(inP1AttackState())
        {
            p1AttackState.attackPlaced = attacked;
        }
        else if(inP2AttackState())
        {
            p2AttackState.attackPlaced = attacked;
        }
    }
    
    public boolean wasAttackPlaced()
    {
        if(inP1AttackState())
        {
            return p1AttackState.attackPlaced;
        }
        else if(inP2AttackState())
        {
            return p2AttackState.attackPlaced;
        }
        
        return false;
    }
    
    public boolean inP1SetupState()
    {
        if (currentState instanceof P1SetUpState)
        {
            return true;
        }
        return false;
    }
    
    public boolean inP2SetupState()
    {
        if (currentState instanceof P2SetUpState)
        {
            return true;
        }
        return false;
    }
    
    public boolean inP1AttackState()
    {
        if (currentState instanceof P1AttackState)
        {
            return true;
        }
        return false;
    }
    
    public boolean inP2AttackState()
    {
        if (currentState instanceof P2AttackState)
        {
            return true;
        }
        return false;
    }
    
    public boolean isGameOver(int numOfShipsSunkByP1, int numOfShipsSunkByP2)
    {
        if(numOfShipsSunkByP1 == 5 || numOfShipsSunkByP2 == 5)
        {
            isGameOver = true;
            currentState = gameOverState;
            return true;
        }
        
        return false;
    }
    
    void toggleState()
    {
        if (currentState instanceof P1SetUpState)
        {
            currentState = p2SetUpState;
        }
        else if (currentState instanceof P2SetUpState)
        {
            currentState = p1AttackState;
        }
        else if (currentState instanceof P1AttackState)
        {
            currentState = p2AttackState;
        }
        else if (currentState instanceof P2AttackState)
        {
            currentState = p1AttackState;
        }
 
    }

}