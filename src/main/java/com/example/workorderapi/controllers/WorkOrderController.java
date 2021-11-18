package com.example.workorderapi.controllers;

import com.example.workorderapi.configuration.IMapper;
import com.example.workorderapi.models.WorkItem;
import com.example.workorderapi.models.WorkOrder;
import com.example.workorderapi.repositories.CountryRepository;
import com.example.workorderapi.repositories.WorkOrderRepository;
import com.example.workorderapi.viewmodels.WorkOrderVM;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/workorder")
public class WorkOrderController {
    private WorkOrderRepository workOrderRepository;
    private CountryRepository countryRepository;
    private IMapper mapper;

    public WorkOrderController(WorkOrderRepository workOrderRepository, CountryRepository countryRepository, IMapper mapper){
        this.workOrderRepository = workOrderRepository;
        this.countryRepository = countryRepository;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<Iterable<WorkOrderVM>> GetAll(){
        var workOrders = workOrderRepository.findAll();
        var workOrdersVM = new ArrayList<WorkOrderVM>();
        for(var workOrder: workOrders){
            workOrdersVM.add(mapper.workOrderToWorkOrderVM(workOrder));
        }
        return new ResponseEntity<>(workOrdersVM, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrderVM> Get(@PathVariable int id){
        WorkOrder workOrder = workOrderRepository.findById(id).orElse(null);
        if(workOrder == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        var workOrderVM = mapper.workOrderToWorkOrderVM(workOrder);
        return new ResponseEntity<>(workOrderVM, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkOrderVM> Create(@RequestBody WorkOrder workOrder){
        int totalCount = workOrder.getWorkItems().size() * 100;
        int totalProgress = 0;
        for (var workItem: workOrder.getWorkItems()){
            totalProgress += workItem.getProgress();
            var country = countryRepository.findById(workItem.getCountry().getId()).orElse(null);
            workItem.setCountry(country);
        }
        if(totalCount != 0){
            workOrder.setCompletionPercentage((int)((totalProgress * 1.0)/(totalCount * 1.0) * 100));
        }
        Locale loc = new Locale("en", "US");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        workOrder.setCreationDate(dateFormat.format(new Date()));
        WorkOrder result = workOrderRepository.save(workOrder);
        return  new ResponseEntity<>(mapper.workOrderToWorkOrderVM(result), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WorkOrderVM> Update(@RequestBody  WorkOrderVM workOrder){
        var objWorkOrder = workOrderRepository.findById(workOrder.getId()).orElse(null);
        if(objWorkOrder == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        var creationDate = objWorkOrder.getCreationDate();
        objWorkOrder = mapper.workOrderVMToWorkOrder(workOrder);
        objWorkOrder.setCreationDate(creationDate);
        int totalCount = objWorkOrder.getWorkItems().size() * 100;
        int totalProgress = 0;
        for (var workItem: objWorkOrder.getWorkItems()){
            totalProgress += workItem.getProgress();
        }
        objWorkOrder.setCompletionPercentage((int)(((totalProgress * 1.0)/(totalCount * 1.0)) * 100));
        WorkOrder result = workOrderRepository.save(objWorkOrder);
        return new ResponseEntity<>(mapper.workOrderToWorkOrderVM(result), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> Delete(@PathVariable  int id){
        var workOrder = workOrderRepository.findById(id).orElse(null);
        if(workOrder == null){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
        workOrderRepository.delete(workOrder);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
