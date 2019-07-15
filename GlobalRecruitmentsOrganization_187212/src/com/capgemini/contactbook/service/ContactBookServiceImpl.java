package com.capgemini.contactbook.service;

import com.capgemini.contactbook.util.ContactBookException;
import com.capgemini.contactbook.util.Util;
import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;

public class ContactBookServiceImpl implements ContactBookService {
	private ContactBookDao contactBookDao = new ContactBookDaoImpl();

	@Override
	public long addEnquiry(EnquiryBean bean) throws ContactBookException {
		long id = Util.generateId();
		bean.setEnqryId(id);
		isValidEnquiry(bean);
		long Enquiryid = contactBookDao.addEnquiry(bean);
		return Enquiryid;
	}

	@Override
	public EnquiryBean getEnquiryDetails(long EnquiryID) throws ContactBookException {
		EnquiryBean bean = contactBookDao.getEnquiryDetails(EnquiryID);
		return bean;
	}

	@Override
	public boolean isValidEnquiry(EnquiryBean bean) throws ContactBookException {
		Util.validateName(bean.getfName());
		String contactNo = Long.toString(bean.getContactNo());
		Util.validateContactNo(contactNo);
		Util.validatePLocation(bean.getpLocation());
		Util.validatePDomain(bean.getpDomain());
		return true;
	}
}
