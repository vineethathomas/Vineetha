package com.string.sorting.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.string.sorting.model.Name;

public class SortServiceImpl implements SortService{

	@Override
	public List<Name> sortByLastName(List<Name> names) {
		
		//"---Sorting using Comparator by Last Name---"
		List<Name> nList = names.stream().sorted(Comparator.comparing(Name::getLastName)).collect(Collectors.toList());
		
		return nList; 
	}

}