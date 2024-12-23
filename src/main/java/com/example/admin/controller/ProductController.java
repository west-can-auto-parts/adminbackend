package com.example.admin.controller;

import com.example.admin.dto.*;
import com.example.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/save")
    public void save(@RequestBody ExtraDtoResponse extraDtoResponse){
        productService.saveSubProduct(extraDtoResponse);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponse>> fetchAllCategory(){
        List<CategoryResponse> responses =productService.getAllCategory();
        return ResponseEntity.ok().body(responses);
    }

    @PostMapping("/category/create")
    public ResponseEntity<String> createCategory(@RequestBody CategoryRequest categoryDtoRequest){
        String response=productService.createCategory(categoryDtoRequest);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable ("id") String id){
        String responses =productService.deleteCategory(id);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/subcategory")
    public ResponseEntity<List<SubCategoryDtoResponse>> fetchAllSubCategory(){
        List<SubCategoryDtoResponse> responses =productService.getAllSubCategory();
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/subcategory/{id}")
    public ResponseEntity<SubCategoryDtoResponse> fetchSubCategoryById(@PathVariable ("id") String id){
        SubCategoryDtoResponse responses =productService.getSubCategoryById(id);
        return ResponseEntity.ok().body(responses);
    }

    @PostMapping("/subcategory/create")
    public ResponseEntity<String> createSubCategory(@RequestBody SubCategoryDtoRequest subCategoryDtoRequest){
        String response=productService.createSubCategory(subCategoryDtoRequest);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/subcategory/update/{id}")
    public ResponseEntity<String> updateSubCategory(@RequestBody SubCategoryDtoRequest subCategoryDtoRequest,@PathVariable ("id") String id){
        String response=productService.editSubCategory(subCategoryDtoRequest,id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/subcategory/delete/{id}")
    public ResponseEntity<String> deleteSubCategoryById(@PathVariable ("id") String id){
        String responses =productService.deleteSubCategory(id);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/product-category")
    public ResponseEntity<List<ProductCategoryResponse>> fetchAllProductCategory(){
        List<ProductCategoryResponse> responses =productService.getAllProductCategory();
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/product-category/{id}")
    public ResponseEntity<ProductCategoryResponse> fetchProductCategoryById(@PathVariable ("id") String id){
        ProductCategoryResponse responses =productService.getProductCategoryById(id);
        return ResponseEntity.ok().body(responses);
    }

    @PostMapping("/product-category/create")
    public ResponseEntity<String> createProductCategory(@RequestBody ProductCategoryRequest productCategoryRequest){
        String response=productService.createProductCategory(productCategoryRequest);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/product-category/update/{id}")
    public ResponseEntity<String> updateProductCategory(@RequestBody ProductCategoryRequest productCategoryRequest,@PathVariable ("id") String id){
        String response=productService.editProductCategory(productCategoryRequest,id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/product-category/delete/{id}")
    public ResponseEntity<String> deleteProductCategoryById(@PathVariable ("id") String id){
        String responses =productService.deleteProductCategory(id);
        return ResponseEntity.ok().body(responses);
    }
}
