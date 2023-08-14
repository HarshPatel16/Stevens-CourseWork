import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * Chapter 14 Exercise 01
 * Write a program that displays four images in a grid pane, as 
 * shown in Figure
 *
 * @author Harsh Patel
 * @date 04/28/2022
 */

public class Exercise_14_01 extends Application{
	
	public void start(Stage primaryStage) throws FileNotFoundException {


        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);


        Image usFlag = new Image(new FileInputStream("Exercise_14_01/us.svg.png"));
        Image germanyFlag = new Image(new FileInputStream("Exercise_14_01/Germany.svg.png"));
        Image franceFlag = new Image(new FileInputStream("Exercise_14_01/France.svg.png"));
        Image chinaFlag = new Image(new FileInputStream("Exercise_14_01/china.svg.png"));


        ImageView usa = new ImageView(usFlag);
        ImageView germany = new ImageView(germanyFlag);
        ImageView france = new ImageView(franceFlag);
        ImageView china = new ImageView(chinaFlag);


        pane.add(germany, 0, 0);
        pane.add(france, 0, 1);
        pane.add(china, 1, 0);
        pane.add(usa, 1, 1);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Four Flag Images");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
