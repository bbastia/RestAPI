package org.biswajit.data.repo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.biswajit.data.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}

	protected Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
	
	@Override
	public User getUserbyId(int id) {
		User user=getSession().get(User.class, id);
		return user;
	}

	@Override
	public void saveOrUpdateUser(User user) {
		getSession().saveOrUpdate(user);
	}

	@Override
	public void deleteUser(int id) {
		User user=getSession().get(User.class, id);
		getSession().delete(user);
	}

	@Override
	public List<User> getListUser() {
	//	CriteriaQuery criteria=getSession().createCriteria(User.class);
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery( User.class );
		//return (List<User>) criteria.list();
		 Root<User> root = query.from(User.class);
         query.select(root);
         Query<User> q=getSession().createQuery(query);
         List<User> users=q.getResultList();
		return users;
	}

}
