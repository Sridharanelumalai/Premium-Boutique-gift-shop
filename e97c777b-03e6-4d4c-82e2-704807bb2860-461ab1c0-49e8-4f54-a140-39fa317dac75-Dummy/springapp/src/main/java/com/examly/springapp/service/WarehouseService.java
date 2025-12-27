package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Warehouse;

public interface WarehouseService {
    public Warehouse addWarehouse(Warehouse warehouse);
    public List<Warehouse> getAllWarehouses();
    public Warehouse getWarehouseById(Long id);
    public Warehouse updateWarehouse(Warehouse warehouse, Long id);
    public List<Warehouse> getWarehousesByLocation(String location);
    public List<Warehouse> getWarehousesByLocationAndName(String location, String name);
    
}
