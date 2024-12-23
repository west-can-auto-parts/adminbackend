package com.example.admin.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExtraDtoResponse {
    List<ExtraProduct> productCategoryRequestList;

    public List<ExtraProduct> getProductCategoryRequestList () {
        return productCategoryRequestList;
    }

    public void setProductCategoryRequestList (List<ExtraProduct> productCategoryRequestList) {
        this.productCategoryRequestList = productCategoryRequestList;
    }
}
