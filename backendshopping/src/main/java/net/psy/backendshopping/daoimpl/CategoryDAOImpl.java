/**
 * 
 */
package net.psy.backendshopping.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.psy.backendshopping.dao.CategoryDAO;
import net.psy.backendshopping.dto.Category;

import org.springframework.stereotype.Repository;

/**
 * @author sowmya Feb 11, 2018
 *
 */

@Repository("CategoryDAO")//same name given in the page controller
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Telivision");
		category.setDescription("this is some discription of telivition");
		category.setImgUrl("CAT_1.png");

		categories.add(category);
		
		// second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("this is some discription of mobile");
		category.setImgUrl("CAT_2.png");

		categories.add(category);
		
		// third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("this is some discription of laptop");
		category.setImgUrl("CAT_3.png");

		categories.add(category);
		
		
	}

	// why static block using is as soon as CategoryDAOImpl get created
	// catogories whoud be initialised after initialising list will return

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		//enhanced for loop
		for(Category category : categories){
			if(category.getId()==id)
				return category;
		}
		return null;
	}

}
