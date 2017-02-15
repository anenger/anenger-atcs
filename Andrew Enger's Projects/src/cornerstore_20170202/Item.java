package cornerstore_20170202;
//basic object class, has getters and setters for all variables, can take Strings as
//a constructor
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
		try{
		number = Integer.parseInt(num);
		name = n;
		price = Double.parseDouble(p);
		quantity = Integer.parseInt(q);
		}catch(Exception e){
			System.out.println(e);
		}
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
	
	
}
