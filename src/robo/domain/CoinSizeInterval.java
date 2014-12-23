package robo.domain;

public class CoinSizeInterval {
	public int starts;
	public int ends;
	public String name; 
	public int calibrate;
	
	public CoinSizeInterval(int starts, int ends, String name, int calibrate) {
		this.starts = starts;
		this.ends = ends;
		this.name = name;
		this.calibrate = calibrate;
	}
}
