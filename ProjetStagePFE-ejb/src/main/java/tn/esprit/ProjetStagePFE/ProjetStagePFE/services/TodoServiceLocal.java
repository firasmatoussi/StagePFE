package tn.esprit.ProjetStagePFE.ProjetStagePFE.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.ProjetStagePFE.ProjetStagePFE.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
