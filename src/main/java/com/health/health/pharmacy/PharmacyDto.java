package com.health.health.pharmacy;

import com.health.health.area.Area;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by jdms3112 on 5/2/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PharmacyDto {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String address;
    private String openFrom;
    private String closeAt;
    private Integer servedOrders;
    private double rate;
    private double responseTime;
    private Integer areaId;
    private float latitude;
    private float longitude;

    Pharmacy convertToPharmacy() {
        Area area = new Area();
        if (this.getAreaId() != null) {
            area.setId(this.areaId);
        }
        return new Pharmacy(this.name, this.address, this.openFrom, this.closeAt, this.servedOrders, this.rate, this.responseTime, area, this.latitude, this.longitude);
    }
}
