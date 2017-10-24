public class HourlyEmployee extends Employee{

	private int hoursWorked;
	private double rate;

	//constructor
	public HourlyEmployee(String name, String address, int age, String gender, String company, int hoursWorked, double rate){
		super(name, address, age, gender, company);
		this.hoursWorked = hoursWorked;
		this.rate = rate;
	}

	public HourlyEmployee(){

	}

	//setter
	public void setHoursWorked(int HoursWorked){
		this.hoursWorked = hoursWorked;
	}
	public void setRate(double rate){
		this.rate = rate;
	}

	//getter
	public int getHoursWorked(){
		return hoursWorked;
	}
	public double getRate(){
		return rate;
	}

	//abstract method
	public double earnings(){
		if(this.hoursWorked>40){
			rate*=1.5;
		}
		return(hoursWorked*rate);
	}

	//override functions
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString()+ "\nHoursWorked:\n" +this.hoursWorked+ "\nRate:\t" +this.rate+ "\nEarnings:\t" +this.earnings());
		return sb.toString();
	}

	public boolean equals(Object obj){
		boolean flag = false;
		if(obj instanceof PieceWorker){
			PieceWorker r = (PieceWorker)obj;
			if(super.equals(r) && this.earnings() == r.earnings()){
				flag =true;
			}
		}
		return flag;
	}
}