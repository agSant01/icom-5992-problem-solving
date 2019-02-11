package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

		PasswordGenerator generator = new PasswordGenerator(
				this.txtUsername.getText(), this.txtWebsite.getText());

		Password password = new Password(generator.generatePassword(), 
				this.txtUsername.getText(), this.txtWebsite.getText());

		this.passwordHandler.savePassword(password);
		
		ArrayList<Password> passwords = passwordHandler.getPasswords();

		this.passwordsTable.setItems(FXCollections.observableArrayList(passwords));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
		this.colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
		this.colWebsite.setCellValueFactory(new PropertyValueFactory<>("website"));

		ArrayList<Password> passwords = passwordHandler.getPasswords();

		this.passwordsTable.setItems(FXCollections.observableArrayList(passwords));
	}
}
