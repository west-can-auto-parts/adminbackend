package com.example.admin.controller;

import com.example.admin.dto.SupplierDtoRequest;
import com.example.admin.dto.SuppliersResponse;
import com.example.admin.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api/suppliers")
@CrossOrigin(origins = "*")
public class SuppliersController {

    @Autowired
    private SuppliersService suppliersService;

    @GetMapping("/all")
    public ResponseEntity<List<SuppliersResponse>> getAllSuppliers(){
        List<SuppliersResponse> suppliersResponses=suppliersService.getAll();
        return ResponseEntity.ok().body(suppliersResponses);
    }

    @PostMapping("/create")
    public ResponseEntity<SuppliersResponse> createSupplier(@RequestBody SupplierDtoRequest request) {
        SuppliersResponse supplier = suppliersService.createSupplier(request);
        return ResponseEntity.ok(supplier);
    }

    @PutMapping("/update")
    public ResponseEntity<SuppliersResponse> updateSupplier(@RequestBody SupplierDtoRequest request) {
        SuppliersResponse supplier = suppliersService.updateSupplier(request);
        return ResponseEntity.ok(supplier);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SuppliersResponse> getSuppliersById(@PathVariable ("id") String id){
        SuppliersResponse suppliersResponses=suppliersService.getById(id);
        return ResponseEntity.ok().body(suppliersResponses);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductCategoryById(@PathVariable ("id") String id){
        String responses =suppliersService.deleteById(id);
        return ResponseEntity.ok().body(responses);
    }

}
