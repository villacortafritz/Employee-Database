	public abstract class Employee{

	private String name;
	private String address;
	private int age;
	private String gender;
	private String company;

	//constructors
	public Employee(String name, String address, int age, String gender, String company){
		this.name = name;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.company = company;
	}

	public Employee(){

	}

	//setters
	public void setName(String name){
		this.name = name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public void setCompany(String company){
		this.company = company;
	}

	//getters
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public int getAge(){
		return age;
	}
	public String getGender(){
		return gender;
	}
	public String getCompany(){
		return company;
	}

	//abstract method
	public abstract double earnings();

	//override

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Name:\t" +this.name+ "\nAddress:\t" +this.address+ "\nAge:\t" +this.age+ "\nGender:\t" +this.gender+ "\nCompany:\t" +this.company);
		return sb.toString();
	}

	public boolean equals(Object obj){
		boolean flag = false;
		if(obj instanceof Employee){
			Employee r = (Employee)obj;
			if(this.age == r.age && this.name.equals(r.name) && this.address.equals(r.address) && this.gender.equals(r.gender) && this.company.equals(r.company)){
				flag=true;
			}
		}
		return flag;
	}
}