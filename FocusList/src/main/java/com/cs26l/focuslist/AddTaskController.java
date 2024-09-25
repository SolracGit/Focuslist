package com.cs26l.focuslist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTaskController {
    @FXML
    private TextField task_title_field;

    @FXML
    private TextField task_description_field;

    @FXML
    private Button add_task_btn;

    String[] get_task() {
        String title = task_title_field.getText();
        String description = task_description_field.getText();
        return new String[] {title, description};
    }

    protected void add_task() {
        String[] task = get_task();
        System.out.println(task[0] + task[1]);
    }

    public void initialize() {

    }
}