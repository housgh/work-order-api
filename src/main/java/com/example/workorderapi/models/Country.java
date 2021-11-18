package com.example.workorderapi.models;

import com.example.workorderapi.viewmodels.CountryVM;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 30)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<WorkItem> workItems;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<WorkItem> getWorkItems() {
        return workItems;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addWorkItem(WorkItem workItem) {
        this.workItems.add(workItem);
    }
}
