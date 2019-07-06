package io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {
	transient private int sno;
	private String name;
	private String addr;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	

}
