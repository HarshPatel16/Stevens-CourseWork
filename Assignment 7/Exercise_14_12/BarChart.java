import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class BarChart  extends Pane {

        Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};
        String [] dataName = {"Projects", "Quizzes", "MidtermExams", "FinalExam"};
        double [] data = {20, 10, 30, 40};
        double width = 400;
        double height = 400;

        public BarChart() { render(); }


        public void update(double [] newData) {
            for(int i = 0; i < data.length; i++)
                data[i] = newData[i];
            render();
        }


        public void removeAll() {
            getChildren().remove(0,data.length*3+1);
        }

        //Creates Bar Chart
        public void render()
        {

            double max = data[0];
            for (int i=1; i<data.length; i++)
                max = Math.max(max, data[i]);

            double barWidth = (width - 10.0) / data.length - 10;
            double maxBarHeight = height - 30;

            getChildren().add(new Line(5, height - 10, width - 5, height - 10));

            int x = 15;
            for (int i = 0; i < data.length; i++) {
                double newHeight = maxBarHeight * data[i] / max;
                double y = height - 10 - newHeight;
                Rectangle rectangle = new Rectangle(x, y, barWidth, newHeight);
                rectangle.setFill(colors[i % colors.length]);

                getChildren().add(rectangle);
                getChildren().add(new Text(x, y - 7, dataName[i]));
                getChildren().add(new Text(x+3, height-newHeight+10, (data[i]+"%")));
                x += barWidth + 10;
            }
        }
    }

