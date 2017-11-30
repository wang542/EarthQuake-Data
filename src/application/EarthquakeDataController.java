package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class EarthquakeDataController {
	
	@FXML
	private AnchorPane mainPane;
	@FXML
	private Button SelEventButton;
	@FXML
	private Button AllEventButton;
	@FXML
	private DatePicker SearchDate1;
	@FXML
	private DatePicker SearchDate2;
	@FXML
	private TextField Location;
	@FXML
	private TextField Depth;
	@FXML
	private TextField Mag1;
	@FXML
	private TextField Mag2;
	@FXML
	private TextField MagType;
	@FXML
	private TextField Place;
	@FXML
	private TextField Status;
	@FXML
	private TextField SelEventReport;
	@FXML
	private TextField AllEventReport;
	@FXML
	private TextArea ReportArea;
	@FXML
	private Button DisplayDataButton;
	
	private EarthquakeCollection mainCollection;
	private Main main;
	
	
	public void displayDataButtonClick (ActionEvent e) {
		main.quakes;
		
//		if ((SearchDate1.getValue() != null) && (SearchDate2.getValue() != null)) {
//			mainCollection.searchByDate(SearchDate1, SearchDate2);
//		}
		if (!Location.getText().isEmpty()) {
			
		}
		if (!Depth.getText().isEmpty()) {
			
		}
		if (!Mag1.getText().isEmpty()) {
			
		}
		if (!Mag2.getText().isEmpty()) {
			
		}
		if (!MagType.getText().isEmpty()) {
			
		}
		if (!Place.getText().isEmpty()) {
			
		}
		if (!Status.getText().isEmpty()) {
			
		}
	}
	
}
