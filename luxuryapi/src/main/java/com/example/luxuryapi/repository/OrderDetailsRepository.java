package com.example.luxuryapi.repository;

import com.example.luxuryapi.еntities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    // Add items to order
    // The nested Select query get the item price from Item
    @Modifying
    @Transactional
    @Query(
            value = """
        INSERT INTO OrderDetails
            (Order_id, ItemID, Price, Quantity)
        SELECT 
            :orderId,
            i.ItemID,
            i.Price, 
            :quantity
        FROM Item i
        WHERE i.ItemID = :itemId
      """,
            nativeQuery = true
    )
    int insertOrderDetailWithPrice(
            @Param("orderId")  Long orderId,
            @Param("itemId")   Long itemId,
            @Param("quantity") int quantity
    );
    // :contentReference[oaicite:2]{index=2}

    // Update iem quantity in order
    @Modifying // show that the query modify data :contentReference[oaicite:2]{index=2}
    @Query(
            value = "UPDATE OrderDetails SET Quantity = :quantity WHERE Order_id = :orderId AND ItemID = :itemId",
            nativeQuery = true
    )
    int updateItemQuantityNative(
            @Param("orderId")  Long orderId,
            @Param("itemId")   Long itemId,
            @Param("quantity") int quantity
    );

    // Delete item in OrderDetails by orderId and ItemID
    @Query(value = """
    DELETE FROM OrderDetails WHERE Order_id = :orderId AND ItemID = :itemId
    """, nativeQuery = true)

    int deleteOrderDetailsNative(
            @Param("orderId")  Long orderId,
            @Param("itemId")   Long itemId
    );
}
