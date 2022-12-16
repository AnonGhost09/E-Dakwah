package com.myProject.dakwah.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_expertise")
public class Expertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expertise_id")
    private Integer expertiseId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "expertise", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Preacher> preacher;

    public Integer getExpertiseId() {
        return expertiseId;
    }

    public void setExpertiseId(Integer expertiseId) {
        this.expertiseId = expertiseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Preacher> getPreacher() {
        return preacher;
    }

    public void setPreacher(List<Preacher> preacher) {
        this.preacher = preacher;
    }
}
