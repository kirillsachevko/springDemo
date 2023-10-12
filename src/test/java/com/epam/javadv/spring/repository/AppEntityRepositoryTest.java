package com.epam.javadv.spring.repository;

import com.epam.javadv.spring.persistance.AppEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AppEntityRepositoryTest {

    private final AppEntity TEST_ENTITY = new AppEntity("name", "property");

    @Autowired
    private AppEntityRepository repository;

    @Test
    void shouldSaveEntityIntoDb() {
        AppEntity savedEntity = repository.save(TEST_ENTITY);

        assertEquals(TEST_ENTITY.getName(), savedEntity.getName());
        assertEquals(TEST_ENTITY.getProperty(), savedEntity.getProperty());
    }
}
