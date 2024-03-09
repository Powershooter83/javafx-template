package me.prouge.template;

import javafx.application.Application;
import javafx.stage.Stage;
import me.prouge.template.utils.Model;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        Model.getVF().showApp();
    }

}