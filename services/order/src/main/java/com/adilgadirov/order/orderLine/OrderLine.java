package com.adilgadirov.order.orderLine;

import com.adilgadirov.order.order.Order;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private String productId;
    private double quantity;
}
