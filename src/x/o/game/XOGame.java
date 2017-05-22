/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.o.game;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author ahmedghaly
 */
public class XOGame extends Application {
    // glopal var
    int active = 1;
    // buttons
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    Button btn5 = new Button();
    Button btn6 = new Button();
    Button btn7 = new Button();
    Button btn8 = new Button();
    Button btn9 = new Button();

    @Override
    public void start(Stage primaryStage) {
        

        
        // action in buttons
        btn1.setOnAction(e-> {
            starts(1, btn1);
        });
        btn2.setOnAction(e-> {
            starts(2, btn2);
        });
        btn3.setOnAction(e-> {
            starts(3, btn3);
        });
        btn4.setOnAction(e-> {
            starts(4, btn4);
        });
        btn5.setOnAction(e-> {
            starts(5, btn5);
        });
        btn6.setOnAction(e-> {
            starts(6, btn6);
        });
        btn7.setOnAction(e-> {
            starts(7, btn7);
        });
        btn8.setOnAction(e-> {
            starts(8, btn8);
        });
        btn9.setOnAction(e-> {
            starts(9, btn9);
        });
        
        // gridpane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(20);
        grid.setVgap(20);
        
        // add children
        grid.add(btn1, 0, 0);
        grid.add(btn2, 1, 0);
        grid.add(btn3, 2, 0);
        grid.add(btn4, 0, 1);
        grid.add(btn5, 1, 1);
        grid.add(btn6, 2, 1);
        grid.add(btn7, 0, 2);
        grid.add(btn8, 1, 2);
        grid.add(btn9, 2, 2);
        
        // scene
        Scene scene = new Scene(grid, 400, 400);
        // to add css fils
        scene.getStylesheets().add(XOGame.class.getResource("st.css").toExternalForm());
        
        // stage
        primaryStage.setTitle("X O Game");  // title name
        primaryStage.setScene(scene);
        primaryStage.show();     // show stage
    
    
    }
    ArrayList<Integer> player1 = new ArrayList<>();
    ArrayList<Integer> player2 = new ArrayList<>();
    void starts(int id, Button btn){
       
        if(active == 1){
            btn.setText("X");
            active = 2;
            btn.setDisable(true);
            player1.add(id);
            autoPlayer();
        }
        else if(active == 2){
            btn.setText("O");
            active = 1;
            btn.setDisable(true);
            player2.add(id);
            
        }
        winner();
            
    }
    
   void winner(){
        
        int winner = -1;
        String msg = "";
        
        // player 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
           winner = 1;
           
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
           winner = 1;

        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
           winner = 1;

        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
           winner = 1;

        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
           winner = 1;

        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
           winner = 1;

        
        // player 2
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
           winner = 2;
           
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))
           winner = 2;

        if(player2.contains(7) && player2.contains(8) && player2.contains(9))
           winner = 2;

        if(player2.contains(1) && player2.contains(4) && player2.contains(7))
           winner = 2;

        if(player2.contains(2) && player2.contains(5) && player2.contains(8))
           winner = 2;

        if(player2.contains(3) && player2.contains(6) && player2.contains(9))
           winner = 2;
          
        if(winner != -1){
            
            if(winner == 1)
                msg = "Player 1 is Winner!!";
            if(winner == 2)
                msg = "Player 2 is Winner!!";
        
            // alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Player informatio");
            alert.setContentText(msg);
            alert.setHeaderText("Player Information");
            alert.show();
    
        }
        
    }
   
   void autoPlayer(){
      
       ArrayList<Integer> autoPlayer = new ArrayList<>();
       for (int i = 0; i < 10; i++) {
           
           if(!(player1.contains(i)) || player2.contains(i))
               
               autoPlayer.add(i);
       } 
           Random r = new Random();
           int randIndex = r.nextInt(autoPlayer.size() - 0) + 0;
           int cellid = autoPlayer.get(randIndex);
           
           Button selectedButton = btn1;
           switch(randIndex){
                case 1 : selectedButton = btn1;
                        break;
                case 2 : selectedButton = btn2;
                        break;
                case 3 : selectedButton = btn3;
                        break;
                case 9 : selectedButton = btn9;
                        break; 
                case 4 : selectedButton = btn4;
                        break;
                case 5 : selectedButton = btn5;
                        break;
                case 6 : selectedButton = btn6;
                        break;
                case 7 : selectedButton = btn7;
                        break;
                case 8 : selectedButton = btn8;
                        break;
                default:
                    selectedButton = btn1;
           }
       starts(randIndex, selectedButton);
       
   }
   public static void main(String[] args) {
        
        launch(args);
    }

}