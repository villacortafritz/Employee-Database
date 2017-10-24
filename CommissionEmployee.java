public class CommissionEmployee extends Employee{

	private double salary;
	private double commission;
	private int itemSold;

	//constructor
	public CommissionEmployee(String name, String address, int age, String gender, String company, double salary, double commission, int itemSold){
		super(name, address, age, gender, company);
		this.salary = salary;
		this.commission = commission;
		this.itemSold = itemSold;
	}

	public CommissionEmployee(){
	}

	//setter
	public void setSalary(double salary){
		this.salary = salary;
	}
	public void setCommission(double commission){
		this.commission = commission;
	}
	public void setItemSold(int itemSold){
		this.itemSold = itemSold;
	}

	//getter
	public double getSalary(){
		return salary;
	}
	public double getCommission(){
		return commission;
	}
	public int getItemSold(){
		return itemSold;
	}

	//functions
	public double earnings(){
		return (salary + (itemSold*commission));
	}

	//override functions
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString()+ "\nSalary:\t" +this.salary+ "\nRate:\t" +this.commission+ "\nItem Sold:\t" +this.itemSold+ "\nEarnings:\t" +this.earnings());
		return sb.toString();
	}

	public boolean equals(Object obj){
		boolean flag = false;
		if(obj instanceof CommissionEmployee){
			CommissionEmployee r = (CommissionEmployee)obj;
			if(super.equals(r) && this.earnings() == r.earnings()){
				flag = true;
			}
		}
		return flag;
	}
}