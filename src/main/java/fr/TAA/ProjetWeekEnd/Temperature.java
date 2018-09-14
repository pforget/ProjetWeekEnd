package fr.TAA.ProjetWeekEnd;

public class Temperature {

	public Temperature() {
		
	}
	
	public Temperature(float value) {
		super();
		this.value = value;
	}

	private float value;

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
}
