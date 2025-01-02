package com.example.admin.service;


import com.example.admin.dto.*;

import java.util.List;

public interface ProductService {

    public String saveSubProduct(ExtraDtoResponse productRequest);
    public List<CategoryResponse> getAllCategory();
    public String createCategory(CategoryRequest categoryRequest);
    public String deleteCategory(String id);

    public List<SubCategoryDtoResponse> getAllSubCategory();
    public String createSubCategory(SubCategoryDtoRequest subCategoryDtoRequest);
    public String editSubCategory(SubCategoryDtoRequest subCategoryDtoRequest,String id);
    public SubCategoryDtoResponse getSubCategoryById(String id);
    public String deleteSubCategory(String id);

    public List<ProductCategoryResponse> getAllProductCategory();
    public String createProductCategory(ProductCategoryRequest productCategoryRequest);
    public String editProductCategory(ProductCategoryRequest productCategoryRequest,String id);
    public ProductCategoryResponse getProductCategoryById(String id);
    public String deleteProductCategory(String id);
    public List<ProductEnquiryResponse> getAllProductEnquiryForm();

}
