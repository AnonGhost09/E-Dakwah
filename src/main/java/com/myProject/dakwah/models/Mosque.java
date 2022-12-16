package com.myProject.dakwah.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_mosque")
public class Mosque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mosque_id")
    private Integer mosqueId;
    @Column(name = "name")
    private String name;
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lng")
    private Double lng;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "mosque",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Kajian> kajians;

    public Integer getMosqueId() {
        return mosqueId;
    }

    public void setMosqueId(Integer mosqueId) {
        this.mosqueId = mosqueId;
    }

    public List<Kajian> getKajians() {
        return kajians;
    }

    public void setKajians(List<Kajian> kajians) {
        this.kajians = kajians;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
