public class PieceWorker extends Employee{

	private int numItems;
	private double wage;

	//constructor
	public PieceWorker(String name, String address, int age, String gender, String company, int numItems, double wage){
		super(name, address, age, gender, company);
		this.numItems = numItems;
		this.wage = wage;
	}

	public PieceWorker(){

	}

	//setters
	public void setNumItems(int numItems){
		this.numItems = numItems;
	}
	public void setWage(double wage){
		this.wage = wage;
	}

	//getter
	public int getNumItems(){
		return numItems;
	}
	public double getWage(){
		return wage;
	}

	//abstract method
	public double earnings(){
		return (numItems*wage);
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString()+ "\nNumber of Items:\t" +this.numItems+ "\nWage:\t" +this.wage+ "\nEarnings:\t" +this.earnings());
		return sb.toString();
	}

	public boolean equals(Object obj){
		boolean flag = false;
		if(obj instanceof PieceWorker){
			PieceWorker r = (PieceWorker)obj;
			 if(super.equals(r) && this.earnings() == r.earnings()){
				 flag=true;
			 }
		 }
		 return flag;
	 }
}