package com.capgemini.contactbook.dao;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.util.ContactBookException;

public class ContactBookDaoImpl implements ContactBookDao {
	private Map<Long,EnquiryBean> enquiryEntry = new HashMap<Long,EnquiryBean>();
	public Map<Long, EnquiryBean> getEnquiryEntry() {
		return enquiryEntry;
	}

	@Override
	public long addEnquiry(EnquiryBean bean) throws ContactBookException {
		long id = bean.getEnqryId();
		if(enquiryEntry.containsKey(id))
		{
			throw new ContactBookException("Entered Id already exists! Please try with some other value.");
		}
		enquiryEntry.put(bean.getEnqryId(), bean);
		return id;
	}

	@Override
	public EnquiryBean getEnquiryDetails(long EnquiryID) throws ContactBookException {
		EnquiryBean bean = enquiryEntry.get(EnquiryID);
		if(bean == null)
		{
			throw new ContactBookException("No data found for entered ID.");
		}
		return bean;
	}

}
