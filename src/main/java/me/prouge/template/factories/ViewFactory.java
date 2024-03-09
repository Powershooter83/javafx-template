package me.prouge.template.factories;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.Getter;
import me.prouge.template.controllers.AppController;
import me.prouge.template.utils.Model;

import java.io.IOException;

@Getter
public class ViewFactory {

    private AppController appController;

    public void showApp() {
        final FXMLLoader loader = Model.getLoader("app");
        Scene scene = null;

        try {
            appController = new AppController();
            loader.setController(appController);
            final Parent root = loader.load();
            scene = new Scene(root);
            addFocusLostHandler(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        showStage(scene, "Dashboard", 500, 500);
    }

    public void close(final Node node) {
        if (node != null) {
            final Stage stage = (Stage) node.getScene().getWindow();
            if (stage != null) {
                stage.close();
            }
        }
    }

    private void addFocusLostHandler(Parent root) {
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // Set focus to null to lose focus when clicked outside the panel
            root.requestFocus();
        });
    }

    private void showStage(final Scene scene, final String title, final int width, final int height) {
        final Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.show();
    }
}
