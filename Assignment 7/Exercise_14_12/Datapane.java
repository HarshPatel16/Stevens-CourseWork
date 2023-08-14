import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Datapane extends GridPane {
    private double [] data = {0, 0, 0, 0};

    private TextField projectInput = new TextField();
    private TextField quizInput = new TextField();
    private TextField midtermInput = new TextField();
    private TextField finalInput = new TextField();

    private Text errorMessage = new Text();

    public Datapane() {

        setAlignment(Pos.CENTER);
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        setHgap(7.5);
        setVgap(7.5);

        errorMessage.setStyle("-fx-stroke: red; -fx-fill: red;");

        add(new Label("Projects:"), 0, 0);
        add(projectInput, 1, 0);
        add(new Label("Quizzes:"), 0, 1);
        add(quizInput, 1, 1);
        add(new Label("Midterm:"), 0, 2);
        add(midtermInput, 1, 2);
        add(new Label("Final:"), 0, 3);
        add(finalInput, 1, 3);
        add(errorMessage, 0, 4);
    }

    public double [] getData() {
        return data;
    }

    public void removeError() {
        errorMessage.setText("");
    }

    public boolean update() {

        String projectData = projectInput.getText();
        projectInput.setText("");
        String quizData = quizInput.getText();
        quizInput.setText("");
        String midtermData = midtermInput.getText();
        midtermInput.setText("");
        String finalData = finalInput.getText();
        finalInput.setText("");

        //Convert to double
        double projectValue = Double.parseDouble(projectData);
        double quizValue = Double.parseDouble(quizData);
        double midtermValue = Double.parseDouble(midtermData);
        double finalValue = Double.parseDouble(finalData);

        //Check if value is not less than zero
        // Total should not exceed 100%
        if(projectValue < 0.0) {
            errorMessage.setText("ERROR: Project Input was less then 0.");
            return false;
        }
        if(quizValue < 0.0) {
            errorMessage.setText("ERROR: Quiz Input was less then 0.");
            return false;
        }
        if(midtermValue < 0.0) {
            errorMessage.setText("ERROR: Midterm Input was less then 0.");
            return false;
        }
        if(finalValue < 0.0) {
            errorMessage.setText("ERROR: Final Input was less then 0.");
            return false;
        }
        if(projectValue + quizValue + midtermValue + finalValue != 100)
        {
            errorMessage.setText("ERROR: All inputs must add up to 100");
            return false;
        }

        data[0] = projectValue;
        data[1] = quizValue;
        data[2] = midtermValue;
        data[3] = finalValue;
        return true;
    }
}
