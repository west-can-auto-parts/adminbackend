package com.example.admin.service.implementation;

import com.example.admin.dto.SupplierDtoRequest;
import com.example.admin.dto.SuppliersResponse;
import com.example.admin.entity.SuppliersDocument;
import com.example.admin.repository.SuppliersRepository;
import com.example.admin.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuppliersServiceImpl implements SuppliersService {

    @Autowired
    private SuppliersRepository suppliersRepository;

    @Override
    public List<SuppliersResponse> getAll () {
        List<SuppliersDocument> suppliersDocumentList=suppliersRepository.findAll();
        return suppliersDocumentList.stream().map(supplier -> new SuppliersResponse(supplier.getId(),supplier.getName()
                , supplier.getDescription(),supplier.getImageUrl())).collect(Collectors.toList());
    }

    @Override
    public SuppliersResponse createSupplier(SupplierDtoRequest supplierDtoRequest) {
        SuppliersDocument supplier = new SuppliersDocument(
                supplierDtoRequest.getId(),
                supplierDtoRequest.getName(),
                supplierDtoRequest.getDescription(),
                supplierDtoRequest.getImageUrl(),
                supplierDtoRequest.getCategory(),
                supplierDtoRequest.getSubCategoryAndPosition(),
                supplierDtoRequest.getProductCategory()
        );
        SuppliersDocument savedSupplier = suppliersRepository.save(supplier);
        SuppliersResponse suppliersResponse = new SuppliersResponse(
                savedSupplier.getId(),
                savedSupplier.getName(),
                savedSupplier.getDescription(),
                savedSupplier.getImageUrl(),
                savedSupplier.getCategory(),
                savedSupplier.getSubCategoryAndPosition(),
                savedSupplier.getProductCategory()
        );
        return suppliersResponse;
    }

    @Override
    public SuppliersResponse updateSupplier(SupplierDtoRequest supplierDtoRequest) {
        SuppliersDocument existingSupplier = suppliersRepository.getById(supplierDtoRequest.getId());
        if(existingSupplier==null){
            throw new RuntimeException("Supplier not found");
        }
        existingSupplier.setName(supplierDtoRequest.getName());
        existingSupplier.setDescription(supplierDtoRequest.getDescription());
        existingSupplier.setImageUrl(supplierDtoRequest.getImageUrl());
        existingSupplier.setCategory(supplierDtoRequest.getCategory());
        existingSupplier.setSubCategoryAndPosition(supplierDtoRequest.getSubCategoryAndPosition());
        existingSupplier.setProductCategory(supplierDtoRequest.getProductCategory());

        // Save the updated supplier back to the database
        SuppliersDocument updatedSupplier = suppliersRepository.save(existingSupplier);

        // Convert to response DTO
        return new SuppliersResponse(
                updatedSupplier.getId(),
                updatedSupplier.getName(),
                updatedSupplier.getDescription(),
                updatedSupplier.getImageUrl(),
                updatedSupplier.getCategory(),
                updatedSupplier.getSubCategoryAndPosition(),
                updatedSupplier.getProductCategory()
        );
    }

    @Override
    public SuppliersResponse getById (String id) {
        SuppliersDocument existingSupplier = suppliersRepository.getById(id);
        if(existingSupplier==null){
            throw new RuntimeException("Supplier not found");
        }
        return new SuppliersResponse(
                existingSupplier.getId(),
                existingSupplier.getName(),
                existingSupplier.getDescription(),
                existingSupplier.getImageUrl(),
                existingSupplier.getCategory(),
                existingSupplier.getSubCategoryAndPosition(),
                existingSupplier.getProductCategory()
        );
    }

    @Override
    public String deleteById (String id) {
        if (!suppliersRepository.existsById(id)) {
            throw new RuntimeException("Supplier not found");
        }
        suppliersRepository.deleteById(id);
        return "Supplier deleted successfully";
    }
}
