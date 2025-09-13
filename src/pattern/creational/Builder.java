package pattern.creational;

public class Builder {


	public static void main(String[] args) {

		Employee emp = new Employee.EmployeeBuilder().age(22).name("Faizan").build();
		System.out.println(emp);
	}


}

class Employee{

	private String name;

	private Integer age;

	private String profileName;



	private Employee(EmployeeBuilder employeeBuilder) {
		this.name = employeeBuilder.name;
		this.age = employeeBuilder.age;
		this.profileName = employeeBuilder.profileName;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Integer getAge() {
		return age;
	}




	public void setAge(Integer age) {
		this.age = age;
	}




	public String getProfileName() {
		return profileName;
	}




	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}




	public static class EmployeeBuilder{

		private String name;

		private Integer age;

		private String profileName;


		public EmployeeBuilder name(String name) {
			this.name = name;
			return this;
		}

		public EmployeeBuilder age(Integer age) {
			this.age = age;
			return this;
		}

		public EmployeeBuilder profileName(String profileName) {
			this.profileName = profileName;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}

	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", profileName=" + profileName + "]";
	}


}
