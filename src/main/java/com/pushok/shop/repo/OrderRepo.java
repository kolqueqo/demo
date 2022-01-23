package com.pushok.shop.repo;


import com.pushok.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
