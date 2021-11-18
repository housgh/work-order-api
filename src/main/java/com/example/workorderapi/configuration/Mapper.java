package com.example.workorderapi.configuration;

import com.example.workorderapi.models.Country;
import com.example.workorderapi.models.WorkItem;
import com.example.workorderapi.models.WorkOrder;
import com.example.workorderapi.repositories.CountryRepository;
import com.example.workorderapi.repositories.WorkItemRepository;
import com.example.workorderapi.repositories.WorkOrderRepository;
import com.example.workorderapi.viewmodels.CountryVM;
import com.example.workorderapi.viewmodels.WorkItemVM;
import com.example.workorderapi.viewmodels.WorkOrderVM;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-03-11T19:21:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class Mapper implements IMapper {

    private WorkOrderRepository workOrderRepository;
    private CountryRepository countryRepository;
    private WorkItemRepository workItemRepository;

    public Mapper(WorkItemRepository workItemRepository, CountryRepository countryRepository, WorkOrderRepository workOrderRepository) {
        this.workItemRepository = workItemRepository;
        this.countryRepository = countryRepository;
        this.workOrderRepository = workOrderRepository;
    }

    @Override
    public WorkOrder workOrderVMToWorkOrder(WorkOrderVM workOrderVM) {
        var workOrder = workOrderRepository.findById(workOrderVM.getId()).orElse(new WorkOrder());
        workOrder.setId(workOrderVM.getId());
        workOrder.setDescription(workOrderVM.getDescription());
        workOrder.setCompletionPercentage(workOrderVM.getProgress());
        workOrder.setStartDate(workOrderVM.getStartDate());
        workOrder.setEndDate(workOrderVM.getEndDate());
        workOrder.setCreationDate(workOrderVM.getCreationDate());
        workOrder.setWorkItems(workItemVMListToWorkItemList(workOrderVM.getWorkItems()));
        return workOrder;
    }

    @Override
    public List<WorkItem> workItemVMListToWorkItemList(List<WorkItemVM> workItemVMList) {
        List<WorkItem> workItems = new ArrayList<>();
        for (var workItem : workItemVMList) {
            workItems.add(workItemVMToWorkItem(workItem));
        }
        return workItems;
    }

    @Override
    public WorkItem workItemVMToWorkItem(WorkItemVM workItemVM) {
        var workItem = workItemRepository.findById(workItemVM.getId()).orElse(new WorkItem());
        workItem.setId(workItemVM.getId());
        workItem.setDescription(workItemVM.getDescription());
        workItem.setCountry(countryVMToCountry(workItemVM.getCountry()));
        workItem.setProgress(workItemVM.getProgress());
        return workItem;
    }

    @Override
    public Country countryVMToCountry(CountryVM countryVM) {
        var country = countryRepository.findById(countryVM.getId()).orElse(new Country());
        country.setId(countryVM.getId());
        country.setName(countryVM.getName());
        return country;
    }

    @Override
    public WorkOrderVM workOrderToWorkOrderVM(WorkOrder workOrder) {
        var workOrderVM = new WorkOrderVM();
        workOrderVM.setId(workOrder.getId());
        workOrderVM.setDescription(workOrder.getDescription());
        workOrderVM.setProgress(workOrder.getCompletionPercentage());
        workOrderVM.setStartDate(workOrder.getStartDate());
        workOrderVM.setEndDate(workOrder.getEndDate());
        workOrderVM.setCreationDate(workOrder.getCreationDate());
        workOrderVM.setWorkItems(workItemListToWorkItemListVM(workOrder.getWorkItems()));
        return workOrderVM;
    }

    @Override
    public List<WorkItemVM> workItemListToWorkItemListVM(List<WorkItem> workItemList) {
        List<WorkItemVM> workItemVMs = new ArrayList<>();
        for (var workItem : workItemList) {
            workItemVMs.add(workItemToWorkItemVM(workItem));
        }
        return workItemVMs;
    }

    @Override
    public WorkItemVM workItemToWorkItemVM(WorkItem workItem) {
        var workItemVM = new WorkItemVM();
        workItemVM.setId(workItem.getId());
        workItemVM.setDescription(workItem.getDescription());
        workItemVM.setCountry(countryToCountryVM(workItem.getCountry()));
        workItemVM.setProgress(workItem.getProgress());
        return workItemVM;
    }

    @Override
    public CountryVM countryToCountryVM(Country country) {
        var countryVM = new CountryVM();
        countryVM.setId(country.getId());
        countryVM.setName(country.getName());
        return countryVM;
    }
}
