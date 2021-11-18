package com.example.workorderapi.repositories;


import com.example.workorderapi.models.WorkOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepository extends CrudRepository<WorkOrder, Integer> {
}
