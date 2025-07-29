package com.adilgadirov.order.order;

import com.adilgadirov.order.OrderLineRequest;
import com.adilgadirov.order.orderLine.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.id())
                .quantity(orderLineRequest.quantity())
                .order(
                        Order.builder()
                                .id(orderLineRequest.orderId())
                                .build(
                ))


                .productId(orderLineRequest.productId())

                .build();
    }
}
