package com.netcracker.app.domain.tariffs.entities;


import javax.persistence.*;

@Entity
@Table(name = "Tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private float priceOfMonth;
    private float minutes;
    private float sms;
    private float gbOfInternet;

}
