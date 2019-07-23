package com.cg.frs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cg.frs.dto.FlatOwner;
import com.cg.frs.dto.FlatRegistrationDTO;

public class FlatRegistrationDAOImpl implements IFlatRegistrationDAO {
	private static Map<Integer, FlatOwner> owners = new HashMap<Integer, FlatOwner>();
	private static Map<Integer, FlatRegistrationDTO> flatDetails = new HashMap<Integer, FlatRegistrationDTO>();

	public Map<Integer, FlatOwner> getOwners() {
		return owners;
	}

	static {
		owners.put(1, new FlatOwner(1, "Vaishali", "9023002122"));
		owners.put(2, new FlatOwner(2, "Megha", "9643221234"));
		owners.put(3, new FlatOwner(3, "Manish", "5453221234"));
	}

	@Override
	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO flat) {
		flatDetails.put(flat.getRegId(), flat);
		return flat;
	}

	@Override
	public ArrayList<Integer> getAllOwnerIds() {
		ArrayList<Integer> ownerList = new ArrayList<>(owners.keySet());
		return ownerList;
	}

	@Override
	public ArrayList<FlatRegistrationDTO> getFlatDetails() {
		return new ArrayList<FlatRegistrationDTO>(flatDetails.values());
	}

}
