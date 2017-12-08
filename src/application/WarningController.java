package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class WarningController {
	@FXML
	private Label warning;
	
	public void SetWarning(String s) {
		warning.setText("Text file already existed, Please try another filename");
	}
}
