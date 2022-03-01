package com.example.workshojavafxjdbc;

import com.example.workshojavafxjdbc.services.DepartmentService;
import com.example.workshojavafxjdbc.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartement;

    @FXML
    private MenuItem menuItemAbout;

    public MainViewController() {
    }

    @FXML
    public void onMenuItemSellerAction(){
        System.out.println("onMenuItemSellerAction");
    }

    @FXML
    public void onMenuItemDepartmentAction(){
        loadView2("DepartmentList.fxml");
    }

    @FXML
    public void onMenuItemAboutAction(){
        loadView("About.fxml");
    }

    @Override
    public void initialize(URL uri, ResourceBundle rb) {

    }

    private void loadView(String absoluteName){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0); //primeiro filho do VBox da tela principal
            mainVBox.getChildren().clear(); // Limpar todos os filhos do mainVBox
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

        } catch (IOException e) {
           Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void loadView2(String absoluteName){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0); //primeiro filho do VBox da tela principal
            mainVBox.getChildren().clear(); // Limpar todos os filhos do mainVBox
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

            DepartmentListController controller = loader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
