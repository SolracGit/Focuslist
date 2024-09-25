package com.cs26l.focuslist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

class SceneManager {
    void add_scene(String fxml_name, String title) {
        try {
            Stage new_stage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource(fxml_name));
            Scene new_scene = new Scene(parent);

            new_stage.setScene(new_scene);
            new_stage.setTitle(title);
            new_stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void switch_scene(Node current_window, String fxml_name, String title) {
        try {
            Stage currentStage = (Stage) current_window.getScene().getWindow();
            currentStage.close();

            Stage new_stage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource(fxml_name));
            Scene new_scene = new Scene(parent);

            new_stage.setScene(new_scene);
            new_stage.setTitle(title);
            new_stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}