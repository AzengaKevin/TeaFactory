package com.propscout.teafactory.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "centers")
public class Center {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "center")
    private List<Account> accounts = new ArrayList<>();

    public Center() {
    }

    public Center(String name) {
        this.name = name;
    }

    public Center(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
