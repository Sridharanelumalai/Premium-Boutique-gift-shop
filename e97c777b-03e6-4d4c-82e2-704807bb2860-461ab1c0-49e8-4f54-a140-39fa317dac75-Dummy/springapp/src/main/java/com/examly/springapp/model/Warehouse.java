package com.examly.springapp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    private String name;

    private String location;

    @OneToMany(mappedBy = "warehouse")
    private List<StockEntry> stockEntries;

    @OneToMany(mappedBy = "warehouse")
    private List<StockMovement> movements;

    // Constructors
    public Warehouse() {}

    public Warehouse(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters and Setters
    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<StockEntry> getStockEntries() {
        return stockEntries;
    }

    public void setStockEntries(List<StockEntry> stockEntries) {
        this.stockEntries = stockEntries;
    }

    public List<StockMovement> getMovements() {
        return movements;
    }

    public void setMovements(List<StockMovement> movements) {
        this.movements = movements;
    }
}
