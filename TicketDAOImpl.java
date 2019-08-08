package com.cg.tms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.cg.tms.bean.TicketBean;
import com.cg.tms.bean.TicketCategory;

public class TicketDAOImpl implements TicketDAO {
	private static Map<String, String> ticketCategory = new HashMap<String, String>();
	private static Map<Integer, TicketBean> tickets = new HashMap<Integer, TicketBean>();

	public static Map<String, String> getTicketCategoryEntries() {
		ticketCategory.put("tc001", "software installation");
		ticketCategory.put("tc002", "mailbox creation");
		ticketCategory.put("tc003","mailbox issues");
		return ticketCategory;
	}

	@Override
	public int raiseNewTicket(TicketBean ticketBean) {
		tickets.put(ticketBean.getTicketNo(), ticketBean);
		return ticketBean.getTicketNo();
	}

	@Override
	public List<TicketCategory> listTicketCategory() {
		List<TicketCategory> list = new ArrayList<TicketCategory>();
		Set categorySet = getTicketCategoryEntries().entrySet();
		Iterator itr = categorySet.iterator();
		while(itr.hasNext())
		{
			Entry e = (Entry) itr.next();
			TicketCategory ticketCat = new TicketCategory((String)e.getKey(), (String)e.getValue());
			list.add(ticketCat);
		}
		return list;
	}

	

}
