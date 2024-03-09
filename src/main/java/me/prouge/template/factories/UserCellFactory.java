//package me.prouge.template.factories;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.control.ListCell;
//import me.prouge.template.controllers.UserCellController;
//import me.prouge.template.entities.UserEntity;
//import me.prouge.template.utils.Model;
//
//import java.io.IOException;
//
//public class UserCellFactory extends ListCell<UserEntity> {
//
//    @Override
//    public void updateItem(final UserEntity user, final boolean empty) {
//        super.updateItem(user, empty);
//
//        setText(null);
//        if (empty) {
//            setGraphic(null);
//        } else {
//            final FXMLLoader loader = Model.getLoader("UserCell");
//            final UserCellController matchCellController = new UserCellController(user);
//            loader.setController(matchCellController);
//            try {
//                setGraphic(loader.load());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//
//    }
//
//}
