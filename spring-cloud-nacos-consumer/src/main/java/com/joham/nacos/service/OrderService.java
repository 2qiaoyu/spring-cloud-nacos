package com.joham.nacos.service;

import com.joham.nacos.RemoteClient;
import com.joham.nacos.entity.Order;
import com.joham.nacos.repository.OrderDAO;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author joham
 */
@Service
public class OrderService {

    @Autowired
    private RemoteClient remoteClient;

    @Autowired
    private OrderDAO orderDAO;

    @GlobalTransactional
    public void create(String userId, String commodityCode, Integer count) {

        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderDAO.save(order);

        remoteClient.debit(userId, orderMoney);
    }

}
