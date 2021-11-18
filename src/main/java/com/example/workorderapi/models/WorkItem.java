package com.example.workorderapi.models;

import com.example.workorderapi.viewmodels.WorkItemVM;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WorkItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String description;
    private int progress;
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Country country;
    @ManyToOne(cascade = CascadeType.ALL)
    private WorkOrder workOrder;

    public String getDescription() {
        return description;
    }

    public int getProgress() {
        return progress;
    }

    public int getId() {
        return id;
    }

    public Country getCountry() {
        return country;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }
}
