package com.ankur.demo.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.ankur.demo.data.entity.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long>{

}
