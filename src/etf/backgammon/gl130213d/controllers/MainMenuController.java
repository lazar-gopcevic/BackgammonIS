/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etf.backgammon.gl130213d.controllers;

import etf.backgammon.gl130213d.wrappers.SceneWrapper;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

/**
 *
 * @author lazar
 */
public class MainMenuController implements Initializable {
    
    @FXML
    private CheckBox enemyCheckbox;
    @FXML
    private ChoiceBox matchPointsChoiceBox;
    @FXML
    private CheckBox colorCheckbox;
    @FXML
    private Slider treeDepthSlider;
    @FXML
    private Button startButton;
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        matchPointsChoiceBox.getItems().removeAll(matchPointsChoiceBox.getItems());
        matchPointsChoiceBox.getItems().addAll("1", "3", "5", "7", "11", "15");
        matchPointsChoiceBox.getSelectionModel().select("1");
    }

    @FXML
    private void handleStartButtonAction(ActionEvent event) {
        boolean isEnemyComputer = enemyCheckbox.isSelected();
        String matchPoints = (String) matchPointsChoiceBox.getValue();
        boolean isColorRed = colorCheckbox.isSelected();
        int treeDepth = (int) treeDepthSlider.getValue();
        
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/etf/backgammon/gl130213d/fx/Game.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (root != null) {
            Scene scene = new SceneWrapper(root, isEnemyComputer, matchPoints, isColorRed, treeDepth);
            stage.setScene(scene);
            stage.show();
        }
    }

}
