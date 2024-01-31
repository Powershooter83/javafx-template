package me.prouge.template;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.stage.Stage;
import me.prouge.template.utils.BasicModule;
import me.prouge.template.views.AppView;


public class App extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        final Injector injector = Guice.createInjector(new BasicModule());

        final AppView appView = injector.getInstance(AppView.class);
        appView.show(stage);
    }

}