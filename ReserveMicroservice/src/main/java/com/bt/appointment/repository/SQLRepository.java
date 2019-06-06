package com.bt.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bt.appointment.model.Appointment;



@Repository
public interface SQLRepository extends JpaRepository<Appointment, String> {

}
