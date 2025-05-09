package com.example.luxuryapi.repository;

import com.example.luxuryapi.еntities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Create order
    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO [Order] " +
                    "(OrderDate, PaymentType, IBAN, [Status], CustomerName, CustomerPhone, CustomerEmail, CustomerAddress) " +
                    "VALUES (SYSDATETIME(), :paymentType, :iban, :status, :customerName, :customerPhone, :customerEmail, :customerAddress)",
            nativeQuery = true
    )
    int insertOrder(
            @Param("paymentType")     String paymentType,
            @Param("iban")            String iban,
            @Param("status")          String status,
            @Param("customerName")    String customerName,
            @Param("customerPhone")   String customerPhone,
            @Param("customerEmail")   String customerEmail,
            @Param("customerAddress") String customerAddress
    );

    // Return all orders for customer by customer name
    @Query(value = """
    SELECT ord.* FROM [Order] ord
    LEFT JOIN OrderDetails ordde ON ord.OrderID = ordde.Order_id
    WHERE ord.CustomerName = :custName
    """, nativeQuery = true)
    List<Object[]> getAllOrdersForCustomerNative(@Param("custName") Long custName);

    // Delete order by orderId
    @Query(value = """
    DELETE FROM [Order] WHERE OrderID = :orderId
    """, nativeQuery = true)
    List<Object[]> deleteOrderByOrderIdNative(@Param("orderId") Long orderId);
}
