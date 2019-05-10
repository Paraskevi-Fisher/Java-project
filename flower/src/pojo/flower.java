package pojo;

public class flower {
	private int id;
	private String name;
	private double price;
	private String production;
	public flower() {
		// TODO Auto-generated constructor stub
	}
	public flower(int id, String name,double price,String production){
		this.id = id;
		this.name = name;
		this.price = price;
		this.production = production;
	}
	
	@Override
	public String toString() {
		return "flower [id=" + id + ", name=" + name + ", price=" + price
				+ ", production=" + production + "]";
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
}
