package com.ankur.demo.data.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ankur.demo.data.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{

	List<Reservation> findByDate(Date date);
}
