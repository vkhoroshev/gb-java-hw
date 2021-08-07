package quarter01.level02.lesson04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
        stage.setTitle("lesson04");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
