package com.example.workorderapi.repositories;

import com.example.workorderapi.models.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkItemRepository extends JpaRepository<WorkItem, Integer> {
}
