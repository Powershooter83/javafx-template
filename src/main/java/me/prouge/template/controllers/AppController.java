package me.prouge.template.controllers;

import com.google.inject.Inject;
import javafx.fxml.Initializable;
import me.prouge.guicefx.annotations.FXController;
import me.prouge.template.service.LoginService;

import java.net.URL;
import java.util.ResourceBundle;

@FXController
public class AppController implements Initializable {

    @Inject
    private LoginService loginService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginService.register("test", "test");
    }
}
