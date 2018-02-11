package net.psy.backendshopping.dao;

import java.util.List;

import net.psy.backendshopping.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	
	Category get(int id);
}
