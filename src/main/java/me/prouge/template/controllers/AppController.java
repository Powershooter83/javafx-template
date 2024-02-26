package me.prouge.template.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import me.prouge.template.entities.UserEntity;
import me.prouge.template.factories.UserCellFactory;
import me.prouge.template.utils.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    private ListView<UserEntity> userList;

    @FXML
    private TableView<UserEntity> tableView;

    @FXML
    private TableColumn<UserEntity, String> emailColumn;

    @FXML
    private TableColumn<UserEntity, String> passwordColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getLoginService().register("test", "test");

        Callback<ListView<UserEntity>, ListCell<UserEntity>> cellFactoryCallback = param -> new UserCellFactory();

        userList.setCellFactory(cellFactoryCallback);

        userList.getItems().addAll(Model.getInstance().getDatabaseManager()
                .executeQueryWithResultList("Select a from USER a", UserEntity.class, q -> {
                }));

        emailColumn.setCellValueFactory(
                cell -> new SimpleStringProperty(cell.getValue().getEmail())
        );
        passwordColumn.setCellValueFactory(
                cell -> new SimpleStringProperty(cell.getValue().getPassword())
        );

        loadUsers();
    }

    private void loadUsers() {
        final ObservableList<UserEntity> observableTournamentList = FXCollections.observableArrayList(
                Model.getInstance().getDatabaseManager()
                        .executeQueryWithResultList("Select a from USER a", UserEntity.class, q -> {
                        }));
        tableView.setItems(observableTournamentList);
    }
}
