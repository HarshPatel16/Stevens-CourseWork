import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 12
 * Write a program that uses a bar chart to display the
 * percentages of the overall grade represented by projects, quizzes, mid-term
 * exams, and the final exam, as shown in Figure 14.46b. Suppose projects take
 * 20% and are displayed in red, quizzes take 10% and are displayed in blue,
 * mid-term exams take 30% and are displayed in green, and the final exam takes
 * 40% and is displayed in orange. Use the Rectangle class to display the bars.
 * Interested readers may explore the JavaFX BarChart class for further study.
 *
 * @author Harsh Patel
 * @date 04/28/2022
 */

public class Exercise_14_12 extends Application {

    //DataPane collects the data from the user.
    private Datapane dataPane = new Datapane();

    //ChartPane displays collected data in chart form.
    private BarChart chartPane = new BarChart();

    @Override
    public void start(Stage initialStage) {

        GridPane mainPane = new GridPane();
        Button updateButton = new Button("Update");
        mainPane.add(updateButton, 0, 1);
        GridPane.setHalignment(updateButton, HPos.CENTER);

        updateButton.setOnAction(new UpdateChart(dataPane,chartPane));

        mainPane.add(dataPane,0,0);
        mainPane.add(chartPane, 1, 0);

        //Set up scene and stage with the main pane
        Scene scene = new Scene(mainPane);
        initialStage.setTitle("Bar chart");
        initialStage.setScene(scene);
        initialStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
