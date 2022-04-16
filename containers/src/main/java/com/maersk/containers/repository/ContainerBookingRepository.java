package com.maersk.containers.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.maersk.containers.entity.BookingEntity;

import java.util.UUID;

@Repository
public interface ContainerBookingRepository extends CassandraRepository<BookingEntity, UUID>{

}
