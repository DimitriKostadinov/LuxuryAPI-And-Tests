package com.example.luxuryapi.еntities;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailId implements Serializable {

    private Integer Order_id;   // same as column Order_id
    private Integer ItemID;    // same as column ItemID

    public OrderDetailId() { }

    public OrderDetailId(Integer orderId, Integer itemId) {
        this.Order_id = orderId;
        this.ItemID = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetailId)) return false;
        OrderDetailId that = (OrderDetailId) o;
        return Objects.equals(Order_id, that.Order_id) &&
                Objects.equals(ItemID, that.ItemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Order_id, ItemID);
    }
}
