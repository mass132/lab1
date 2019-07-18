package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;

public interface IFlatRegistrationService {
	/*
	 * @param FlatRegistration object
	 * 
	 * @method registerFlat - registers the flat
	 * 
	 * @return Flat Registration object
	 */
	FlatRegistrationDTO registerFlat(FlatRegistrationDTO flat);

	/*
	 * @method getAllOwnerIds - returns all the owner ids present in the 'owners'
	 * hashmap
	 * 
	 * @return Arraylist of Integer
	 */
	ArrayList<Integer> getAllOwnerIds();

	/*
	 * @method getFlatDetails - returns all the flat registration details
	 * 
	 * @return Arraylist of FlatRegistrationDTO
	 */
	ArrayList<FlatRegistrationDTO> getFlatDetails();

}
