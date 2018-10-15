package com.airhacks.model;

public class Location {

	private double longitude;
	private double latitude;

	public Location() {
	}

	public Location(double d, double e) {
		this.latitude = d;
		this.longitude = e;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Location [longitude=" + longitude + ", latitude=" + latitude + "]";
	}

}
