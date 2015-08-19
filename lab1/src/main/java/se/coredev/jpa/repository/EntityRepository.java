package se.coredev.jpa.repository;

import se.coredev.jpa.model.AbstractEntity;

public interface EntityRepository<E extends AbstractEntity> {

	void saveOrUpdate(E entity);

	void remove(E entity);

	E findById(Long id);
}
