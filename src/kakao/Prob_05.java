package kakao;

public class Prob_05 {
	
	static int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
	
	static int sum = 0;
	
	static int answer = 0;

	public static void main(String[] args) {

		/*int[][] array = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		
		int answer = solution(array);
		
		System.out.println(answer);*/
		
		/*recursive(0, 0, -1);*/
	}
	
	public static void recursive(int row, int preCol) {
		
		if(row<land.length-1) {
			recursive(row+1, preCol);
		}
		
		for(int i=0; i<4; i++) {
			sum += land[row][i];
			if(sum > answer) {
				answer = sum;
			}
			sum -= land[row][i];
		}
	}

	public static int solution(int[][] land) {
		
		int answer = 0;
		
		for(int row=0; row<land.length; row++) {
			
			for(int col=0; col<4; col++) {
				
			}
			
			int sum = 0;
			int i = 0;
			sum += land[row][i];
		}
		
		/*int sum = 0;
		for(int i=0; i<4; i++) {
			sum += land[0][i];
			
			for(int j=0; j<4; j++) {
				if(j != i) {
					sum += land[1][j];
					
					for(int k=0; k<4; k++) {
						if(k != j) {
							sum += land[2][k];
							if(sum > answer) {
								answer = sum;
							}
							sum -= land[2][k];
						}
					}
					sum -= land[1][j];
				}
			}
			sum -= land[0][i];
		}*/
		
		return answer;
	}
}
