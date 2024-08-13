package ru.dbastrygin.shawarmacloud.repository;

import ru.dbastrygin.shawarmacloud.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
