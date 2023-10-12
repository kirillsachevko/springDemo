package com.epam.javadv.spring.persistance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "app_entity")
@Data
@NoArgsConstructor
public class AppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String property;

    public AppEntity(String name, String property) {
        this.name = name;
        this.property = property;
    }
}
