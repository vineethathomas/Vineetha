package com.string.sorting.service;

import java.util.List;

import com.string.sorting.model.Name;

public interface SortService {
	
	List<Name> sortByLastName(List<Name> names);

}
