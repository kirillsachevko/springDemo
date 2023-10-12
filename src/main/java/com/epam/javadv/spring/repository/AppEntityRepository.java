package com.epam.javadv.spring.repository;

import com.epam.javadv.spring.persistance.AppEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppEntityRepository extends CrudRepository<AppEntity, Long> {
}
