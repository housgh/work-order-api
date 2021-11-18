package com.example.workorderapi.viewmodels;

import com.example.workorderapi.models.WorkItem;
import com.example.workorderapi.models.WorkOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class WorkOrderVM {

    public WorkOrderVM(){}

    private int id;
    private String description;
    private int progress;
    private List<WorkItemVM> workItems;
    private String startDate;
    private String endDate;
    private String creationDate;


    public int getId() {
        return id;
    }

    public int getProgress() {
        return progress;
    }

    public String getDescription() {
        return description;
    }

    public List<WorkItemVM> getWorkItems() {
        return workItems;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setWorkItems(List<WorkItemVM> workItems) {
        this.workItems = workItems;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
