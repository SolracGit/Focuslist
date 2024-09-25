package com.cs26l.focuslist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Login2Controller {
    TransitionManager transition = new TransitionManager();
    AnimationManager animation = new AnimationManager();

    @FXML
    private Pane current_pane;

    @FXML
    private Pane signin_pane;

    @FXML
    private Pane signup_pane;

    @FXML
    private Pane guest_pane;

    @FXML
    private Label focuslist_title;

    @FXML
    private Button signin_pane_btn;

    @FXML
    private Button signup_pane_btn;

    @FXML
    private Button guest_pane_btn;

    @FXML
    private void login() throws IOException {
        SceneManager sceneManager = new SceneManager();
        sceneManager.switch_scene(current_pane, "main.fxml", "Main");
    }

    @FXML
    private void signin_pane_btn_clicked() {
        transition.translate(signin_pane, 0, 0, signin_pane.getTranslateY(), 0, 500, "easeOut");
        signin_pane.setDisable(false);
        transition.translate(signup_pane, 0, 0, signup_pane.getTranslateY(), 500, 500, "easeOut");
        signup_pane.setDisable(true);
        transition.translate(guest_pane, 0, 0, guest_pane.getTranslateY(), 500, 500, "easeOut");
        guest_pane.setDisable(true);
    }

    @FXML
    private void signup_pane_btn_clicked() {
        transition.translate(signin_pane, 0, 0, signin_pane.getTranslateY(), 500, 500, "easeOut");
        signin_pane.setDisable(true);
        transition.translate(signup_pane, 0, 0, signup_pane.getTranslateY(), 0, 500, "easeOut");
        signup_pane.setDisable(false);
        transition.translate(guest_pane, 0, 0, guest_pane.getTranslateY(), 500, 500, "easeOut");
        guest_pane.setDisable(true);
    }
    @FXML
    private void guest_pane_btn_clicked() {
        transition.translate(signin_pane, 0, 0, signin_pane.getTranslateY(), 500, 500, "easeOut");
        signin_pane.setDisable(true);
        transition.translate(signup_pane, 0, 0, signup_pane.getTranslateY(), 500, 500, "easeOut");
        signup_pane.setDisable(true);
        transition.translate(guest_pane, 0, 0, guest_pane.getTranslateY(), 0, 500, "easeOut");
        guest_pane.setDisable(false);
    }

    public void initialize() {
        animation.floating(focuslist_title, 0, 0, 10, -10, 5000, "easeIn");
        transition.fade(signin_pane.getParent(), 0, 1, 3000);
        transition.translate(signin_pane.getParent(), 0, 0, 500, 0, 2000, "easeOut");
    }
}