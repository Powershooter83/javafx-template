//package me.prouge.template.controllers;
//
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.ListCell;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.util.Callback;
//import me.prouge.template.entities.UserEntity;
//import me.prouge.template.utils.Model;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class ExampleController implements Initializable {
//
//    @FXML
//    private ListView<UserEntity> userList;
//
//    @FXML
//    private TableView<UserEntity> tableView;
//
//    @FXML
//    private TableColumn<UserEntity, String> emailColumn;
//
//    @FXML
//    private TableColumn<UserEntity, String> passwordColumn;
//
//
//    @Override
//    public void initialize(final URL url, final ResourceBundle resourceBundle) {
//        Callback<ListView<UserEntity>, ListCell<UserEntity>> cellFactoryCallback = param -> new UserCellFactory();
//
//        userList.setCellFactory(cellFactoryCallback);
//        userList.getItems().addAll(Model.getDBM().loadAll(UserEntity.class));
//        emailColumn.setCellValueFactory(
//                cell -> new SimpleStringProperty(cell.getValue().getEmail())
//        );
//        passwordColumn.setCellValueFactory(
//                cell -> new SimpleStringProperty(cell.getValue().getPassword())
//        );
//        loadUsers();
//    }
//
//    private void loadUsers() {
//        tableView.setItems(FXCollections.observableList(Model.getDBM().loadAll(UserEntity.class)));
//    }
//}
