package com.daisy.injurytime.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LigaResponse{

	@SerializedName("countrys")
	private ArrayList<LigaItem> countrys;

	public void setCountrys(ArrayList<LigaItem> countrys){
		this.countrys = countrys;
	}

	public ArrayList<LigaItem> getCountrys(){
		return countrys;
	}

	@Override
 	public String toString(){
		return 
			"LigaResponse{" + 
			"countrys = '" + countrys + '\'' + 
			"}";
		}
}