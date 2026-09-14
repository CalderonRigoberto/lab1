package com.rigocalderon.lab1;

import jakarta.persistence.*;

@Table(name = "events", catalog ="railway" , schema ="public")
@Entity
public class Event {
    @Id
    private Long id;

    @Column(name = "available_stock")
    private Long availableStock;

    @Version
    private Integer version;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(Long availableStock) {
        this.availableStock = availableStock;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
