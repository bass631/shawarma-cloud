package ru.shawarmacloud.repository;

import ru.shawarmacloud.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
