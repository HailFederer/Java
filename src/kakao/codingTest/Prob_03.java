package kakao.codingTest;

import java.util.LinkedList;
import java.util.Queue;

public class Prob_03 {

	public static void main(String[] args) {
		
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

		int answer = 0;
		
		Queue<String> queue = new LinkedList<String>();
		
		for(int i=0; i<cities.length; i++) {
			
			String city = cities[i];
			city = city.toLowerCase();
			if(queue.contains(city)) {
				queue.remove(city);
				queue.offer(city);
				answer += 1;
			} else {
				if(queue.size() == cacheSize) {
					queue.poll();
				}
				queue.offer(city);
				answer += 5;
			}
		}
		
		System.out.println(answer);
	}

}
