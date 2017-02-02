package cornerstore_20170202;

public class Item {
	private String name;
	private double price;
	private int quantity;
	Item(String n, double p, int q){
		name = n;
		price = p;
		quantity = q;
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
	
	
}
