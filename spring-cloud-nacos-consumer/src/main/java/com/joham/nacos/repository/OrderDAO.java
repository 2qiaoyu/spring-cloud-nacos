package com.joham.nacos.repository;


import com.joham.nacos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joham
 */
public interface OrderDAO extends JpaRepository<Order, Long> {

}
