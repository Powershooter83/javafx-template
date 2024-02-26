package me.prouge.template.controllers.cells;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import me.prouge.template.entities.UserEntity;

import java.net.URL;
import java.util.ResourceBundle;

public class UserCellController implements Initializable {

    final UserEntity user;

    @FXML
    private Label emailLabel;
    @FXML
    private Label passwordLabel;

    public UserCellController(final UserEntity user) {
        this.user = user;
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        emailLabel.setText(user.getEmail());
        passwordLabel.setText(user.getPassword());
    }
}
