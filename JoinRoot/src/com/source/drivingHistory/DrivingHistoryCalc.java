package com.source.drivingHistory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.BreakIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class DrivingHistoryCalc {
	
	

	public static void main(String[] args) throws IOException, ParseException {
		
		String filePath = args[0];
//		String filePath = "C:/Users/gandh/Desktop/test.txt";
		File file = new File(filePath);
		
		DrivingHistoryCalc drivingHistoryCalc = new DrivingHistoryCalc();
		List<Driver> drivers = drivingHistoryCalc.fileReader(file);
		drivingHistoryCalc.reportGenerator(drivers);
	}
	
	private List<Driver> fileReader(File file) throws IOException, ParseException{
		
		BufferedReader bfr = new BufferedReader(new FileReader(file));
		String s = bfr.readLine();
		List<Driver> drivers = new ArrayList<Driver>();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		while (s != null) {
			StringTokenizer str = new StringTokenizer(s, " ");
			if(s.contains("Driver")&&str.countTokens()==2)
			{
				Driver driver = new Driver();
				str.nextToken();
				driver.setName(str.nextToken());
				drivers.add(driver);
				
			}
			else if(s.contains("Trip")&&str.countTokens()==5)
			{
				str.nextToken();
				String name = str.nextToken();
				for (Driver driver : drivers) {
					if(driver.getName().equals(name))
					{
						Trip trip = new Trip();
						Date date1 = format.parse(str.nextToken());
						Date date2 = format.parse(str.nextToken());
						Long difference = (date2.getTime() - date1.getTime());
						Double duration = (difference.doubleValue()/(3600000));
						Double miles = Double.parseDouble(str.nextToken());
						Double speed = miles/duration;
						if(speed >=5 && speed <=100){
							trip.setSpeed(speed);
							trip.setMilesTravelled(miles);
							trip.setTime(duration.doubleValue());
							driver.getTrips().add(trip);
						}
					}
				}
				
			}
			
			s=bfr.readLine();
		}
		
		return drivers;
		
	}
	
	
	private void reportGenerator(List<Driver> drivers){
		
		for (Driver driver : drivers) {
			for (Trip trip : driver.getTrips()) {
				driver.setMilesTotal(driver.getMilesTotal()+trip.getMilesTravelled());
				driver.setTimeTravelled(driver.getTimeTravelled()+trip.getTime());
			}
			driver.setAverageSpeed(driver.getMilesTotal()/driver.getTimeTravelled());
		}
		
		Collections.sort( drivers,new Comparator<Driver>() {

			@Override
			public int compare(Driver arg0, Driver arg1) {
				// TODO Auto-generated method stub
				if(arg0.getMilesTotal()>arg1.getMilesTotal())
					return -1;
				else 
					return 0;
			}
		}); 
		
		for (Driver driver : drivers) {
			System.out.print(driver.getName()+": "+Math.round(driver.getMilesTotal())+" miles ");
			if(driver.getMilesTotal()!=0.0)
			System.out.print("@ "+Math.round(driver.getAverageSpeed())+" mph" );
			System.out.println();
		}
		
	}
	
	
}
