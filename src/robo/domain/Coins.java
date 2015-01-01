package robo.domain;

import java.util.ArrayList;
import java.util.List;

public class Coins {
		private List<Coin> coins;
		
		public Coins() {
			this.coins = new ArrayList<Coin>();
			coins.add(new Coin(75, 250, "10 cent", 10, 150, 400));
			coins.add(new Coin(251, 375, "5 cent", 5, 350, 385));
			coins.add(new Coin(376, 500, "20 cent", 20, 450, 350));
			coins.add(new Coin(501, 625, "1 euro", 100, 575, 310));
			coins.add(new Coin(626, 725, "50 cent", 50, 675, 245));
			coins.add(new Coin(726, 1000, "2 euro", 200, 900, 220));
		}
		
		public Coin getCorrespondingCoin(int input) {
			return binarySearch(input, 0, this.coins.size()-1);
		}
		
		private Coin binarySearch(int input, int min, int max) {
			if (max < min) return null;
			int midPoint = (min + max) / 2;
			int compareNumber = this.coins.get(midPoint).compareInputValue(input);
			if(compareNumber == 1) {
				return binarySearch(input, midPoint+1, max);
			} else if(compareNumber == -1) {
				return binarySearch(input, min, midPoint);
			} else {
				return this.coins.get(midPoint);
			}
		}
}
