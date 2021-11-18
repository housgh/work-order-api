package com.example.workorderapi.configuration;

import com.example.workorderapi.models.Country;
import com.example.workorderapi.models.WorkItem;
import com.example.workorderapi.models.WorkOrder;
import com.example.workorderapi.viewmodels.CountryVM;
import com.example.workorderapi.viewmodels.WorkItemVM;
import com.example.workorderapi.viewmodels.WorkOrderVM;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface IMapper {
    WorkOrder workOrderVMToWorkOrder(WorkOrderVM workOrderVM);
    List<WorkItem> workItemVMListToWorkItemList(List<WorkItemVM> workItemVMList);
    WorkItem workItemVMToWorkItem(WorkItemVM workItemVM);
    Country countryVMToCountry(CountryVM countryVM);

    WorkOrderVM workOrderToWorkOrderVM(WorkOrder workOrder);
    List<WorkItemVM> workItemListToWorkItemListVM(List<WorkItem> workItemList);
    WorkItemVM workItemToWorkItemVM(WorkItem workItem);
    CountryVM countryToCountryVM(Country country);
}
