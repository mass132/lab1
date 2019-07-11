package class_hashmap_task;

public class Employee {
private int id;
private String name;
private String location;
public int getId() {
	return id;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", location=" + location + "]";
}
public Employee(int id, String name, String location) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
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
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
}
