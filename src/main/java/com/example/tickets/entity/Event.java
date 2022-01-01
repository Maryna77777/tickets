package com.example.tickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "TITLE")
    private String title;
    @Column (name = "DATA")
    private Date data;
//    private String data;
    @Column (name = "PRICE")
    private int price;
    @Column (name = "AVAILABLE")
    private int available;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "event_customer",
            joinColumns = @JoinColumn(name = "EVENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID")
    )
    private List<Customer> customers;

    @JsonIgnore

    @OneToMany(mappedBy="event",cascade=CascadeType.ALL )
    private List<Sale> sales;

    public void setCustomer(Customer customer) {
    }

}
