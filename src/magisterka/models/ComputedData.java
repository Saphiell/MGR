package magisterka.models;

import java.util.ArrayList;

public class ComputedData {

	private ArrayList<SingleValue> modelValues;
	
	public ComputedData(ArrayList<SingleValue> modelValues) {
		this.setModelValues(modelValues);
	}

	public ArrayList<SingleValue> getModelValues() {
		return modelValues;
	}

	public void setModelValues(ArrayList<SingleValue> modelValues) {
		this.modelValues = modelValues;
	}
}
