package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;

import model.Patient;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private TableView<Patient> patientTable;

    @FXML
    private TableColumn<Patient, Integer> colId;

    @FXML
    private TableColumn<Patient, String> colName;

    @FXML
    private TableColumn<Patient, Integer> colAge;

    @FXML
    private TableColumn<Patient, String> colGender;

    ObservableList<Patient> patientList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        patientList.add(new Patient(1, "Ahmad", 22, "Male"));
        patientList.add(new Patient(2, "Siti", 20, "Female"));
        patientList.add(new Patient(3, "Budi", 25, "Male"));

        patientTable.setItems(patientList);
    }
}