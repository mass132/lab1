package com.capgemini.contactbook.dao;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.util.ContactBookException;

public interface ContactBookDao {
	public long   addEnquiry(EnquiryBean  bean) throws ContactBookException;
	public  EnquiryBean  getEnquiryDetails(long    EnquiryID) throws ContactBookException;


}
