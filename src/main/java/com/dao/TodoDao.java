package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entities.Todo;

@Repository
public class TodoDao {
	
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	public int save(Todo t) {
		Integer save = (Integer)this.hibernateTemplate.save(t);
		
		return save;
	}
	
	public List<Todo> getAll(){
		
		return this.hibernateTemplate.loadAll(Todo.class);
	}


}
