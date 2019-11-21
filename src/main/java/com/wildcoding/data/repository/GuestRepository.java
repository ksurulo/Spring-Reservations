package com.wildcoding.data.repository;

import com.wildcoding.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

}