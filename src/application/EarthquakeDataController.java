package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	
	private EarthquakeCollection ec;
	private Main main;
	
	private ArrayList<Earthquake> quakes = new ArrayList<>();
	private ArrayList<Earthquake> reportList = new ArrayList<>();
	
	//Getting the lists from EarthquakeCollection java page
	@FXML
	public void initialize() {
		ec = new EarthquakeCollection();
		ec.setData(ec.loadData("all_month.csv"));
		quakes = ec.createQuakes();
		ec.sortByDate(quakes);
	}
	
	
	public void displayDataButtonClick (ActionEvent e) {
		//Formating the date for searchByDate method
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
		
		//Each of these if statements consist of and if/else statement that checks if reportList is empty.
		//If it is, then the code will use quakes as the list for each searchBy method.
		//If it isn't empty, then the code will use reportList in replacement of quakes.
		//This list will go through the toString method in the EarthquakeCollection java page and will then appear in ReportArea.
		if ((!SearchDate1.getText().isEmpty()) && (!SearchDate2.getText().isEmpty())) {
			if (reportList.isEmpty()) {
				reportList.addAll(ec.searchByDate(d1, d2, quakes));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			else {
				reportList.addAll(ec.searchByDate(d1, d2, reportList));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			//ReportArea.setText(ec.searchByDate(d1, d2, quakes));
		}
		
		if ((!Lat1.getText().isEmpty()) && (!Lon1.getText().isEmpty()) && (!Lat2.getText().isEmpty()) && (!Lon2.getText().isEmpty())) {
			if (reportList.isEmpty()) {
				reportList.addAll(ec.searchByLocation(quakes, Double.parseDouble(Lat1.getText()), Double.parseDouble(Lat2.getText()), Double.parseDouble(Lon1.getText()), Double.parseDouble(Lon2.getText())));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			else {
				reportList.addAll(ec.searchByLocation(reportList, Double.parseDouble(Lat1.getText()), Double.parseDouble(Lat2.getText()), Double.parseDouble(Lon1.getText()), Double.parseDouble(Lon2.getText())));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			//ReportArea.setText(ec.searchByLocation(quakes, Double.parseDouble(Lat1.getText()), Double.parseDouble(Lat2.getText()), Double.parseDouble(Lon1.getText()), Double.parseDouble(Lon2.getText())));
		}
		
		if (!Depth1.getText().isEmpty() && !Depth2.getText().isEmpty()) {
			if (reportList.isEmpty()) {
				reportList.addAll(ec.searchByDepth(quakes, Double.parseDouble(Depth1.getText()), Double.parseDouble(Depth2.getText())));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			else {
				reportList.addAll(ec.searchByDepth(reportList, Double.parseDouble(Depth1.getText()), Double.parseDouble(Depth2.getText())));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			//ReportArea.setText(ec.searchByDepth(quakes, Double.parseDouble(Depth1.getText()), Double.parseDouble(Depth2.getText())));
		}
		
		if ((!Mag1.getText().isEmpty()) && (!Mag2.getText().isEmpty())) {
			if (reportList.isEmpty()) {
				reportList.addAll(ec.searchByMag(quakes, Double.parseDouble(Mag1.getText()), Double.parseDouble(Mag2.getText())));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			else {
				reportList.addAll(ec.searchByMag(reportList, Double.parseDouble(Mag1.getText()), Double.parseDouble(Mag2.getText())));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			//ReportArea.setText(ec.searchByMag(quakes, Double.parseDouble(Mag1.getText()), Double.parseDouble(Mag2.getText())));
		}
		
		if (!MagType.getText().isEmpty()) {
			if (reportList.isEmpty()) {
				reportList.addAll(ec.searchByMagType(quakes, MagType.getText()));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			else {
				reportList.addAll(ec.searchByMagType(reportList, MagType.getText()));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			//ReportArea.setText(ec.searchByMagType(quakes, MagType.getText()));
		}
		
		if (!Place.getText().isEmpty()) {
			if (reportList.isEmpty()) {
				reportList.addAll(ec.searchByPlace(quakes, Place.getText()));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			else {
				reportList.addAll(ec.searchByPlace(reportList, Place.getText()));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			//ReportArea.setText(ec.searchByPlace(quakes, Place.getText()));
		}
		
		if (!Status.getText().isEmpty()) {
			if (reportList.isEmpty()) {
				reportList.addAll(ec.searchByStatus(quakes, Status.getText()));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			else {
				reportList.addAll(ec.searchByStatus(reportList, Status.getText()));
				for (int i = 0; i < reportList.size(); i++) {
					ReportArea.setText(reportList.get(i).toString());
				}
			}
			//ReportArea.setText(ec.searchByStatus(quakes, Status.getText()));
		}
	}
	
	//This is to clear all text fields, the text area, and lists.
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
		reportList.clear();
	}
	
	
	
	
	//need figure out how to connect it with the select point in Map
	//before generate report need click display data button first
	public void SelEventButtonClick (ActionEvent e) {
		String filename =(SelEventReport.getText()+".txt");
		java.io.File file = new java.io.File(filename);
		Path filepath = Paths.get(filename);
		Charset encoding = Charset.forName("UTF-8");
		
		System.out.println(reportList.size());
		System.out.println("Text file in"+file.getAbsolutePath());
		if(file.exists()) {
			
			System.out.println("Text file already existed in "+file.getAbsolutePath());
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Warning.fxml"));
			AnchorPane dialogRoot;
			
			try {
				dialogRoot = (AnchorPane) loader.load();
				Scene dialogScene = new Scene(dialogRoot);
				Stage dialogStage = new Stage();
				dialogStage.setScene(dialogScene);
				dialogStage.show();
				
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
//			System.exit(1);
		}


	    try (java.io.PrintWriter output = new java.io.PrintWriter(filename);
	    		){
	    	//
	    	List<String> reportList = new ArrayList<String>(Arrays.asList(ReportArea.getText().split("ID")));
	    	for (int i = 0; i < reportList.size(); i++)
	    		output.print(Integer.toString(i)+": Earthquake happened on ID"+reportList.get(i)+"\t"+"\r\n");
	    	

//	    	output.print(ReportArea.getText());

	    } catch (IOException e1) {
	        e1.printStackTrace();

	    }

		
	}
	
	
	
	//create report has all point base on setting condition
	//direct get data from the report area, 
	//so before generate report need click display data button first
	public void AllEventButtonClick (ActionEvent e) {
		String filename =(AllEventReport.getText()+".txt");
		java.io.File file = new java.io.File(filename);
		Path filepath = Paths.get(filename);
		Charset encoding = Charset.forName("UTF-8");
//		System.out.println(filename);
		System.out.println("Text file in"+file.getAbsolutePath());
		if(file.exists()) {
			
			System.out.println("Text file already existed in "+file.getAbsolutePath());
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Warning.fxml"));
			AnchorPane dialogRoot;
			
			try {
				dialogRoot = (AnchorPane) loader.load();
				Scene dialogScene = new Scene(dialogRoot);
				Stage dialogStage = new Stage();
				dialogStage.setScene(dialogScene);
				dialogStage.show();
				
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}


	    try (java.io.PrintWriter output = new java.io.PrintWriter(filename);
	    		){
	    	List<String> reportList = new ArrayList<String>(Arrays.asList(ReportArea.getText().split("ID")));
	    	for (int i = 0; i < reportList.size(); i++)
	    		output.print(Integer.toString(i)+": Earthquake happened on ID"+reportList.get(i)+"\t"+"\r\n");

	    } catch (IOException e1) {
	        e1.printStackTrace();

	    }
//	    try(BufferedReader br = Files.newBufferedReader(filepath,encoding)){
//	    	String line;
//	    	while((line = br.readLine()) != null) {
//	            System.out.println(line);
//	        }
//	    }
//	    catch(IOException e1) {
//	    	e1.printStackTrace();
//	    }
		
	
		
	}
	
}
