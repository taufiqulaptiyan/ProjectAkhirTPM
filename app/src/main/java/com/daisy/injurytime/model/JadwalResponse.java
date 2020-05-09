package com.daisy.injurytime.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class JadwalResponse{

	@SerializedName("events")
	private ArrayList<JadwalItem> events;

	public void setEvents(ArrayList<JadwalItem> events){
		this.events = events;
	}

	public ArrayList<JadwalItem> getEvents(){
		return events;
	}

	@Override
 	public String toString(){
		return 
			"JadwalResponse{" + 
			"events = '" + events + '\'' + 
			"}";
		}
}