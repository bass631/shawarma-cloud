package ru.shawarmacloud.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shawarmacloud.model.ShawarmaOrder;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<ShawarmaOrder, UUID> {
    List<ShawarmaOrder> findByDeliveryCity(String deliveryCity);
    List<ShawarmaOrder> readOrderByDeliveryCityAndPlaceAtBetween(String deliveryCity, Date startDate, Date endDate);
    List<ShawarmaOrder> getOrderByDeliveryName(String deliveryName);

    int countOrderByDeliveryCityAndPlaceAtAfter(String deliveryCity, Date date);
}
