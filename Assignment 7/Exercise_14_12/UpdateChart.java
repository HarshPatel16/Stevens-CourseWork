import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UpdateChart implements EventHandler<ActionEvent> {

    private Datapane dataPane;
    private BarChart chartPane;

    public UpdateChart(Datapane dataPane, BarChart chartPane) {
        this.dataPane = dataPane;
        this.chartPane = chartPane;
    }

    @Override
    public void handle(ActionEvent e) {
        if(dataPane.update() == true)
        {
            dataPane.removeError();
            chartPane.removeAll();
            chartPane.update(dataPane.getData());
        }
    }
}

