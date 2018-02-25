package net.psy.backendshopping.test;

import static org.junit.Assert.assertEquals;
import net.psy.backendshopping.dao.CategoryDAO;
import net.psy.backendshopping.dto.Category;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();

		context.scan("net.psy.backendshopping");

		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	/*
	 * @Test public void testAddCategory(){ category=new Category();
	 * 
	 * category.setName("TV");
	 * category.setDescription("this is some discription of Telivision");
	 * category.setImgUrl("CAT_1.png");
	 * 
	 * assertEquals("Successfully added a category inside the table!",true,
	 * categoryDAO.add(category)); }
	 */

	/*
	 * @Test public void testGetCategory(){ Category
	 * category=categoryDAO.get(1);
	 * assertEquals("Successfully fetched a single category from the table!"
	 * ,"Telivision",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory(){ Category
	 * category=categoryDAO.get(1); category.setName("TV");
	 * assertEquals("Successfully updated a single category in the table!"
	 * ,true,categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory(){ Category
	 * category=categoryDAO.get(5);
	 * 
	 * assertEquals("Successfully updated a single category in the table!",true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory(){
	 * 
	 * assertEquals("Successfully fetched the list of categories from the table!"
	 * ,3,categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {

		// add operation
		category = new Category();

		category.setName("Telivision");
		category.setDescription("this is some discription of Telivision");
		category.setImgUrl("CAT_1.png");

		assertEquals("Successfully added a category inside the table!", true,
				categoryDAO.add(category));

		category = new Category();

		category.setName("Mobile");
		category.setDescription("this is some discription of Mobile");
		category.setImgUrl("CAT_1.png");

		assertEquals("Successfully added a category inside the table!", true,
				categoryDAO.add(category));

		category = new Category();

		category.setName("Laptop");
		category.setDescription("this is some discription of Laptop");
		category.setImgUrl("CAT_1.png");

		assertEquals("Successfully added a category inside the table!", true,
				categoryDAO.add(category));

		// fetching and updating the category
		category = categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Successfully updated a single category in the table!",
				true, categoryDAO.update(category));

		// delete the category

		assertEquals("Successfully updated a single category in the table!",
				true, categoryDAO.delete(category));

		// fetching the list
		assertEquals(
				"Successfully fetched the list of categories from the table!",
				2, categoryDAO.list().size());
	}

}
