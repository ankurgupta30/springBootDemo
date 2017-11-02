package com.ankur.demo.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ankur.demo.data.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
	Room findByNumber(String number);
}
