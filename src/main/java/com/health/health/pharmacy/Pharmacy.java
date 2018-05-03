package com.health.health.pharmacy;

import com.health.health.area.Area;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by jdms3112 on 5/2/2018.
 */
@Data
@Entity
@Table(name = "pharmacy")
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private String openFrom;
    private String closeAt;
    private int servedOrders;
    private double rate;
    private double responseTime;
    private float latitude;
    private float longitude;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    private Area area;

    public Pharmacy(String name, String address, String openFrom, String closeAt, Integer servedOrders, double rate, double responseTime, Area area, float latitude, float longitude) {
        this.name = name;
        this.address = address;
        this.openFrom = openFrom;
        this.closeAt = closeAt;
        this.servedOrders = servedOrders;
        this.rate = rate;
        this.responseTime = responseTime;
        this.area = area;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
