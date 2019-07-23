package ex1.com.cg.eis.dao;

import java.sql.SQLException;

import ex1.com.cg.eis.bean.Employee;

public interface IDao {

	boolean setdata(Employee e) throws SQLException, ClassNotFoundException;

	Employee getData(int id1) throws SQLException, ClassNotFoundException;

}
