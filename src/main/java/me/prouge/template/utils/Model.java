package me.prouge.template.utils;

import javafx.fxml.FXMLLoader;
import lombok.Getter;
import me.prouge.guicefx.persistence.DatabaseManager;
import me.prouge.template.factories.ViewFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
public class Model {
    private static final String VIEW_PATH = "/me/prouge/template/views/";

    private static Model model;

    private final ViewFactory viewFactory;

    private final DatabaseManager databaseManager;

    private static final Logger logger = LogManager.getLogger();

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseManager = new DatabaseManager();
    }

    private static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public static synchronized DatabaseManager getDBM() {
        return getInstance().getDatabaseManager();
    }

    public static synchronized ViewFactory getVF() {
        return getInstance().getViewFactory();
    }

    public static synchronized FXMLLoader getLoader(final String fxmlFile) {
        return getInstance().load(fxmlFile);
    }

    public static synchronized void log(final String log) {
        getInstance().logError(log);
    }

    private FXMLLoader load(final String fxmlFile) {
        return new FXMLLoader(getClass().getResource(VIEW_PATH + fxmlFile + ".fxml"));
    }

    private void logError(final String log) {
        logger.error(log);
    }

}
