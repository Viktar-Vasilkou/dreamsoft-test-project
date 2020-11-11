package com.dreamsoft.vasilkou.test_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "search_history")
@NoArgsConstructor
@AllArgsConstructor
public class SearchItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(name = "time")
    private Date time;

    @Column(name = "file_path")
    private String file;

    @Column(name = "word")
    private String word;
}
