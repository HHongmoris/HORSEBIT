package com.a406.horsebit.service;

import com.a406.horsebit.domain.redis.Order;
import com.a406.horsebit.repository.redis.OrderRepository;
import com.a406.horsebit.repository.redis.PriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrderServiceImplTest {
    OrderService orderService;
    OrderRepository orderRepository;

    @Autowired
    OrderServiceImplTest(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @Test
    void newOrders() {
    }

    @Test
    void processBuyOrder() {
        List<Long> prices = new ArrayList<>();
        prices.add(10L);
        prices.add(20L);
        prices.add(30L);
        prices.add(40L);
        List<Double> volumesBuy;
        List<Double> volumesSell;
        orderService.processBuyOrder(1L, 1L, new Order(100000L, 2000.0, 2000.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(120000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(160000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 2100.0, 2100.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(140000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);


        orderService.processBuyOrder(1L, 1L, new Order(100000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(120000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(160000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 10.0, 10.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(140000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);


        orderService.processBuyOrder(1L, 1L, new Order(100000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(120000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(160000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 10.0, 10.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(140000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);


        orderService.processBuyOrder(1L, 1L, new Order(100000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(120000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(160000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 10.0, 10.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(140000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);


        orderService.processBuyOrder(1L, 1L, new Order(100000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(120000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(160000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 10.0, 10.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(140000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);


        orderService.processBuyOrder(1L, 1L, new Order(100000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(120000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processBuyOrder(1L, 1L, new Order(160000L, 20.0, 20.0, "B"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 10.0, 10.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(100000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
        orderService.processSellOrder(2L, 1L, new Order(140000L, 20.0, 20.0, "S"));
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
    }

    @Test
    void testOrder() {
        orderService.processBuyOrder(1L, 1L, new Order(300000L, 4000.0, 4000.0, "B"));

        List<Long> prices = new ArrayList<>();
        prices.add(10L);
        prices.add(20L);
        prices.add(30L);
        prices.add(40L);
        List<Double> volumesBuy;
        List<Double> volumesSell;
        volumesBuy = orderRepository.findBuyVolumeByPriceAtOrderBook(1L, prices);
        volumesSell = orderRepository.findSellVolumeByPriceAtOrderBook(1L, prices);
        volumesBuy.get(0);
        volumesSell.get(0);
    }
}
