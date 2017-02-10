package cornerstore_20170202;

public class Item {
	private int number;
	private String name;
	private double price;
	private int quantity;
	Item(int num, String n, double p, int q){
		number = num;
		name = n;
		price = p;
		quantity = q;
	}
	
	Item(String n, String num){
		name = n;
		price = Double.parseDouble(num);
	}
	
	Item(String num, String n, String p, String q){
		number = Integer.parseInt(num);
		name = n;
		price = Double.parseDouble(p);
		quantity = Integer.parseInt(q);
	}
	
	void setNumber(int num){
		number = num;
	}
	
	int getNumber(){
		return number;
	}
	
	void setName(String n){
		name = n;
	}
	
	String getName(){
		return name;
	}
	
	void setPrice(double p){
		if (p > 0){
			price = p;
		}
		else{
			System.out.println("Invalid price");
		}
	}
	
	double getPrice(){
		return price;
	}
	
	void setQuantity(int q){
		if (q > 0){
			quantity = q;
		}
		else{
			System.out.println("Invalid quantity");
		}
	}
	int getQuantity(){
		return quantity;
	}
	
	public String toString(){
		return number + "," + name + "," + price + "," + quantity;
	}
	/*
	void addProperty(Object o){
		if (number == 0){
			number = (int)o;
		}
		else if(name == null){
			name = (String)o;
		}
		else if(price == 0){
			price = (double)o;
		}
		else if(quantity == 0){
			quantity = (int)o;
		}
	}
	
	*/
	
	
}
