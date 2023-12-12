package com.kkotto.kkottoshelper.model.free_dictionary.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "meaning")
public class MeaningDao {
    @Id
    private Long id;
    @Column(name = "part_of_speech")
    private String partOfSpeech;
    @OneToMany
    @JoinColumn(name = "id")
    private List<DefinitionDao> definitionList;
}
