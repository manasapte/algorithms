package misc;

import java.util.ArrayList;
import java.util.List;

public class Stocks {

	List<Integer> bestDays(int[] prices) {
		int buy = 0;
		int sell = 0;
		int newbuy = buy, newsell = sell;
		int diff = 0;
		for(int i=0; i< prices.length; i++) {
			if(prices[i] < prices[newbuy]) {
				System.out.println("updating new buy to: " + i);
				newbuy = i;
			}
			if(prices[i] > prices[newsell]) {
				System.out.println("updating new sell to: " + i);
				newsell = i;
			}
			if(diff < newsell - newbuy) {
				buy = newbuy;
				sell = newsell;
				diff = buy - sell;
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		result.add(buy);
		result.add(sell);
		return result;
	}
	
	public static void main(String[] args) {
		Stocks s = new Stocks();
		int[] prices = new int[] {9, 8, 7, 6, 10, 12, 13, 16, 20, 25, 15, 16};
		List result = s.bestDays(prices);
		System.out.println("best days for transaction, buy: " + result.get(0) + " sell: " + result.get(1));
	}
	
}