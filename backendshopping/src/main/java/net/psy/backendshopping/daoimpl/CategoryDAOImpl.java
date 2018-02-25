/**
 * 
 */
package net.psy.backendshopping.daoimpl;

import java.util.List;

import net.psy.backendshopping.dao.CategoryDAO;
import net.psy.backendshopping.dto.Category;



import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sowmya Feb 11, 2018
 *
 */

@Repository("categoryDAO")
@Transactional
// same name given in the page controller
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// why static block using is as soon as CategoryDAOImpl get created
	// catogories whoud be initialised after initialising list will return

	@Override
	public List<Category> list() {
		String selectActiveCategory = "From Category WHERE active=:active";
		
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active",true);
		
		return query.getResultList();
	}

	/* getting single category based on id */

	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class,
				Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {

			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * 
	 * update a single category
	 */
	@Override
	public boolean update(Category category) {
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
