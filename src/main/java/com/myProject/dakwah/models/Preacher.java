package com.myProject.dakwah.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_preacher")
public class Preacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preacher_id")
    private Integer preacherId;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_birth")
    private Date dateBirth;

    @Column(name = "place_birth")
    private String placeBirth;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "expertise_id")
    @JsonIgnore
    private Expertise expertise;

    @OneToMany(mappedBy = "preacher")
    @JsonIgnore
    private List<KajianSchedule> kajianSchedule;

    public List<KajianSchedule> getKajianSchedule() {
        return kajianSchedule;
    }

    public void setKajianSchedule(List<KajianSchedule> kajianSchedule) {
        this.kajianSchedule = kajianSchedule;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Expertise getExpertise() {
        return expertise;
    }

    public void setExpertise(Expertise expertise) {
        this.expertise = expertise;
    }

    public Integer getPreacherId() {
        return preacherId;
    }

    public void setPreacherId(Integer preacherId) {
        this.preacherId = preacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPlaceBirth() {
        return placeBirth;
    }

    public void setPlaceBirth(String placeBirth) {
        this.placeBirth = placeBirth;
    }
}
