package com.kkotto.kkottoshelper.model.free_dictionary.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "definition")
public class DefinitionDao {
    @Id
    private Long id;
    @Column(name = "definition")
    private String definition;
    @Column(name = "example")
    private String example;
    @Column(name = "synonyms")
    private String synonyms;
    @Column(name = "antonyms")
    private String antonyms;
}
