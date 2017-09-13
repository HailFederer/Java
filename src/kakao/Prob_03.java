package kakao;

public class Prob_03 {

	public static void main(String[] args) {

		int[][] v = {{1,4},{3,4},{3,10}};
		int[] array = solution(v);
		System.out.println(array[0]+":"+array[1]);
	}
	
	public static int[] solution(int[][] v) {
        
        int x = v[0][0], y = v[0][1];
        
        if(x == v[1][0]) {
        	x = v[2][0];
        } else {
        	if(x == v[2][0]) {
        		x = v[1][0];
        	} else {
        		x = v[0][0];
        	}
        }
        
        if(y == v[1][1]) {
        	y = v[2][1];
        } else {
        	if(y == v[2][1]) {
        		y = v[1][1];
        	} else {
        		y = v[0][1];
        	}
        }
		
        int[] answer = {x, y};

        return answer;
	}
}
