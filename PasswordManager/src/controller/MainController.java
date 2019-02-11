package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	@FXML
	private TableView<String> passwordsTable;

	@FXML
	private TableColumn<String, String> colPassword;

	@FXML
	private TableColumn<String, String> colUsername;

	@FXML
	private TableColumn<String, String> colWebsite;

	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtWebsite;

	@FXML
	void generatePassword(ActionEvent event) {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
