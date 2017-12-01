package application;

import java.util.ArrayList;

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
	
	private ArrayList<Earthquake> quakes = new ArrayList<>();
	
	@FXML
	public void initialize() {
		EarthquakeCollection ec = new EarthquakeCollection();
		ec.setData(ec.loadData("all_month.csv"));
		quakes = ec.createQuakes();
		ec.sortByDate(quakes);
		System.out.println(quakes.size());
		System.out.print("done");
	}
	
	
	public void displayDataButtonClick (ActionEvent e) {
	
		
		if ((SearchDate1.getValue() != null) && (SearchDate2.getValue() != null)) {
			ReportArea.setText(mainCollection.searchByDate(SearchDate1.getValue(), SearchDate2.getValue(), quakes));
		}
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
