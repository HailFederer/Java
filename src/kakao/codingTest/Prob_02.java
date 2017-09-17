package kakao.codingTest;

public class Prob_02 {

	public static void main(String[] args) {

		String[] dartResults = {"1S2D*3T", "1D2S#10S", "1D2S0T",
				"1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
		
		for(int j=0; j<dartResults.length; j++) {
			String dartResult = dartResults[j];
			int answer = 0;
			int thisTry = 0;
			int preTry = 0;
			
			for(int i=0; i<3; i++) {
				
				int lengOfDartResult = dartResult.length();
				
				int score = 0;
				String pow = "";
				String option = "";
				char c = ' ';
				if(lengOfDartResult > 3) {
					c = dartResult.charAt(2);
					if(c > 47 && c < 58) {
						score = Integer.parseInt(dartResult.substring(0,1));
						pow = dartResult.substring(1,2);
						dartResult = dartResult.substring(2);
					} else if(c == 42 || c == 35) {
						score = Integer.parseInt(dartResult.substring(0,1));
						pow = dartResult.substring(1,2);
						option = dartResult.substring(2,3);
						dartResult = dartResult.substring(3);
					} else {
						c = dartResult.charAt(3);
						if(c == 42 || c == 35) {
							score = Integer.parseInt(dartResult.substring(0,2));
							pow = dartResult.substring(2,3);
							option = dartResult.substring(3,4);
							dartResult = dartResult.substring(4);
						} else {
							score = Integer.parseInt(dartResult.substring(0,2));
							pow = dartResult.substring(2,3);
							dartResult = dartResult.substring(3);
						}
					}
				} else if(lengOfDartResult == 3) {
					c = dartResult.charAt(2);
					if(c == 42 || c == 35) {
						score = Integer.parseInt(dartResult.substring(0,1));
						pow = dartResult.substring(1,2);
						option = dartResult.substring(2,3);
					} else {
						score = Integer.parseInt(dartResult.substring(0,2));
						pow = dartResult.substring(2,3);
					}
				} else {
					score = Integer.parseInt(dartResult.substring(0,1));
					pow = dartResult.substring(1,2);
				}
				
				if("S".equals(pow)) {
					thisTry = (int)Math.pow(score, 1);
				} else if("D".equals(pow)) {
					thisTry = (int)Math.pow(score, 2);
				} else {
					thisTry = (int)Math.pow(score, 3);
				}
				if(!"".equals(option)) {
	 				if("*".equals(option)) {
	 					thisTry *= 2;
	 					answer += preTry;
					} else {
						thisTry *= -1;
					}
				}
				answer += preTry = thisTry;
			}
			
			System.out.println(answer);
		}
	}

}
