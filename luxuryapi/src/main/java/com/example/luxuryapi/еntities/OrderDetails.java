package com.example.luxuryapi.еntities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "OrderDetails")
@IdClass(OrderDetailId.class)
public class OrderDetails {

    @Id
    @Column(name = "Order_id", nullable = false)
    private Integer Order_id;          // PK и FK към Order :contentReference[oaicite:14]{index=14}

    @Id
    @Column(name = "ItemID", nullable = false)
    private Integer ItemID;           // PK и FK към Item :contentReference[oaicite:15]{index=15}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_id", insertable = false, updatable = false)
    private Order order;              // асоциация към Order без повторно писане на FK :contentReference[oaicite:16]{index=16}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ItemID", insertable = false, updatable = false)
    private Item item;               // асоциация към Item без повторно писане на FK :contentReference[oaicite:17]{index=17}

    @Column(name = "Price",precision = 18, scale = 2)
    private BigDecimal Price;

    @Column(name = "Quantity")
    private int Quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }


    public Integer getOrderId() {
        return Order_id;
    }

    public void setOrderId(Integer orderId) {
        this.Order_id = Order_id;
    }

    public Integer getItemId() {
        return ItemID;
    }

    public void setItemId(Integer itemId) {
        this.ItemID = ItemID;
    }

}
