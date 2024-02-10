package me.prouge.template.views;

import com.google.inject.Singleton;
import javafx.stage.Stage;
import me.prouge.guicefx.View;
import me.prouge.guicefx.annotations.FXView;

@Singleton
@FXView
public class AppView extends View {

    private boolean isOpen = false;
    private Stage stage;

    @Override
    public void close() {
        isOpen = false;
        stage.close();
    }

    @Override
    public void open() {
        if (isOpen) {
            return;
        }

        isOpen = true;

        stage = new Stage();
        stage.setTitle("TITLE");
        stage.setOnCloseRequest(e -> isOpen = false);
        stage.setWidth(500);
        stage.setHeight(500);
        show(stage);
    }
}
