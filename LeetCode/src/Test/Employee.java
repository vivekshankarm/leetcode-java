package Test;

public class Employee {
	private String name;
	private int age;
	private String team;

	public Employee(String name, int age, String team) {
		this.age = age;
		this.name = name;
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

//	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", team=" + team + "]";
	}

}
