package com.stefanini.repository;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Denuncia;

@Dependent
public class DenunciaRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Denuncia denuncia) {
		this.manager.persist(denuncia);
	}

	public void altera(Denuncia denuncia) {
		this.manager.merge(denuncia);
	}

	public Denuncia busca(Integer id) {
		return this.manager.find(Denuncia.class, id);
	}

	public List<Denuncia> lista() {
		return this.manager.createQuery("select c from Denuncia c", Denuncia.class).getResultList();
	}
}




