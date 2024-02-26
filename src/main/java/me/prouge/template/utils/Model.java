package me.prouge.template.utils;

import javafx.fxml.FXMLLoader;
import lombok.Getter;
import me.prouge.guicefx.persistence.DatabaseManager;
import me.prouge.template.factories.ViewFactory;
import me.prouge.template.services.LoginService;

@Getter
public class Model {
    private static final String VIEW_PATH = "/me/prouge/template/views/";
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseManager databaseManager;
    private final LoginService loginService;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseManager = new DatabaseManager();
        this.loginService = new LoginService();
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public FXMLLoader getLoader(final String fxmlFile) {
        return new FXMLLoader(getClass().getResource(VIEW_PATH + fxmlFile + ".fxml"));
    }
}
