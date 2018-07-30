/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litebrite;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Bounds;
import javafx.scene.control.ColorPicker;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.event.*;
import javafx.scene.control.Button;
import java.awt.Paint;
import java.awt.Component;



/**
 *
 * @author narayan
 */
 
public class LiteBrite extends Application {

    Color newColor;
    
    @Override
    public void start(final Stage stage) throws Exception {
    
        int rows = 50;
        int columns = 50;
        
        stage.setTitle("Enjoy your game");

        GridPane grid = new GridPane();
        grid.getStyleClass().add("game-grid");

        for(int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(10);
            grid.getColumnConstraints().add(column);
        }

        for(int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(10);
            grid.getRowConstraints().add(row);
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Pane pane = new Pane();
                pane.setOnMouseReleased(e -> {

                    int childCount = pane.getChildren().size();
                    if (childCount != 0)
                    {
                        pane.getChildren().remove(0);
                    }
                    else
                    {
                        int width = 9;
                        int height = 9;
                        pane.getChildren().add(Anims.getAtoms(newColor, width, height));
                    }
                });
                pane.getStyleClass().add("game-grid-cell");
                if (i == 0) {
                    pane.getStyleClass().add("first-column");
                }
                if (j == 0) {
                    pane.getStyleClass().add("first-row");
                }
                grid.add(pane, i, j);
            }
        }
        
        HBox box = new HBox(20);
        box.setPadding(new Insets(5, 5, 5, 5));

        
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(new EventHandler() {
            public void handle(Event t) {
               for (int i = 0; i<=grid.getChildren().size()-1; i++)
               {
                  Pane pane = (Pane) grid.getChildren().get(i);
                  int childCount = pane.getChildren().size();
                  if (childCount != 0)
                  {
                        pane.getChildren().remove(0);
                  }

               }      
            }
        });
                
        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLACK);
        newColor = Color.BLACK;
        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
            
               newColor = colorPicker.getValue();
               
            }
        });
 
        box.getChildren().addAll(colorPicker, resetButton);
        BorderPane masterPane = new BorderPane();
        masterPane.setTop(box); 
        masterPane.setLeft(grid); 

        Scene scene = new Scene(masterPane);
        scene.getStylesheets().add(LiteBrite.class.getResource("resources/game.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    

    public static class Anims {
    
        public static Node getAtoms(final Color color, int width, int height) {
        
            Rectangle r = new Rectangle(width, height);
            r.setFill(color);
            return r;
        }  
    }

    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }
    
}