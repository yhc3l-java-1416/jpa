package se.coredev.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.coredev.jpa.model.AbstractEntity;

public abstract class AbstractRepository<E extends AbstractEntity> implements EntityRepository<E> {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	private final Class<E> entityClass;

	protected AbstractRepository(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public void saveOrUpdate(E entity) {
		
		if (entity.getId() == null) {
			execute(manager -> {
				manager.persist(entity);
			});
		}
		else {
			execute(manager -> {
				manager.merge(entity);
			});
		}
	}

	public E findById(Long id) {
		return execute(manager -> {
			return manager.find(entityClass, id);
		});
	}

	@Override
	public void remove(E entity) {
		execute(manager -> {
			manager.remove(entity);
			return null;
		});
	}

	private void execute(Operation operation) {

		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			operation.execute(manager);
			manager.getTransaction().commit();
		}
		finally {
			manager.close();
		}
	}

	private E execute(Query<E> query) {
		EntityManager manager = factory.createEntityManager();
		try {
			return query.execute(manager);
		}
		finally {
			manager.close();
		}
	}

	/**
	 * 
	 * @author coredev
	 *
	 * @param <E>
	 */
	protected static interface Query<E> {
		E execute(EntityManager manager);
	}

	/**
	 * 
	 * @author coredev
	 *
	 */
	protected static interface Operation {
		void execute(EntityManager manager);
	}
}
