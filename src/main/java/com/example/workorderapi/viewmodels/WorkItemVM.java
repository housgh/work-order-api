package com.example.workorderapi.viewmodels;

import com.example.workorderapi.models.WorkItem;
import com.example.workorderapi.models.WorkOrder;

import java.util.Date;

public class WorkItemVM {
    private int id;
    private String description;
    private int progress;
    private CountryVM country;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getProgress() {
        return progress;
    }

    public CountryVM getCountry() {
        return country;
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

    public void setCountry(CountryVM country) {
        this.country = country;
    }
}
