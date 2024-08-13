package ru.dbastrygin.shawarmacloud.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dbastrygin.shawarmacloud.model.ShawarmaOrder;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<ShawarmaOrder, Long> {
    List<ShawarmaOrder> findByDeliveryCity(String deliveryCity);
    List<ShawarmaOrder> readOrderByDeliveryCityAndPlaceAtBetween(String deliveryCity, Date startDate, Date endDate);
    List<ShawarmaOrder> getOrderByDeliveryName(String deliveryName);

    int countOrderByDeliveryCityAndPlaceAtAfter(String deliveryCity, Date date);
}
