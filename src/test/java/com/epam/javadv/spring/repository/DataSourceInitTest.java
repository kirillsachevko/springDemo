package com.epam.javadv.spring.repository;

import com.epam.javadv.spring.persistance.AppEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@PropertySource("src/main/resources")
public class DataSourceInitTest {

    private static final String DATA_SOURCE_URL = "jdbc:h2:mem:test2";
    private static final String DATA_SOURCE_USERNAME = "root";
    private static final String DATA_SOURCE_PASS = "root";

    private static final String ENTITY_NAME = "testName";
    private static final String ENTITY_PROPERTY = "testProperty";
    @Autowired
    private AppEntityRepository repository;

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        AppEntity entity = new AppEntity(ENTITY_NAME, ENTITY_PROPERTY);
        repository.save(entity);
    }

    @Test
    void shouldReturnEntityFromDataSource() {
        try (Connection connection = DriverManager.getConnection(DATA_SOURCE_URL, DATA_SOURCE_USERNAME, DATA_SOURCE_PASS);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM app_entity";

            ResultSet rs = statement.executeQuery(query);

            AppEntity actualEntity = new AppEntity();

            while (rs.next()) {
                actualEntity.setId(rs.getLong(1));
                actualEntity.setName(rs.getString(2));
                actualEntity.setProperty(rs.getString(3));
            }

            assertEquals(ENTITY_NAME, actualEntity.getName());
            assertEquals(ENTITY_PROPERTY, actualEntity.getProperty());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
