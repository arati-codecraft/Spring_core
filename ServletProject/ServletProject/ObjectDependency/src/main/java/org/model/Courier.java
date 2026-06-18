package org.model;

public class Courier {
	private Parcel parcel;
	public Parcel getParcel() {
		return parcel;
	}
	public void setParcel(Parcel parcel) { //setter injection with object dependency 
		this.parcel = parcel;
	}

}
