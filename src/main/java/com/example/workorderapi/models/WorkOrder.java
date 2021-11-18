package com.example.workorderapi.models;

import com.example.workorderapi.viewmodels.WorkOrderVM;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 30)
    private String description;
    private int completionPercentage;
    private String creationDate;
    private String startDate;
    private String endDate;
    @OneToMany(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<WorkItem> workItems;

    public WorkOrder(){
        workItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getCompletionPercentage() {
        return completionPercentage;
    }

    public List<WorkItem> getWorkItems() {
        return workItems;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompletionPercentage(int completionPercentage) {
        this.completionPercentage = completionPercentage;
    }

    public void addWorkItem(WorkItem workItem) {
        this.workItems.add(workItem);
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setWorkItems(List<WorkItem> workItems) {
        this.workItems = workItems;
    }
}
