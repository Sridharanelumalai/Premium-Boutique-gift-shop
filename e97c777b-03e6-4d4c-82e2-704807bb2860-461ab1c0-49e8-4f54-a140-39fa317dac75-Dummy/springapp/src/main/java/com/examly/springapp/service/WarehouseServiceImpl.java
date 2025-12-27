package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Warehouse;
import com.examly.springapp.repository.WarehouseRepo;
@Service
public class WarehouseServiceImpl implements WarehouseService{
    private final WarehouseRepo warerepo;
    public WarehouseServiceImpl(WarehouseRepo warerepo){
        this.warerepo=warerepo;
    }
    public Warehouse addWarehouse(Warehouse warehouse){
        return warerepo.save(warehouse);
    }
    public List<Warehouse> getAllWarehouses(){
        return warerepo.findAll();
    }
    public Warehouse getWarehouseById(Long id){
        return warerepo.findById(id).orElse(null);
    }
    public Warehouse updateWarehouse(Warehouse warehouse, Long id){
        Warehouse toBeUpdated=getWarehouseById(id);
        if(toBeUpdated==null)
            return null;
        toBeUpdated.setLocation(warehouse.getLocation());
        toBeUpdated.setMovements(warehouse.getMovements());
        toBeUpdated.setName(warehouse.getName());
        toBeUpdated.setStockEntries(warehouse.getStockEntries());
        return warerepo.save(toBeUpdated);
    }

    public List<Warehouse> getWarehousesByLocation(String location){
        return warerepo.findByLocation(location);
    }
    public List<Warehouse> getWarehousesByLocationAndName(String location, String name){
        return warerepo.findByLocationAndName(location,name);
    }
}
