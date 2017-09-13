package UVa;

public class test2 {

	public static void main(String[] args) {
		
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		
		int sum = solution(land);
		
		System.out.println(sum);
	}
	
	public static int solution(int[][] land) {
		
		int highestScore = 0;
		
		for(int i=0; i<4; i++) {
			int sum = 0;
			sum += land[0][i];
			
			for(int j=0; j<4; j++) {
				
				if(i != j) {
					sum += land[1][j];
					
					for(int k=0; k<4; k++) {
						
						if(j != k) {
							sum += land[2][k];
							if(sum > highestScore) {
								highestScore = sum;
							}
							sum -= land[2][k];
						}
					}
					
					sum -= land[1][j];
				}
			}
			
			sum -= land[0][i];
		}
		
		return highestScore;
	}

}
