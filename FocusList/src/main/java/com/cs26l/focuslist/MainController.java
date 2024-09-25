package com.cs26l.focuslist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class MainController {
    @FXML
    private Button add_task_btn;

    @FXML
    private Button delete_task_btn;

    @FXML
    private GridPane tasks_pane;

    @FXML
    private Label task_title;

    @FXML
    private Label task_description;

    @FXML
    private Button task_false_btn;

    @FXML
    private Button task_true_btn;

    @FXML
    protected void add_task() {
        SceneManager sceneManager = new SceneManager();
        sceneManager.add_scene("add_task.fxml", "Add Task");

        Label new_task_title = new Label("Task Title");
        Label new_task_description = new Label("Task Description");
        Button new_task_false_btn = new Button("X");
        new_task_false_btn.setFont(Font.font("System"));
        Button new_task_true_btn = new Button("✔");

        RowConstraints rows = new RowConstraints();
        rows.setPrefHeight(50);

        tasks_pane.getRowConstraints().add(tasks_pane.getRowCount(), rows);
        tasks_pane.setPrefHeight(tasks_pane.getPrefHeight() + rows.getPrefHeight());

        tasks_pane.add(new_task_title, 0, tasks_pane.getRowCount() - 1);
        tasks_pane.add(new_task_description, 1, tasks_pane.getRowCount() - 1);
    }
}