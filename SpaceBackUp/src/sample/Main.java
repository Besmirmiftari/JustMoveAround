package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




public class Main extends Application {



    @Override
    public void start(Stage window) throws Exception{
        AnchorPane pane = new AnchorPane();
        pane.setStyle("-fx-background-color:  #303030");
        Canvas canvas = new Canvas(300,300);
        GraphicsContext g = canvas.getGraphicsContext2D();
        draw(g);
        canvas.setOnKeyPressed(event1 -> {
            System.out.println("Hello");
        });
        canvas.setLayoutX(10.0);canvas.setLayoutY(350.0);
        pane.getChildren().add(canvas);
        Scene sc = new Scene(pane,600,700);
        sc.setOnKeyPressed(event -> {
            String info = event.getCode().toString();
            System.out.println(canvas.getTranslateY());
            if(info=="D"||info=="RIGHT"){
                moveRight(canvas);
            }else if(info=="A"||info=="LEFT"){
                moveLeft(canvas);
            }else if(info=="W"||info=="UP"){
                moveUp(canvas);
            }else if(info=="S"||info=="DOWN"){
                moveDown(canvas);
            }

        });
        window.setScene(sc);
        window.setResizable(false);
        window.show();

    }
    public void moveRight(Canvas can){
        if(can.getTranslateX()<300.0) {
            can.setTranslateX(can.getTranslateX() + 10);
        }
    }
    public void moveLeft(Canvas can){
        if(can.getTranslateX()>-270.0) {
            can.setTranslateX(can.getTranslateX() - 10);
        }
    }
    public void moveUp(Canvas can){
        if(can.getTranslateY()>-610.0) {
            can.setTranslateY(can.getTranslateY() - 10);
        }
    }
    public void moveDown(Canvas can){
        if(can.getTranslateY()<50.0)
        can.setTranslateY(can.getTranslateY() + 10);
    }
    public void draw(GraphicsContext g){
        g.setFill(Color.AQUA);
        g.fillRoundRect(265, 270, 30, 30, 10, 10);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
