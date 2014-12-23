package robo.domain;

public class Coin {
	public int starts;
	public int ends;
	public String name; 
	public int calibrate;
	public int value;
	
	public Coin(int starts, int ends, String name, int value, int calibrate) {
		this.starts = starts;
		this.ends = ends;
		this.name = name;
		this.calibrate = calibrate;
		this.value = value;
	}
	
	public int compareInputValue(int input) {
		if(this.starts <= input && this.ends >= input) {
			return 0;
		} else if(this.starts > input) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public String toString() {
		return "Starts: "+ this.starts +", ends: " + this.ends+", name: " + this.name;
	}
}
