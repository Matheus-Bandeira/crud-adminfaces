package br.com.karanalpe.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;

	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("crudPU");
	}

	@Produces
	@RequestScoped
	public EntityManager createentityManager() {
		return this.factory.createEntityManager();
	}

	public void closeEntitymanager(@Disposes EntityManager manager) {
		manager.close();
	}
}
