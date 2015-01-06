package robo.Calculator;

import java.util.*;
import robo.domain.*;

public class Calculator {
	public int cents;
	private ArrayList<String> coinsName;
	private ArrayList<Integer> coinsCount;
	
	public Calculator() {
		this.cents = 0;
		this.coinsName = new ArrayList<String>();
		this.coinsCount = new ArrayList<Integer>();
	}
	
	public void addCoin(Coin coin) {
		this.cents += coin.value;
		if(!this.coinsName.contains(coin.name)) {
			this.coinsName.add(coin.name);
			this.coinsCount.add(coinsName.size()-1, 1);
		} else {
			int index = this.coinsName.indexOf(coin.name);
			this.coinsCount.add(index, this.coinsCount.get(index)+1);
		}
	}
	
	public List<String> getStatistics() {
		ArrayList<String> stats = new ArrayList<String>();
		for(int i = 0; i < coinsName.size(); i++) {
			stats.add(coinsName.get(i) + ":" + coinsCount.get(i));
		}
		return stats;
	}

}
