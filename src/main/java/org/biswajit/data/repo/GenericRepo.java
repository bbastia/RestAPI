package org.biswajit.data.repo;

import java.util.List;

public interface GenericRepo<E> {
	public E getUserbyId(int id);
	
	public void saveOrUpdateUser(E e);
	
	public void deleteUser(int id);
	
	public List<E> getListUser();
	
}
