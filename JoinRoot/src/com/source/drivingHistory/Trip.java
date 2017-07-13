package com.source.drivingHistory;

import java.util.List;

public class Trip {
	
	private Double time;
	private Double milesTravelled;
	private Double speed;
	
	
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed2) {
		this.speed = speed2;
	}
	public Double getTime() {
		return this.time;
	}
	
	public void setTime(Double time) {
		this.time = time;
	}
	public Double getMilesTravelled() {
		return milesTravelled;
	}
	public void setMilesTravelled(Double milesTravelled) {
		this.milesTravelled = milesTravelled;
	}
	
	

}
