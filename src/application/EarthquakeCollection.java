package application;

import java.util.*;
import java.lang.*;
import java.util.Date;
import java.io.*;



public class EarthquakeCollection  {
	
	
	ArrayList<ArrayList<String>> data;
	
	public EarthquakeCollection() {}
	
	// constructor
	public EarthquakeCollection(ArrayList<ArrayList<String>> data) {
		this.data = data;
	}
	
	// Data getter
	public ArrayList<ArrayList<String>> getData() {
		return data;
	}

	// Date setter
	public void setData(ArrayList<ArrayList<String>> data) {
		this.data = data;
	}

	// Loads Data
	public ArrayList<ArrayList<String>> loadData(String file) {

		ArrayList<ArrayList<String>> eqArray = new ArrayList<ArrayList<String>>();
		try 
		{
            //FileReader readFile = new FileReader("all_month.csv");
			FileReader readFile = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(readFile);
            
            String line;
    			String newLine ="";
    			String temporary="";

            while ((line = bufferedReader.readLine()) != null) 
            {
        		ArrayList<String> eq = new ArrayList<String>();
        	
        		if (line.indexOf('"') != -1)
        		{
        		String firstHalf;
        		String secondHalf;
        		int index1;
        		int index2;
        		
        		index1 = line.indexOf('"') + 1;
        		firstHalf = line.substring(0, index1-2);
        		index2 = line.substring(index1, line.length()).indexOf('"') + 1;
        		secondHalf = line.substring(index1 + index2, line.length());
        		temporary = line.substring(index1, (index1 + index2)-1);
        		newLine = firstHalf + secondHalf;
        		
        		}
        		
        		
            	for (String attribute : newLine.split(","))
            	{
            		eq.add(attribute);
            	}

            	eq.add(temporary);
            	eqArray.add(eq);

            }
            
            readFile.close(); 		
        } 
		
		catch (IOException e) 
		{
            e.printStackTrace();
        }
		return eqArray;
	}
	
	// Creates ArrayList of Earthquakes
	public ArrayList<Earthquake> createQuakes() {
		ArrayList<Earthquake> quakes = new ArrayList<Earthquake>();
		this.data.remove(this.data.get(0));
		int index = 0;
		for (ArrayList<String> arr : this.data) {
			quakes.add(new Earthquake().createAndPopulateQuake(arr));
			index++;
		}
		
		
		
		return quakes;
	}
	
	// Sorts Earthquakes by Date
	public ArrayList<Earthquake> sortByDate(ArrayList<Earthquake> quakes) {
		 ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		 result.add(quakes.get(0));
		 int index = 0;
		 for (int i = 0; i != quakes.size(); ++i) {
			 for (int j = 0; j != i; ++j) {
				 if (quakes.get(i).time.compareTo(result.get(j).time) < 0) {
					 result.add(j, quakes.get(i));
					 break;
				 } else if (j == i-1) {
					 result.add(quakes.get(i));
				 }
			 } 
		}
		return result;
	}

	// Sorts Earthquakes by Depth
	public ArrayList<Earthquake> sortByDepth(ArrayList<Earthquake> quakes) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		 result.add(quakes.get(0));
		 int index = 0;
		 for (int i = 0; i != quakes.size(); ++i) {
			 for (int j = 0; j != i; ++j) {
				 if (quakes.get(i).depth < result.get(j).depth) {
					 result.add(j, quakes.get(i));
					 break;
				 } else if (j == i-1) {
					 result.add(quakes.get(i));
				 }
			 } 
		}
		return result;
	}

	// Sorts Earthquakes by Magnitude
	public ArrayList<Earthquake> sortByMag(ArrayList<Earthquake> quakes) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		 result.add(quakes.get(0));
		 int index = 0;
		 for (int i = 0; i != quakes.size(); ++i) {
			 for (int j = 0; j != i; ++j) {
				 if (quakes.get(i).mag < result.get(j).mag) {
					 result.add(j, quakes.get(i));
					 break;
				 } else if (j == i-1) {
					 result.add(quakes.get(i));
				 }
				
			 } 
		}
		
		return result;
		
	}
	
	// Sorts Earthquakes by place (City, State)
	public ArrayList<Earthquake> sortByPlace(ArrayList<Earthquake> quakes) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		 result.add(quakes.get(0));
		 
		 for (int i = 0; i != quakes.size(); ++i) {
			String[] strarr1 = quakes.get(i).place.split(" ");
			String state1 = strarr1[strarr1.length-1];
			 for (int j = 0; j != i; ++j) {
				 String[] strarr2 = result.get(j).place.split(" ");
					String state2 = strarr2[strarr2.length-1];
				 if (state1.compareTo(state2) < 0) {
					 result.add(j, quakes.get(i));
					 break;
				 } else if (j == i-1) {
					 result.add(quakes.get(i));
				 }
				
			 } 
		}
		
		return result;
		
	}
	
	// Not implemented yet -- Sorts Earthquakes by Status
	public ArrayList<Earthquake> sortByStatus(ArrayList<Earthquake> quakes) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		 result.add(quakes.get(0));
		 for (int i = 0; i != quakes.size(); ++i) {
			 for (int j = 0; j != i; ++j) {
				 if (quakes.get(i).status == "automatic") {
					 result.add(j, quakes.get(i));
					 break;
				 } else if (quakes.get(i).status == "reviewed") {
					 result.add(quakes.get(i));
			 	} else if (j == i-1) {
					 result.add(quakes.get(i));
				 }
				
			 } 
		}
		
		return result;
		
	}
	
	// 
	public String printAll(ArrayList<Earthquake> ec) {
		StringBuilder result = new StringBuilder();
		result.append("All Earthquakes: \n");
		for (Earthquake e : ec) {
			result.append(e.toString());
			result.append("\n-------------------------------\n\n");
		}
		result.append("\nEarthquakes printed: " + ec.size());
		return result.toString();
	}
	
	
	// Need to add more information -- Summary of all earthquakes
	public String toString(ArrayList<Earthquake> ec) {
		ArrayList<Earthquake> quakes = this.sortByDate(ec);
		int size = quakes.size();
		StringBuilder result = new StringBuilder();
		result.append("There were " + quakes.size() + " earthquakes from " + quakes.get(0).time + " to " + quakes.get(size-1).time + ".");
		quakes = this.sortByMag(ec);
		double magTotal = 0;
		for (int i = 0; i < quakes.size(); i++)
			magTotal = magTotal + quakes.get(i).mag;
		result.append("\nThese earthquakes had a range of magnitudes from " + quakes.get(0).mag + " to " + quakes.get(size-1).mag + ", with the average magniutde being " + magTotal/quakes.size() + ".");
		quakes = this.sortByDepth(ec);
		double depthTotal = 0;
		for (int i = 0; i < quakes.size(); i++)
			depthTotal = depthTotal + quakes.get(i).depth;
		result.append("\nThese earthquakes had a range of depths from " + quakes.get(0).depth + " to " + quakes.get(size-1).depth + ", with the average depth being " + depthTotal/quakes.size() + ".");

		
		return result.toString();
	}

	// searchBy date
	public String searchByDate(Date d1, Date d2, ArrayList<Earthquake> ec) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		ArrayList<Earthquake> quakes = this.sortByDate(ec);
		Date begin = quakes.get(0).time;
		Date end = quakes.get(quakes.size()-1).time;
		if (d1.compareTo(begin) < 0) {
			System.out.println("The first Date inputted is before the beginning of data.");
		} else if (d2.compareTo(begin) < 0) {
			System.out.println("The second Date inputted is before the beginning of data.");
		} else {
			for (Earthquake e : quakes) {
				if (e.time.compareTo(d1) >= 0 && e.time.compareTo(d2) <= 0) {
					result.add(e);
				}
			}
		}
		return result.toString();
	}
	
	// searchBy location (lat,long)
	public ArrayList<Earthquake> searchByLocation(double lat, double lng, ArrayList<Earthquake> ec) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		for (Earthquake e : ec) {
			
		}
		
		return result;
	}
	
	// searchBy depth
	public String searchByDepth(ArrayList<Earthquake> depthQuakes, double depth1, double depth2)
	{
		ArrayList<Integer> indexArray = new ArrayList<Integer>();
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		for (int i = 0; i < depthQuakes.size(); i++)
		{
			if (depthQuakes.get(i).depth >= depth1 && depthQuakes.get(i).depth <= depth2)
				indexArray.add(i);
		}
		
		for (int i = 0; i < indexArray.size(); i++)
			 result.add(depthQuakes.get(indexArray.get(i)));
		return result.toString();
	}
	
	// searchBy mag
	public String searchByMag(ArrayList<Earthquake> magQuakes, double mag1, double mag2)
	{
		ArrayList<Integer> indexArray = new ArrayList<Integer>();
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		for (int i = 0; i < magQuakes.size(); i++)
		{
			if (magQuakes.get(i).mag >= mag1 && magQuakes.get(i).mag <= mag2)
				indexArray.add(i);
		}
		
		for (int i = 0; i < indexArray.size(); i++)
			result.add(magQuakes.get(indexArray.get(i)));
		return result.toString();
	}
	
	// searchBy magtype
	public String searchByMagType(ArrayList<Earthquake> magTypeQuakes, String magType)
	{
		ArrayList<Integer> indexArray = new ArrayList<Integer>();
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		for (int i = 0; i < magTypeQuakes.size(); i++)
		{
			if (magTypeQuakes.get(i).magType.equals(magType))
				indexArray.add(i);
		}
		
		for (int i = 0; i < indexArray.size(); i++)
			result.add(magTypeQuakes.get(indexArray.get(i)));
		return result.toString();
	}
	
	//search by location
	public String searchByLocation(ArrayList<Earthquake> locationQuakes, double lat1, double lat2, double lon1, double lon2)
	{
		ArrayList<Integer> indexArray = new ArrayList<Integer>();
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		for (int i = 0; i < locationQuakes.size(); i++)
		{
			if ((locationQuakes.get(i).latitude >= lat1 && locationQuakes.get(i).latitude <= lat2)&&(locationQuakes.get(i).longitude >= lon1 && locationQuakes.get(i).longitude <= lon2))
				indexArray.add(i);
		}
		
		for (int i = 0; i < indexArray.size(); i++)
			result.add(locationQuakes.get(indexArray.get(i)));
		return result.toString();
	}
	
	// searchBy place
	public String searchByPlace(ArrayList<Earthquake> placeQuakes, String place)
	{
		ArrayList<Integer> indexArray = new ArrayList<Integer>();
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();

		for (int i = 0; i < placeQuakes.size(); i++)
		{
			if (placeQuakes.get(i).place.split(" ")[placeQuakes.get(i).place.split(" ").length - 1].toUpperCase().contains(place.toUpperCase()))
				indexArray.add(i);
		}
		
		for (int i = 0; i < indexArray.size(); i++)
			result.add(placeQuakes.get(indexArray.get(i)));
		return result.toString();
	}
	// searchBy status
	public String searchByStatus(ArrayList<Earthquake> statusQuakes, String status) {
		ArrayList<Integer> indexArray = new ArrayList<Integer>();
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		for (int i = 0; i < statusQuakes.size(); i++)
		{
			if (statusQuakes.get(i).status.equals(status))
				indexArray.add(i);
		}
		
		for (int i = 0; i < indexArray.size(); i++)
			result.add(statusQuakes.get(indexArray.get(i)));
		return result.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EarthquakeCollection ec = new EarthquakeCollection();
		ec.loadData("all_month.csv");
	}

}
