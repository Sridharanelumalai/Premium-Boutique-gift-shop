package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Warehouse;
import com.examly.springapp.service.WarehouseService;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {
    private final WarehouseService wareserv;
    public WarehouseController(WarehouseService wareserv){
        this.wareserv=wareserv;
    }
    @PostMapping
    public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse warehouse){
        return ResponseEntity.status(201).body(wareserv.addWarehouse(warehouse));
    }
    
    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses(){
        return ResponseEntity.ok(wareserv.getAllWarehouses());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id){
        return ResponseEntity.ok(wareserv.getWarehouseById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@RequestBody Warehouse warehouse, @PathVariable Long id){
        return ResponseEntity.ok(wareserv.updateWarehouse(warehouse, id));
    }
    @GetMapping("/location/{location}")
    public ResponseEntity<?> getWarehousesByLocation(@PathVariable String location){
        List<Warehouse> warehousesByLocation=wareserv.getWarehousesByLocation(location);
        if(warehousesByLocation.isEmpty())
            return ResponseEntity.status(204).body("No warehouses found at location: "+location);
        return ResponseEntity.ok(warehousesByLocation);
    }
    @GetMapping("/location/{location}/name/{name}")
    public ResponseEntity<List<Warehouse>> getWarehousesByLocationAndName(@PathVariable String location, @PathVariable String name){
        return ResponseEntity.ok(wareserv.getWarehousesByLocationAndName(location, name));
    }
}
