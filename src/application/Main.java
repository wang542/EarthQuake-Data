package application;
	
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// set a title for the Window
			primaryStage.setTitle("Earthquake Data");
			
			// get an FXML loader and read in the fxml code
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/EarthquakeData.fxml"));
			AnchorPane mainLayout = (AnchorPane)loader.load();
			
			// Create the scene with the layout in the fxml code, set the scene and show it
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Work on tomorrow
	static ArrayList<Earthquake> quakes = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException
	{
		launch(args);
		//System.out.println(quakes.get(0).toString());
		//System.out.println(sorted.get(0).time);

		
		
		//RunCommandLine(quakes); // Executes command line interface
		RunUnitTest(quakes);
	}
	
	public static void RunUnitTest(ArrayList<Earthquake> testQuakes)
	{
		//EarthquakeCollection ec = new EarthquakeCollection();
		//System.out.println("-------------------SUMMARY TEST-------------------------");
		//System.out.println(ec.toString(testQuakes));
		//System.out.println("--------------------------------------------------------");
		//System.out.println("---------------------PRINT TEST-------------------------");
		//System.out.println(ec.printAll(testQuakes));
		//System.out.println("--------------------------------------------------------");
		//System.out.println("-----------------PRINTBY DATE TEST-----------------------");
		//System.out.println(ec.printAll(ec.sortByDate(testQuakes)));
		//System.out.println("--------------------------------------------------------");
		//System.out.println("-------------------PRINTBY DEPTH TEST-------------------------");
		//System.out.println(ec.printAll(ec.sortByDepth(testQuakes)));
		//System.out.println("--------------------------------------------------------");
		//System.out.println("-------------------PRINTBY MAG TEST-------------------------");
		//System.out.println(ec.printAll(ec.sortByMag(testQuakes)));
		//System.out.println("--------------------------------------------------------");
		//System.out.println("-------------------PRINTBY PLACE TEST-------------------------");
		//System.out.println(ec.printAll(ec.sortByPlace(testQuakes)));
		//System.out.println("--------------------------------------------------------");
		//System.out.println("-------------------PRINTBY STATUS TEST-------------------------");
		//System.out.println(ec.printAll(ec.sortByStatus(testQuakes)));
		//System.out.println("--------------------------------------------------------");
		//System.out.println("-------------------SEARCH DATE TEST-------------------------");
//		DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
//		Date result1;
//		Date result2;
//		try 
//		{
//		    result1 = df.parse("Thu Oct 19 13:06:29 EDT 2017");
//			result2 = df.parse("Thu Oct 19 13:08:29 EDT 2017");
//			ec.searchByDate(result1, result2, testQuakes);
//		} 
//		catch (ParseException e) 
//		{
//			System.out.println("Command Error: search date EEE MMM dd kk:mm:ss z yyyy\nExample: Thu Oct 19 13:07:29 EDT 2017");
//		}
//		System.out.println("--------------------------------------------------------");
	}
	
	public static void RunCommandLine(ArrayList<Earthquake> commandQuakes)
	{
		EarthquakeCollection ec = new EarthquakeCollection();
		System.out.println("Start using commands, use 'help' for a list of commands");
		
		Scanner input = new Scanner(System.in);
		String response = input.nextLine();

		while (!response.equalsIgnoreCase("stop"))
		{
			if (response.equalsIgnoreCase("help"))
			{
				System.out.println("List of Commands:");
				System.out.println("Use 'stop' to close the program");
				System.out.println("Use 'summary' for a summary of the collected data");
				System.out.println("Use 'print' for a printed list of the data for every recorded earthquake");
				System.out.println("Use 'printby date' to print a sorted list by date");
				System.out.println("Use 'printby depth' to print a sorted list by depth");
				System.out.println("Use 'printby mag' to print a sorted list by magnitude");
				System.out.println("Use 'printby place' to print a sorted list by place");
				System.out.println("Use 'printby status' to print a sorted list by status");
				System.out.println("Use 'seach date mm/dd/yyyy mm/dd/yyyy' to return earthquakes between the 2 dates");
				System.out.println("Use 'search depth #depth1 #depth2' to return earthquakes between the 2 depths");
				System.out.println("Use 'search location state' to return earthquakes in that state");
				System.out.println("Use 'search mag #magnitude #magnitude' to return earthquakes between the 2 magnitudes");
				System.out.println("Use 'search magType magnitudeType' to return earthquakes with the given magnitude type");
				System.out.println("Use 'search place place' to return earthquakes near the given place");
				System.out.println("Use 'search status status' to return earthquakes with the given status");
				//add all of the commands here
			}
			else if (response.equalsIgnoreCase("summary"))
			{
				System.out.println(ec.toString(commandQuakes));
			}
			else if (response.equalsIgnoreCase("print"))
			{
				System.out.println(ec.printAll(commandQuakes));
			}
			else if ((response.split(" ").length >= 2 && response.split(" ")[0].equalsIgnoreCase("printby")) || response.trim().equalsIgnoreCase("printby"))
			{
				if (response.split(" ").length >= 3)
				{
					System.out.println("Incorrect usage of 'printby'");
					System.out.println("Use 'printby date' to print a sorted list by date");
					System.out.println("Use 'printby depth' to print a sorted list by depth");
					System.out.println("Use 'printby mag' to print a sorted list by magnitude");
					System.out.println("Use 'printby place' to print a sorted list by place");
					System.out.println("Use 'printby status' to print a sorted list by status");
				}
				else if (response.split(" ").length == 2 && response.split(" ")[1].equalsIgnoreCase("date"))
				{
					System.out.println(ec.printAll(ec.sortByDate(commandQuakes)));
				}
				else if (response.split(" ").length == 2 && response.split(" ")[1].equalsIgnoreCase("depth"))
				{
					System.out.println(ec.printAll(ec.sortByDepth(commandQuakes)));
				}
				else if (response.split(" ").length == 2 && response.split(" ")[1].equalsIgnoreCase("mag"))
				{
					System.out.println(ec.printAll(ec.sortByMag(commandQuakes)));
				}
				else if (response.split(" ").length == 2 && response.split(" ")[1].equalsIgnoreCase("place"))
				{
					System.out.println(ec.printAll(ec.sortByPlace(commandQuakes)));
				}
				else if (response.split(" ").length == 2 && response.split(" ")[1].equalsIgnoreCase("status"))
				{
					System.out.println(ec.printAll(ec.sortByStatus(commandQuakes)));
				}
				else
				{
					System.out.println("Incorrect usage of 'printby'");
					System.out.println("Use 'printby date' to print a sorted list by date");
					System.out.println("Use 'printby depth' to print a sorted list by depth");
					System.out.println("Use 'printby mag' to print a sorted list by magnitude");
					System.out.println("Use 'printby place' to print a sorted list by place");
					System.out.println("Use 'printby status' to print a sorted list by status");
				}
			}
			else if ((response.split(" ").length >= 2 && response.split(" ")[0].equalsIgnoreCase("search")))
			{
				if (response.split(" ")[1].equalsIgnoreCase("date"))
				{
					if (response.split(" ").length != 14) //add in || to check if date formats are correct
					{
						System.out.println("Command Error: search date EEE MMM dd kk:mm:ss z yyyy\nExample: Thu Oct 19 13:07:29 EDT 2017");
					}
					else
					{
						DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
						Date result1;
						Date result2;
						try 
						{
						    result1 = df.parse(response.split(" ")[2]+" "+response.split(" ")[3]+" "+response.split(" ")[4]+" "+response.split(" ")[5]+" "+response.split(" ")[6]+" "+response.split(" ")[7]);
							result2 = df.parse(response.split(" ")[8]+" "+response.split(" ")[9]+" "+response.split(" ")[10]+" "+response.split(" ")[11]+" "+response.split(" ")[12]+" "+response.split(" ")[13]);
							ec.searchByDate(result1, result2, commandQuakes);
						} 
						catch (ParseException e) 
						{
							System.out.println("Command Error: search date EEE MMM dd kk:mm:ss z yyyy\nExample: Thu Oct 19 13:07:29 EDT 2017");
						}
						
					}
				}
				else if (response.split(" ")[1].equalsIgnoreCase("depth"))
				{
					if (response.split(" ").length != 4) //add in || to check if date formats are correct
					{
						System.out.println("Command Error: search depth #depth1 #depth2");
					}
					else
					{
						try
						{
						ec.searchbyDepth(commandQuakes,Double.parseDouble(response.split(" ")[2]), Double.parseDouble(response.split(" ")[3]));
						}
						catch (java.lang.NumberFormatException e) 
						{
							System.out.println("Command Error: search depth #depth1 #depth2");
						}
					}
				}
				else if (response.split(" ")[1].equalsIgnoreCase("location"))
				{
					if (response.split(" ").length != 6) //add in || to check if date formats are correct
					{
						System.out.println("Command Error: search location #latitude1 #latitude2 #longitude1 #longitude2");
					}
					else
					{
						try
						{
						ec.searchbyLocation(commandQuakes, Double.parseDouble(response.split(" ")[2]), Double.parseDouble(response.split(" ")[3]), Double.parseDouble(response.split(" ")[4]), Double.parseDouble(response.split(" ")[5]));
						}
						catch (java.lang.NumberFormatException e) 
						{
							System.out.println("Command Error: search location #latitude1 #latitude2 #longitude1 #longitude2");
						}
					}
				}
				else if (response.split(" ")[1].equalsIgnoreCase("mag"))
				{
					if (response.split(" ").length != 4) //add in || to check if date formats are correct
					{
						System.out.println("Command Error: search mag #magnitude #magnitude");
					}
					else
					{
						try
						{
						ec.searchbyMag(commandQuakes, Double.parseDouble(response.split(" ")[2]), Double.parseDouble(response.split(" ")[3]));
						}
						catch (java.lang.NumberFormatException e) 
						{
							System.out.println("Command Error: search mag #magnitude #magnitude");
						}					
					}
				}
				else if (response.split(" ")[1].equalsIgnoreCase("magType"))
				{
					if (response.split(" ").length != 3 || (!response.split(" ")[2].equals("ml")&&!response.split(" ")[2].equals("md")&&!response.split(" ")[2].equals("mb_lg")&&!response.split(" ")[2].equals("mww")&&!response.split(" ")[2].equals("mb")&&!response.split(" ")[2].equals("mw")&&!response.split(" ")[2].equals("mwr")&&!response.split(" ")[2].equals("mwb"))) //add in || to check if date formats are correct
					{
						System.out.println("Command Error: search magType magnitudeType\nAccepted magTypes: ml, md, mb_lg, mww, mb, mw, mwr, mwb");
					}
					else
					{
						
						ec.searchbyMagType(commandQuakes, response.split(" ")[2]);
					
					}
				}
				else if (response.split(" ")[1].equalsIgnoreCase("place"))
				{
					if (response.split(" ").length != 3) //add in || to check if date formats are correct
					{
						System.out.println("Command Error: search place 'place'");
					}
					else
					{
						ec.searchbyPlace(commandQuakes, response.split(" ")[2]);
					}
				}
				else if (response.split(" ")[1].equalsIgnoreCase("status") || (!response.split(" ")[2].equals("reviewed")&&!response.split(" ")[2].equals("automatic")))
				{
					if (response.split(" ").length != 3) //add in || to check if date formats are correct
					{
						System.out.println("Command Error: search status status\nAccepted status: reviewed, automatic");
					}
					else
					{
						ec.searchbyStatus(commandQuakes, response.split(" ")[2]);
					}
				}
				else
				{
					System.out.println("Incorrect usage of search");
					System.out.println("Use 'seach date mm/dd/yyyy mm/dd/yyyy' to return earthquakes between the 2 dates");
					System.out.println("Use 'search depth #depth1 #depth2' to return earthquakes between the 2 depths");
					System.out.println("Use 'search location state' to return earthquakes in that state");
					System.out.println("Use 'search mag #magnitude #magnitude' to return earthquakes between the 2 magnitudes");
					System.out.println("Use 'search magType magnitudeType' to return earthquakes with the given magnitude type");
					System.out.println("Use 'search place place' to return earthquakes near the given place");
					System.out.println("Use 'search status status' to return earthquakes with the given status");
				}
				
			}
			else if (response.trim().equalsIgnoreCase("search") && response.split(" ").length < 2)
			{
				System.out.println("Incorrect usage of search");
				System.out.println("Use 'seach date mm/dd/yyyy mm/dd/yyyy' to return earthquakes between the 2 dates");
				System.out.println("Use 'search depth #depth1 #depth2' to return earthquakes between the 2 depths");
				System.out.println("Use 'search location state' to return earthquakes in that state");
				System.out.println("Use 'search mag #magnitude #magnitude' to return earthquakes between the 2 magnitudes");
				System.out.println("Use 'search magType magnitudeType' to return earthquakes with the given magnitude type");
				System.out.println("Use 'search place place' to return earthquakes near the given place");
				System.out.println("Use 'search status status' to return earthquakes with the given status");

			}
			else
			{
				System.out.println("'" + response + "' is not an accepted command. Use 'help' for a list of valid commands.");
			}
			
			response = input.nextLine();
		}
		
		System.out.println("Exiting Program");
		//add command to close program

	}
}
