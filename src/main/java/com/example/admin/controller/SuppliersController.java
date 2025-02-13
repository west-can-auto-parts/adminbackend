package com.example.admin.controller;

import com.example.admin.dto.SuppliersResponse;
import com.example.admin.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/api/suppliers")
@CrossOrigin(origins = "*")
public class SuppliersController {

    @Autowired
    private SuppliersService suppliersService;

    @GetMapping("/all")
    public ResponseEntity<List<SuppliersResponse>> getAllSuppliers(){
        List<SuppliersResponse> suppliersResponses=suppliersService.getAll();
        return ResponseEntity.ok().body(suppliersResponses);
    }

}
