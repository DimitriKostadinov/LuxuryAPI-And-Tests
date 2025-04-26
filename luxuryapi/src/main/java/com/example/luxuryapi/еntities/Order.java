package com.example.luxuryapi.еntities;

import jakarta.persistence.*;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Long OrderID;

    @Column(name = "OrderDate")
    private String OrderDate;

    @Column(name = "PaymentType")
    private String PaymentType;

    @Column(name = "IBAN")
    private String IBAN;

    @Column(name = "Status")
    private String Status;

    @Column(name = "CustomerName")
    private String CustomerName;

    @Column(name = "CustomerPhone")
    private String CustomerPhone;

    @Column(name = "CustomerEmail")
    private String CustomerEmail;

    @Column(name = "CustomerAddress")
    private String CustomerAddress;

    public Long getOrderID() {
        return OrderID;
    }

    public void setOrderID(Long orderID) {
        OrderID = orderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

}
