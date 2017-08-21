package practice01;

public class Prob5 {

	public static void main(String[] args) {
		
		String st;
		for(int i=1; i<10000; i++){
			
			st = Integer.toString(i);
			//st = String.valueOf(i);
			
			if(st.contains("3") || st.contains("6") || st.contains("9")){
				
				int clapNum=0;
				for(int j=0; j<st.length(); j++){

					String separateNum = st.substring(j, j+1);
					if(separateNum.equals("3") || separateNum.equals("6") || separateNum.equals("9")){
						clapNum++;
					}
				}
				
				System.out.print(st+" ");
				for(int m=0; m<clapNum; m++){
					System.out.print("짝");
				}
				System.out.println();
			}
		}
	}
}
