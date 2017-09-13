package UVa;

public class test {
	
	static int sum = 0;
	static int highestScore = 0;

	public static void main(String[] args) {
		
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		highestScore = recursive(0, -1, land);
		
		System.out.println(highestScore);
	}
	
	public static int recursive(int row, int col, int[][] land) {
		
		for(int i=0; i<4; i++) {
			if(i != col) {
				sum += land[row][i];
				if(row < land.length-1) {
					recursive(row+1, i, land);
				}
				if(row == land.length-1) {
					if(sum > highestScore) {
						highestScore = sum;
					}
				}
				sum -= land[row][i];
			}
		}
		
		return highestScore;
	}
}





