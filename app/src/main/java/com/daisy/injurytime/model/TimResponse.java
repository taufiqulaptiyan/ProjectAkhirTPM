package com.daisy.injurytime.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TimResponse{

	@SerializedName("teams")
	private ArrayList<TimItem> teams;

	public void setTeams(ArrayList<TimItem> teams){
		this.teams = teams;
	}

	public ArrayList<TimItem> getTeams(){
		return teams;
	}

	@Override
 	public String toString(){
		return 
			"TimResponse{" + 
			"teams = '" + teams + '\'' + 
			"}";
		}
}