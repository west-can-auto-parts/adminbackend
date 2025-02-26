package com.example.admin.service;

import com.example.admin.dto.SupplierDtoRequest;
import com.example.admin.dto.SuppliersResponse;

import java.util.List;

public interface SuppliersService {
    public List<SuppliersResponse> getAll();
    public SuppliersResponse createSupplier(SupplierDtoRequest supplierDtoRequest);
    public SuppliersResponse updateSupplier(SupplierDtoRequest supplierDtoRequest);
    public SuppliersResponse getById(String id);
    public String deleteById(String id);
}
