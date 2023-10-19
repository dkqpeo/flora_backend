package com.flora.repository;

import com.flora.entity.OrderEntity;
import com.flora.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
