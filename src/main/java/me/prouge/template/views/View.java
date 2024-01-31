package me.prouge.template.views;


import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.prouge.guicefx.GuiceFXMLoader;
import me.prouge.guicefx.annotations.FXView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.net.URL;

/**
 * Base class for JavaFX views.
 */
public abstract class View {

    private final String viewName;
    @Inject
    private Injector injector;

    private Node node;

    /**
     * Constructor for TESTView.
     * It initializes the view name based on the FXView annotation or a default naming convention.
     */
    public View() {
        FXView config = this.getClass().getAnnotation(FXView.class);
        if (config.value().isEmpty()) {
            this.viewName = mapToFXMLFileName();
        } else {
            this.viewName = config.value();
        }
    }

    /**
     * Gets the JavaFX Node associated with the view.
     * If the node is not yet created, it calls createNode() to create it.
     *
     * @return The JavaFX Node.
     */
    public Node getNode() {
        if (node == null) {
            node = createNode();
        }
        return node;
    }

    /**
     * Creates a JavaFX Node by loading the FXML file associated with the view.
     * It uses GuiceFXMLoader to load the FXML file with dependency injection.
     *
     * @return The created JavaFX Node.
     */
    private Node createNode() {
        GuiceFXMLoader guiceFXMLoader = new GuiceFXMLoader(injector);
        try {
            String file = "/" + readViewPathFromConfig() + "/" + viewName;
            URL resourceURL = getClass().getResource(file);
            return guiceFXMLoader.load(resourceURL);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load view: " + viewName, e);
        }
    }

    /**
     * Shows the view on a given Stage.
     * It creates the Node if it's not already created and sets it as the Scene of the Stage.
     *
     * @param stage The JavaFX Stage where the view should be shown.
     */
    public void show(final Stage stage) {
        if (node == null) {
            node = createNode();
        }
        stage.setScene(new Scene((Parent) node));
        stage.show();
    }

    /**
     * Derives the FXML file name from the class name.
     * It converts the class name to lowercase and removes "view" from the name if present, then adds ".fxml".
     *
     * @return The derived FXML file name.
     */
    private String mapToFXMLFileName() {
        return getClass().getSimpleName().toLowerCase().replace("view", "") + ".fxml";
    }

    /**
     * Reads the view path from a configuration file (guicefx.xml).
     * It extracts the view package from the configuration file and replaces "." with "/".
     *
     * @return The view path as a String.
     */
    private String readViewPathFromConfig() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(getClass().getClassLoader().getResourceAsStream("META-INF/guicefx.xml"));
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();

            return root.getElementsByTagName("viewPackage").item(0).getTextContent().replace(".", "/");
        } catch (Exception e) {
            throw new RuntimeException("Error reading configuration file: " + e.getMessage(), e);
        }
    }
}