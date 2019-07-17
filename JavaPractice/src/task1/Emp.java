package task1;

public class Emp {
	private long id;
	private String name;
	private String designation;

	@Override
	public String toString() {
		return "Emp Details\nid=" + id + "\nname=" + name + "\ndesignation=" + designation;
	}

	public Emp(long id, String name, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
