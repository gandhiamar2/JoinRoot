package com.source.drivingHistory;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	private String name;
	private List<Trip> trips = new ArrayList<>() ;
	private Double averageSpeed = 0.0;
	private Double milesTotal =0.0;
	private Double timeTravelled =  0.0;
	
	
	public Double getTimeTravelled() {
		return timeTravelled;
	}
	public void setTimeTravelled(Double timeTravelled) {
		this.timeTravelled = timeTravelled;
	}
	public Double getAverageSpeed() {
		return averageSpeed;
	}
	public void setAverageSpeed(Double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	public Double getMilesTotal() {
		return milesTotal;
	}
	public void setMilesTotal(Double milesTotal) {
		this.milesTotal = milesTotal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Trip> getTrips() {
		return trips;
	}
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	

}
