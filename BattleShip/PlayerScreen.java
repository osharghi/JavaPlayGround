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


/**
 *
 * @author omidsharghi
 */
public class PlayerScreen extends JFrame {
    
    private ArrayList<Ship> ships;
    private StateManager stateManager;
    private PlayerData playerData;
    private GameController gameController;
    private JLabel stateMessageLabel;
    private JLabel stateInstructionsLabel;
    private JLabel stateTitleLabel;
    private JButton next;
    private JLabel numOfPlayerFloatingShipsLabel;
    private JLabel numOfPlayerSunkShipsLabel;
    private JLabel numOfEnemySunkShipsLabel;
    private JLabel resultsLabel;
    
    public PlayerScreen(String name, boolean show, StateManager stateManager) {
        super(name);
        this.playerData = new PlayerData();
        this.stateManager = stateManager;
        this.setUpWidgets(name, show);
        ships = new ArrayList<>();
        gameController = GameController.getInstance();
    }
    
    private void setUpWidgets(String name, boolean show)
    {
        //Create widgets
        next = new JButton("next");
        next.setEnabled(false);
        
        //Create header panel for user name and state title
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel playerTitle = new JLabel(name + "    ");
        stateTitleLabel = new JLabel("State: " + stateManager.getStateTitle());
        headerPanel.add(playerTitle);
        headerPanel.add(stateTitleLabel);
       
        //Create user data panel consisting of ship count
        JPanel userDataPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        numOfPlayerFloatingShipsLabel = new JLabel("My Ships Floating Count: " 
                + String.valueOf(playerData.numOfFloatingShips()) + "    ");
        numOfPlayerSunkShipsLabel = new JLabel("My Ships Sunk Count: " 
                + String.valueOf(playerData.numOfMySunkShips()) + "    ");
        numOfEnemySunkShipsLabel = new JLabel("Enemy Ships Sunk: " 
                + String.valueOf(playerData.numOfEnemySunk()) + "    ");
        userDataPanel.add(numOfPlayerFloatingShipsLabel);
        userDataPanel.add(numOfPlayerSunkShipsLabel);
        userDataPanel.add(numOfEnemySunkShipsLabel);
        
        //Create instruction panel for state instructions
        JPanel instructionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        stateInstructionsLabel = new JLabel("Instructions: " 
                + stateManager.getStateInstructions());
        instructionsPanel.add(stateInstructionsLabel);
        
        //Color legend
        JPanel colorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel colorLegendLabel = new JLabel("Red = Hit  Blue = Miss");
        colorPanel.add(colorLegendLabel);
        
        //Label for displaying results
        JPanel resultsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultsLabel = new JLabel("Winner: Game in progress");
        resultsPanel.add(resultsLabel);
        
        //Create error panel for state error messages
        JPanel errorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        stateMessageLabel = new JLabel("Error: ");
        errorPanel.add(stateMessageLabel);

        //Add userDataPanel, instructionspanel, and errorPanel into one border panel
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.add(userDataPanel);
        dataPanel.add(instructionsPanel);
        dataPanel.add(colorPanel);
        dataPanel.add(resultsPanel);
        dataPanel.add(errorPanel);
        
        //combine all panels into one BorderLayout 
        this.setLayout(new BorderLayout());
        this.add(new SelfGrid(name, this), BorderLayout.EAST);
        this.add(new AttackGrid(name, this), BorderLayout.WEST);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(next, BorderLayout.CENTER);
        this.add(dataPanel, BorderLayout.SOUTH);
        
        
        //Set up action listeners
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleState();
            }
        });
        
        this.pack();
        this.setVisible(show);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void updateStateTitle()
    {
        stateTitleLabel.setText("State: " + stateManager.getStateTitle());
    }
    
    public void updateStateInstructions()
    {
        stateInstructionsLabel.setText("Instructions: " 
                + stateManager.getStateInstructions());
    }
    
    public void updateNumOfPlayerFloatingShipsLabel()
    {
        numOfPlayerFloatingShipsLabel.setText("My Ships Floating Count: " 
                + String.valueOf(playerData.numOfFloatingShips()) + "    ");
    }
    
    public void updateNumOfPlayerSunkShipsLabel()
    {
        numOfPlayerSunkShipsLabel.setText("My Ships Sunk Count: " 
                + String.valueOf(playerData.numOfMySunkShips()) + "    ");
    }
    
    public void updateNumOfEnemySunkShipsLabel()
    {
        numOfEnemySunkShipsLabel.setText("Enemy Ships Sunk: " 
                + String.valueOf(playerData.numOfEnemySunk()) + "    ");
    }
    
    public void updateResultsLabel(String player)
    {
        resultsLabel.setText("Winner: " + player);
    }

    public void enableNextButton(boolean readyToEnable)
    {
        if (readyToEnable)
        {
            next.setEnabled(true);
        }
        else
        {
            next.setEnabled(false);
        }
    }
    
    public void hideScreen() {
        this.setVisible(false);
    }
    
    public void showScreen()
    {
        updateStateTitle();
        updateStateInstructions();
        enableNextButton(false);
        attackPlaced(false);
        
        if(gameController.checkIfGameIsOver())
        {
            updateResultsLabel(gameController.determineWinner());
        }
        
        this.setVisible(true);
    }
    
    private void toggleState()
    {
        gameController.toggleState();
    }
    
    public void attackPlaced(boolean attacked)
    {
        if (stateManager.inP1AttackState() || stateManager.inP2AttackState())
        {
            stateManager.attackPlaced(attacked);
        }
    }
    
    public boolean wasAttackPlaced()
    {
        if (stateManager.inP1AttackState() || stateManager.inP2AttackState())
        {
            return stateManager.wasAttackPlaced();
        }
        
        return false;
    }
    
    public int getNumOfEnemySunkShips()
    {
        return playerData.numOfEnemySunk();
    }
    
    public int getNumOfFloatingShips()
    {
        return playerData.numOfFloatingShips();
    }
    
    public void decrementMyFloatingShips()
    {
        playerData.decrementMyFloatingShips();
        updateNumOfPlayerFloatingShipsLabel();
        updateNumOfPlayerSunkShipsLabel();
    }
    
    public void incrementNumOfEnemySunk()
    {
        playerData.incrementNumOfEnemySunk();
        updateNumOfEnemySunkShipsLabel(); 
    }

    public ArrayList<Ship> getShips()
    {
        return ships;
    }
        
    public void checkAndAddShips(ShipPanel panel1, ShipPanel panel2, ShipPanel panel3)
    {
        if(stateManager.inP1SetupState() || stateManager.inP2SetupState())
        {
            if(getNumOfFloatingShips() < 5)
            {
                if(panel1.componentNumber % 10 > 7)
                {
                    stateMessageLabel.setText("Error: Select a unit that is "
                            + "at least 3 units away from the right wall");
                }
                else
                {
                    if(!doShipsIntersect(panel1, panel2, panel3))
                    {
                        addShip(panel1, panel2, panel3);
                        stateMessageLabel.setText("Error: ");
                        if (getNumOfFloatingShips() == 5)
                        {
                            enableNextButton(true);
                            stateInstructionsLabel.setText("Instructions: Ship limit has been reached. Press Next");
                        }
                    }
                    else
                    {
                        stateMessageLabel.setText("Error: Ship intersects with other ships");
                    }

                }
            }
        }
    }
        
    private boolean addShip(ShipPanel panel1, ShipPanel panel2, ShipPanel panel3)
    {
        if (doShipsIntersect(panel1, panel2, panel3) == false)
        {
            Ship ship = new Ship(panel1, panel2, panel3);
            panel1.setBackground(Color.green);
            panel2.setBackground(Color.green);
            panel3.setBackground(Color.green);
            ships.add(ship);
            playerData.incrementMyFloatingShips();
            updateNumOfPlayerFloatingShipsLabel();
            return true;
        }
        return false;
    }
    
    private boolean doShipsIntersect(ShipPanel panel1, ShipPanel panel2, ShipPanel panel3)
    {
        if (!ships.isEmpty())
        {
            for(int i = 0; i<ships.size(); i++)
            {
                Ship ship = ships.get(i);

                if(ship.p1 == panel1 || ship.p1 == panel2 || ship.p1 == panel3)
                {
                    return true;
                }
                else if(ship.p2 == panel1 || ship.p2 == panel2 || ship.p2 == panel3)
                {
                    return true;
                }
                else if(ship.p3 == panel1 || ship.p3 == panel2 || ship.p3 == panel3)
                {
                    return true;
                }
            }
        }
        return false;   
    }
    
    //Check to make sure user selected a valid panel before enabling the next button
    public void attackAttempted(ShipPanel p1)
    {
        if(!wasAttackPlaced() && stateManager.inP1AttackState())
        {
            if (p1.isHit == false)
            {
                checkHit(p1.componentNumber, p1);
                attackPlaced(true);
                enableNextButton(true);
            }
        }
        else  if(stateManager.inP2AttackState() && !wasAttackPlaced())
        {
            if (p1.isHit == false)
            {
                checkHit(p1.componentNumber, p1);
                attackPlaced(true);
                enableNextButton(true);
            }
        }
    }
    
    private void checkHit(int x, ShipPanel p)
    {
        if(stateManager.inP1AttackState() || stateManager.inP2AttackState())
        {
            gameController.checkAndUpdateHit(x, p);
        }      
    }
}


