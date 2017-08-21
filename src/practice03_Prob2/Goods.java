package practice03_Prob2;

public class Goods {

	private String productName;
	private int price;
	private int number;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		
		return productName+"(가격:"+price+"원)이 "+number+"개 입고 되었습니다.";
		//return new StringBuilder().append(productName).append("(가격:").append(price).append("원)이 ").append(number).append("개 입고 되었습니다.").toString();
	}
}


