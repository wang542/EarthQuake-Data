package application;

import java.util.*;
import java.time.format.*;
import java.time.*;
import java.time.OffsetDateTime;
import java.time.zone.*;
import java.text.*;

public class Earthquake {
	Date time, updated;
	String magType, net, id, place, type, locationSource, magSource, status;
	double latitude, longitude, depth, mag, gap, dmin, rms, horizontalError, depthError, magError;
	int nst, magNst;
	
	public Earthquake() {
		
	}
	
	public Earthquake(Date time,double latitude, double longitude, double depth, 
						double mag, String magType, int nst, double gap, 
						double dmin, double rms, String net, String id, 
						Date updated, String type, double horizontalError, 
						double depthError, double magError, int magNst,  String status, String locationSource, 
						String magSource, String place) {
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.depth = depth;
		this.mag = mag;
		this.magType = magType;
		this.nst = nst;
		this.gap = gap;
		this.dmin = dmin;
		this.rms = rms;
		this.net = net;
		this.id = id;
		this.updated = updated;
		this.type = type;
		this.horizontalError = horizontalError;
		this.depthError = depthError;
		this.magError = magError;
		this.magNst = magNst;
		this.status = status;
		this.locationSource = locationSource;
		this.magSource = magSource;
		this.place = place;
	}
	
	public Earthquake createAndPopulateQuake(ArrayList<String> arr) {
		Earthquake e = new Earthquake();
		try {
			e.setTime(this.stringToDate(arr.get(0))); // need to convert date
			e.setLatitude(emptyToDouble(arr.get(1)));
			e.setLongitude(emptyToDouble(arr.get(2)));
			e.setDepth(emptyToDouble(arr.get(3)));
			e.setMag(emptyToDouble(arr.get(4)));
			e.setMagType(arr.get(5));
			e.setNst(emptyToInt(arr.get(6))); // new
			e.setGap(emptyToDouble(arr.get(7)));
			e.setDmin(emptyToDouble(arr.get(8)));
			e.setRms(emptyToDouble(arr.get(9)));
			e.setNet(arr.get(10));
			e.setId(arr.get(11));
			e.setUpdated(this.stringToDate(arr.get(12))); // need to convert date
			e.setType(arr.get(13));
			e.setHorizontalError(emptyToDouble(arr.get(14)));
			e.setDepthError(emptyToDouble(arr.get(15)));
			e.setMagError(emptyToDouble(arr.get(16)));
			e.setMagNst(emptyToInt(arr.get(17)));
			e.setStatus(arr.get(18));
			e.setLocationSource(arr.get(19));
			e.setMagSource(arr.get(20));
			e.setPlace(arr.get(21));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
	
	private Date stringToDate(String date) {
		DateTimeFormatter f = DateTimeFormatter.ISO_INSTANT;
		Instant instant = Instant.from(f.parse(date));
		Date myDate = Date.from(instant);
		SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
		String formattedDate = formatter.format(myDate);
	    
		return myDate;
		
	}
	
	private int emptyToInt(String str) {
		int result;
		if (str.equals("")) {
			result = 0;
		} else {
			result = Integer.parseInt(str);
		}
		
		return result;
	}
	
	private double emptyToDouble(String str) {
		double result;
		if (str.equals("")) {
			result = 0.0;
		} else {
			result = Double.parseDouble(str);
		}
		
		return result;
	}
	
	private Date getTime() {
		return time;
	}

	private void setTime(Date time) {
		this.time = time;
	}

	private Date getUpdated() {
		return updated;
	}

	private void setUpdated(Date updated) {
		this.updated = updated;
	}

	private String getMagType() {
		return magType;
	}

	private void setMagType(String magType) {
		this.magType = magType;
	}

	private String getNet() {
		return net;
	}

	private void setNet(String net) {
		this.net = net;
	}

	private String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	private String getPlace() {
		return place;
	}

	private void setPlace(String place) {
		this.place = place;
	}

	private String getType() {
		return type;
	}

	private void setType(String type) {
		this.type = type;
	}

	private String getLocationSource() {
		return locationSource;
	}

	private void setLocationSource(String locationSource) {
		this.locationSource = locationSource;
	}

	private String getMagSource() {
		return magSource;
	}

	private void setMagSource(String magSource) {
		this.magSource = magSource;
	}

	private String getStatus() {
		return status;
	}

	private void setStatus(String status) {
		this.status = status;
	}

	private double getLatitude() {
		return latitude;
	}

	private void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	private double getLongitude() {
		return longitude;
	}

	private void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	private double getDepth() {
		return depth;
	}

	private void setDepth(double depth) {
		this.depth = depth;
	}

	private double getMag() {
		return mag;
	}

	private void setMag(double mag) {
		this.mag = mag;
	}

	private double getGap() {
		return gap;
	}

	private void setGap(double gap) {
		this.gap = gap;
	}

	private double getDmin() {
		return dmin;
	}

	private void setDmin(double dmin) {
		this.dmin = dmin;
	}

	private double getRms() {
		return rms;
	}

	private void setRms(double rms) {
		this.rms = rms;
	}

	private double getHorizontalError() {
		return horizontalError;
	}

	private void setHorizontalError(double horizontalError) {
		this.horizontalError = horizontalError;
	}

	private double getDepthError() {
		return depthError;
	}

	private void setDepthError(double depthError) {
		this.depthError = depthError;
	}

	private double getMagError() {
		return magError;
	}

	private void setMagError(double magError) {
		this.magError = magError;
	}

	private int getNst() {
		return nst;
	}

	private void setNst(int nst) {
		this.nst = nst;
	}

	private int getMagNst() {
		return magNst;
	}

	private void setMagNst(int magNst) {
		this.magNst = magNst;
	}
	



	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("ID: " + this.getId().toString() + "\n");
		str.append("Time: " + this.getTime().toString() + "\n");
		str.append("Last Updated: " + this.getUpdated().toString() + "\n");
		str.append("Mag Type: " + this.getMagType().toString() + "\n");
		str.append("Net: " + this.getNet().toString() + "\n");
		str.append("Place: " + this.getPlace().toString() + "\n");
		str.append("Type: " + this.getType().toString() + "\n");
		str.append("Location Source: " + this.getLocationSource().toString() + "\n");
		str.append("Mag Source: " + this.getMagSource().toString() + "\n");
		str.append("Status: " + this.getStatus().toString() + "\n");
		str.append("Latitude: " + this.getLatitude() + "\n");
		str.append("Longitude: " + this.getLongitude() + "\n");
		str.append("Depth: " + this.getDepth() + "\n");
		str.append("Mag: " + this.getMag() + "\n");
		str.append("Gap: " + this.getGap() + "\n");
		str.append("Dmin: " + this.getDmin() + "\n");
		str.append("Rms: " + this.getRms() + "\n");
		str.append("Horizontal Error: " + this.getHorizontalError() + "\n");
		str.append("Depth Error: " + this.getDepthError() + "\n");
		str.append("Mag Error: " + this.getMagError() + "\n");
		str.append("NST: " + this.getNst() + "\n");
		str.append("MagNST: " + this.getMagNst() + "\n");
		return str.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Earthquake e = new Earthquake();
		Date date = e.stringToDate("2017-10-19T17:07:29.620Z");
		System.out.println(date.toString());
		
	}
	}
