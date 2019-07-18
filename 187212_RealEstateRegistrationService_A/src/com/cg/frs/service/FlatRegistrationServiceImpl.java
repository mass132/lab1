package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dao.FlatRegistrationDAOImpl;
import com.cg.frs.dao.IFlatRegistrationDAO;
import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.exception.RealEstateAppException;

public class FlatRegistrationServiceImpl implements IFlatRegistrationService {
	private IFlatRegistrationDAO frDao = new FlatRegistrationDAOImpl();

	/*
	 * returns FlatRegistraionDAO object
	 */
	public IFlatRegistrationDAO getFrDao() {
		return frDao;
	}

	@Override
	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO flat) {
		int regId = generateRegId();
		flat.setRegId(regId);
		return getFrDao().registerFlat(flat);
	}

	@Override
	public ArrayList<Integer> getAllOwnerIds() {
		return getFrDao().getAllOwnerIds();
	}

	/*
	 * @return int generates flat registration id using Math.random()
	 */
	private int generateRegId() {
		int id = 1;
		for (int i = 0; i < 4; i++) {
			id = (int) (id * 10 + Math.random() * 10);
		}
		return id;
	}

	/*
	 * validates the details entered by the client and throws RealEstateAppException
	 * if found invalid
	 */
	public void validateDetails(int ownerId, String flatType, double deposit, double rent, double flatArea)
			throws RealEstateAppException {
		if (!getFrDao().getAllOwnerIds().contains(ownerId)) {
			throw new RealEstateAppException("Owner does not exists");
		}
		if (!((flatType.equals("1BHK")) || (flatType.equals("2BHK")))) {
			throw new RealEstateAppException("Invalid Flat type entered!");

		}
		if (deposit <= 0 || rent <= 0) {
			throw new RealEstateAppException("Please enter valid amounts!");

		}
		if (deposit < rent) {
			throw new RealEstateAppException("Deposit amount must be greater than rent amount!");

		}
		if (flatArea <= 0) {
			throw new RealEstateAppException("flat area must be greater than zero!");
		}

	}

	@Override
	public ArrayList<FlatRegistrationDTO> getFlatDetails() {
		return getFrDao().getFlatDetails();
	}
}
