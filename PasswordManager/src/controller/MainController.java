package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.Password;
import password.PasswordGenerator;
import password.PasswordHandler;

public class MainController implements Initializable {
	@FXML
	private TableView<Password> passwordsTable;

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

	private PasswordHandler passwordHandler = new PasswordHandler();
	
	@FXML
	void generatePassword(ActionEvent event) {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.colPassword.setCellValueFactory("Password");
		
	}
}
