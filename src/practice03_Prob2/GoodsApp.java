package practice03_Prob2;

import java.util.Scanner;

public class GoodsApp {
	
	public static Goods GoodsInput(String goodsInfo){

		Goods goods = new Goods();
		
		String[] str = goodsInfo.split(" ");
		
		goods.setProductName(str[0]);
		goods.setPrice(Integer.parseInt(str[1]));
		goods.setNumber(Integer.parseInt(str[2]));
		
		return goods;
	}

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		Goods[] goodsArray = new Goods[3];
		
		for(int i=0; i<goodsArray.length; i++){
				
			goodsArray[i] = GoodsInput(scanner.nextLine());
		}
		
		for(int i=0; i<3; i++){
			System.out.println(goodsArray[i]);
		}
	}
}
