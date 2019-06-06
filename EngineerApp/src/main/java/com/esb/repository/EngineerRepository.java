package com.esb.repository;

import com.esb.entity.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineerRepository extends JpaRepository<Engineer, Long> {
    Engineer findByAvailable(String available);
    Engineer findFirst1ByAvailable(String available);

}
