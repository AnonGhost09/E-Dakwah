package com.myProject.dakwah.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_kajian")
public class Kajian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kajian_id")
    private Integer kajianId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mosque_id")
    @JsonIgnoreProperties("kajians")
    private Mosque mosque;

    @OneToMany(mappedBy = "kajian",cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("kajian")
    private List<KajianSchedule> kajianSchedules;

    public List<KajianSchedule> getKajianSchedules() {
        return kajianSchedules;
    }

    public void setKajianSchedules(List<KajianSchedule> kajianSchedules) {
        this.kajianSchedules = kajianSchedules;
    }

    @Column(name = "description")
    private String description;

    public Integer getKajianId() {
        return kajianId;
    }

    public void setKajianId(Integer kajianId) {
        this.kajianId = kajianId;
    }

    public Mosque getMosque() {
        return mosque;
    }

    public void setMosque(Mosque mosque) {
        this.mosque = mosque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
