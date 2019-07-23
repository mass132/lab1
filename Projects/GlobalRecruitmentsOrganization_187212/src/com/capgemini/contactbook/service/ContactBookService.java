package com.capgemini.contactbook.service;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.util.ContactBookException;

public interface ContactBookService
{
public  long   addEnquiry(EnquiryBean  bean) throws ContactBookException;
public EnquiryBean  getEnquiryDetails(long EnquiryID) throws ContactBookException;
public  boolean  isValidEnquiry(EnquiryBean bean) throws ContactBookException;

}
