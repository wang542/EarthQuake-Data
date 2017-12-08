package application;

import java.text.*;
import java.util.ArrayList;
import java.util.Date;

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
	private TextField SearchDate1;
	@FXML
	private TextField SearchDate2;
	@FXML
	private TextField Lat1;
	@FXML
	private TextField Lat2;
	@FXML
	private TextField Lon1;
	@FXML
	private TextField Lon2;
	@FXML
	private TextField Depth1;
	@FXML
	private TextField Depth2;
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
	
	private GoogleMaps maps;
	private EarthquakeCollection ec;
	private Main main;
	
	
	private ArrayList<Earthquake> quakes = new ArrayList<>();
	private ArrayList<String> reportList = new ArrayList<>();
	
	@FXML
	public void initialize() {
		
		ec = new EarthquakeCollection();
		ec.setData(ec.loadData("all_month.csv"));
		quakes = ec.createQuakes();
		ec.sortByDate(quakes);
	}
	
	
	public void displayDataButtonClick (ActionEvent e) {
		//maps.setMarkerPosition(40.7128, -87.6298);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d1 = null;
		Date d2 = null;
		
		try {
			d1 = df.parse(SearchDate1.getText());
			d2 = df.parse(SearchDate2.getText());
		}
		catch (Exception eX) {
			System.out.println("Date is wrong");
		}
		
		
		if ((!SearchDate1.getText().isEmpty()) && (!SearchDate2.getText().isEmpty())) {
//			if (reportList.isEmpty()) {
//				reportList.add(ec.searchByDate(d1, d2, quakes));
//				for (int i = 0; i < reportList.size(); i++) {
//					ReportArea.setText(reportList.get(i));
//				}
//			}
//			else {
//				
//			}
			ReportArea.setText(ec.searchByDate(d1, d2, quakes));
		}
		if ((!Lat1.getText().isEmpty()) && (!Lon1.getText().isEmpty()) && (!Lat2.getText().isEmpty()) && (!Lon2.getText().isEmpty())) {
			ReportArea.setText(ec.searchByLocation(quakes, Double.parseDouble(Lat1.getText()), Double.parseDouble(Lat2.getText()), Double.parseDouble(Lon1.getText()), Double.parseDouble(Lon2.getText())));
		}
		if (!Depth1.getText().isEmpty() && !Depth2.getText().isEmpty()) {
			ReportArea.setText(ec.searchByDepth(quakes, Double.parseDouble(Depth1.getText()), Double.parseDouble(Depth2.getText())));
		}
		if ((!Mag1.getText().isEmpty()) && (!Mag2.getText().isEmpty())) {
			ReportArea.setText(ec.searchByMag(quakes, Double.parseDouble(Mag1.getText()), Double.parseDouble(Mag2.getText())));
		}
		if (!MagType.getText().isEmpty()) {
			ReportArea.setText(ec.searchByMagType(quakes, MagType.getText()));
		}
		if (!Place.getText().isEmpty()) {
			ReportArea.setText(ec.searchByPlace(quakes, Place.getText()));
		}
		if (!Status.getText().isEmpty()) {
			ReportArea.setText(ec.searchByStatus(quakes, Status.getText()));
		}
	}
	
	
	public void clearButtonClick (ActionEvent e) {
		SearchDate1.setText("");
		SearchDate2.setText("");
		Lat1.setText("");
		Lat2.setText("");
		Lon1.setText("");
		Lon2.setText("");
		Depth1.setText("");
		Depth2.setText("");
		Mag1.setText("");
		Mag2.setText("");
		MagType.setText("");
		Place.setText("");
		Status.setText("");
		ReportArea.setText("");
		quakes.clear();
	}
	
}
