package application;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EarthquakeDataController {
	
	@FXML
	private TextField Date;
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
	private Button ReportOfSelected;
	@FXML
	private Button ReportOfAll;
	@FXML
	private void ReportOfSelectedClick(ActionEvent event)
	{
		System.out.println("Report Of Selected data");
		
		// get an FXML loader and read in the fxml code
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Repoter.fxml"));
		AnchorPane dialogRoot;
		
		try {
			dialogRoot = (AnchorPane) loader.load();
			Scene dialogScene = new Scene(dialogRoot);
			Stage dialogStage = new Stage();
			dialogStage.setScene(dialogScene);
			dialogStage.show();
			System.out.println("After dialogStage.show()");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
			
	}
	
}
public void SelEventButton (ActionEvent e) {
		PrintWriter fw = null;

	    try {
	        fw = new PrintWriter("selData.txt");
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(ReportArea.getText());
	        bw.newLine();
	        bw.write(ReportArea.getText());
	        fw.close();
	    } catch (IOException e1) {
	        e1.printStackTrace();

	    }
		
	}
	public void AllEventButton (ActionEvent e) {
		PrintWriter fw = null;

	    try {
	        fw = new PrintWriter("allData.txt");
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(ReportArea.getText());
	        bw.newLine();
	        bw.write(ReportArea.getText());
	        fw.close();
	    } catch (IOException e1) {
	        e1.printStackTrace();

	    }
		
	}
}
