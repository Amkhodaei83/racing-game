package com.example.gta_vi;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.util.List;

public class score_table {
    @FXML
    private Pane pane;
    @FXML
    private TableView<game> tableView;
    @FXML
    private TableColumn<game, String> timeColumn;
    @FXML
    private TableColumn<game, Integer> durationColumn;
    @FXML
    private TableColumn<game, Integer> scoreColumn;
    @FXML
    private TableColumn<game, String> gameConditionColumn;
    

    @FXML
    public void initialize() {

        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time_started"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        gameConditionColumn.setCellValueFactory(new PropertyValueFactory<>("gameCondition"));
        List<game> allGames = PlayerManager.getCorrentplayer().getAllgames();
        tableView.setItems(FXCollections.observableArrayList(allGames));

    }
}



