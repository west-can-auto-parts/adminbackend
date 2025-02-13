package com.example.admin.service.implementation;

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
        return suppliersDocumentList.stream().map(supplier -> new SuppliersResponse(supplier.getId(),supplier.getName(),supplier.getCategories(),supplier.getSubCategories(),supplier.getProductCategories()
                ,supplier.getImageUrl())).collect(Collectors.toList());
    }
}
