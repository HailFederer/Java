package kakao.codingTest;

import java.util.ArrayList;

public class Prob_06 {

	public static void main(String[] args) {

		int m = 6;
		int n = 6; 
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		
		int answer = 0;
		
		String[][] boardArray = new String[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				boardArray[i][j] = board[i].substring(j, j+1);
			}
		}			

				for(int i=0; i<m; i++) {
					for(int j=0; j<n; j++) {
						System.out.print(boardArray[i][j]);
					}
					System.out.println();
				}
				System.out.println();
		
		ArrayList<Integer> listRow;
		ArrayList<Integer> listCol;
		
		while(true) {
			listRow = new ArrayList<Integer>();
			listCol = new ArrayList<Integer>();
			for(int i=0; i<m-1; i++) {
				for(int j=0; j<n-1; j++) {
					String str = boardArray[i][j];
					if(!" ".equals(str)
							&& str.equals(boardArray[i][j+1])
							&& str.equals(boardArray[i+1][j])
							&& str.equals(boardArray[i+1][j+1])) {
						listRow.add(i);
						listCol.add(j);
					}
				}
			}
			
			if(listRow.size() == 0) {
				break;
			}
	
			for(int i=0; i<listRow.size(); i++) {
				int row = listRow.get(i);
				int col = listCol.get(i);
				boardArray[row][col] = " ";
				boardArray[row][col+1] = " ";
				boardArray[row+1][col] = " ";
				boardArray[row+1][col+1] = " ";
			}			

					for(int i=0; i<m; i++) {
						for(int j=0; j<n; j++) {
							System.out.print(boardArray[i][j]);
						}
						System.out.println();
					}
					System.out.println();

			for(int i=m-1; i>0; i--) {
				for(int j=0; j<n; j++) {
					String str = boardArray[i][j];
					if(" ".equals(str)) {
						for(int k=i-1; k>=0; k--) {
							String str2 = boardArray[k][j];
							if(!" ".equals(str2)) {
								boardArray[i][j] = str2;
								boardArray[k][j] = " ";
								break;
							}
						}
					}
				}
			}			

					for(int i=0; i<m; i++) {
						for(int j=0; j<n; j++) {
							System.out.print(boardArray[i][j]);
						}
						System.out.println();
					}
					System.out.println();
		}

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(" ".equals(boardArray[i][j])){
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}
