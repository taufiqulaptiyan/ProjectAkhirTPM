package com.daisy.injurytime.model;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class HasilResponse{

	@SerializedName("events")
	private ArrayList<HasilItem> events;

	public void setEvents(ArrayList<HasilItem> events){
		this.events = events;
	}

	public ArrayList<HasilItem> getEvents(){
		return events;
	}

	@Override
 	public String toString(){
		return 
			"HasilResponse{" + 
			"events = '" + events + '\'' + 
			"}";
		}
}