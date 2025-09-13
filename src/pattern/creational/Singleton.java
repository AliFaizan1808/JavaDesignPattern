package pattern.creational;

public class Singleton {
	
	School  sc = School.getSchoolObject();
	

}


class School{
	
	private String name;
	
	private String address;
	
	private static School school;
	
	
	private School() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	public static School getSchoolObject() {
		if(school == null) {
			school = new School();
		}
		return school;
	}
	
	
	
	
	
}
