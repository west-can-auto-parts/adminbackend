package com.example.admin.service.implementation;

import com.example.admin.dto.*;
import com.example.admin.entity.CategoryDocument;
import com.example.admin.entity.ProductCategoryDocument;
import com.example.admin.entity.ProductEnquiryDocument;
import com.example.admin.entity.SubCategoryDocument;
import com.example.admin.repository.CategoryRepository;
import com.example.admin.repository.ProductCategoryRepository;
import com.example.admin.repository.ProductEnquiryRepository;
import com.example.admin.repository.SubCategoryRepository;
import com.example.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductEnquiryRepository productEnquiryRepository;

    @Override
    public String saveSubProduct (ExtraDtoResponse productRequest) {
        SubCategoryDocument response =subCategoryRepository.findByName("Cooling Chemicals");
        CategoryDocument categoryDocument=categoryRepository.findByName("Fluids & Lubricants");
        for(ExtraProduct pro:productRequest.getProductCategoryRequestList()) {
            ProductCategoryDocument subCat = new ProductCategoryDocument();
            subCat.setName(pro.getName());
            subCat.setSubCategoryId(response.getId());
            subCat.setCategoryId(categoryDocument.getId());
            subCat.setDescription(pro.getDescription());
            subCat.setTags(pro.getTags());
            subCat.setImageUrl(pro.getImageUrl());
            productCategoryRepository.save(subCat);
        }
        return "Save product";
    }



    @Override
    public List<CategoryResponse> getAllCategory () {
        List<CategoryDocument> categoryDocumentList=categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new ArrayList<>();

        for(CategoryDocument category :categoryDocumentList) {
            CategoryResponse response = new CategoryResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            response.setDescription(category.getDescription());
            response.setImages(category.getImages());
            response.setTags(category.getTags());
            response.setFeatured(category.isFeatured());
            response.setBestSeller(category.isBestSeller());
            categoryResponses.add(response);
        }
        return categoryResponses;
    }

    @Override
    public String createCategory (CategoryRequest categoryRequest) {
        CategoryDocument category = new CategoryDocument();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        category.setImages(categoryRequest.getImages());
        category.setTags(categoryRequest.getTags());
        category.setFeatured(categoryRequest.isFeatured());
        category.setBestSeller(categoryRequest.isBestSeller());
        categoryRepository.save(category);
        return "Category data save successfully";
    }

    @Override
    public String deleteCategory (String id) {
        Optional<CategoryDocument> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return "Category deleted successfully.";
        } else {
            throw new RuntimeException("Category not found.");
        }
    }

    @Override
    public List<SubCategoryDtoResponse> getAllSubCategory () {
        List<SubCategoryDocument> subCategoryDocumentList=subCategoryRepository.findAll();
        Map<String,String>mp=categoryData();
        List<SubCategoryDtoResponse> subCategoryDtoResponses=new ArrayList<>();
        for(SubCategoryDocument sub: subCategoryDocumentList){
            SubCategoryDtoResponse subCat=new SubCategoryDtoResponse();
            subCat.setId(sub.getId());
            subCat.setName(sub.getName());
            subCat.setDescription(sub.getDescription());
            subCat.setCategoryName(mp.get(sub.getCategoryId()));
            subCat.setImages(sub.getImages());
            subCat.setTags(sub.getTags());
            subCat.setFeatured(sub.isFeatured());
            subCat.setBestSeller(sub.isBestSeller());
            subCategoryDtoResponses.add(subCat);
        }
        return subCategoryDtoResponses;
    }

    @Override
    public String createSubCategory (SubCategoryDtoRequest subCategoryDtoRequest) {
        SubCategoryDocument subCategoryDocument=new SubCategoryDocument();
        subCategoryDocument.setName(subCategoryDtoRequest.getName());
        subCategoryDocument.setCategoryId(subCategoryDtoRequest.getCategoryId());
        subCategoryDocument.setImages(subCategoryDtoRequest.getImages());
        subCategoryDocument.setTags(subCategoryDtoRequest.getTags());
        subCategoryDocument.setFeatured(subCategoryDocument.isFeatured());
        subCategoryDocument.setBestSeller(subCategoryDtoRequest.isBestSeller());
        subCategoryDocument.setProductCategoryAndPosition(subCategoryDtoRequest.getProductCategoryPositions());
        subCategoryRepository.save(subCategoryDocument);
        return "SubCategory data save successfully";
    }

    @Override
    public String editSubCategory (SubCategoryDtoRequest subCategoryDtoRequest, String id) {
        Optional<SubCategoryDocument> subCategoryDocument=subCategoryRepository.findById(id);
        if(subCategoryDocument.isPresent()){
            SubCategoryDocument subCat=subCategoryDocument.get();
            subCat.setName(subCategoryDtoRequest.getName());
            subCat.setDescription(subCategoryDtoRequest.getDescription());
            subCat.setImages(subCategoryDtoRequest.getImages());
            subCat.setTags(subCategoryDtoRequest.getTags());
            subCat.setFeatured(subCategoryDtoRequest.isFeatured());
            subCat.setBestSeller(subCategoryDtoRequest.isBestSeller());
            subCat.setProductCategoryAndPosition(subCategoryDtoRequest.getProductCategoryPositions());
            subCategoryRepository.save(subCat);
            return "Data edit successfully";

        }
        else {
            return "Data is not present";
        }
    }

    @Override
    public SubCategoryDtoResponse getSubCategoryById (String id) {
        Optional<SubCategoryDocument> subCategoryDocument=subCategoryRepository.findById(id);
        Map<String,String>mp=categoryData();
        if(subCategoryDocument.isPresent()){
            SubCategoryDocument sub=subCategoryDocument.get();
            SubCategoryDtoResponse subCat=new SubCategoryDtoResponse();
            subCat.setId(sub.getId());
            subCat.setName(sub.getName());
            subCat.setDescription(sub.getDescription());
            subCat.setCategoryName(mp.get(sub.getCategoryId()));
            subCat.setImages(sub.getImages());
            subCat.setTags(sub.getTags());
            subCat.setFeatured(sub.isFeatured());
            subCat.setBestSeller(sub.isBestSeller());
            subCat.setProductCategoryAndPosition(sub.getProductCategoryAndPosition());
            return subCat;
        }
        return null;
    }

    @Override
    public String deleteSubCategory(String id) {
        Optional<SubCategoryDocument> subCategory = subCategoryRepository.findById(id);
        if (subCategory.isPresent()) {
            subCategoryRepository.deleteById(id);
            return "Subcategory has been successfully deleted.";
        } else {
            return "Subcategory not found.";
        }
    }

    @Override
    public List<ProductCategoryResponse> getAllProductCategory () {
        List<ProductCategoryDocument> productCategoryDocumentList=productCategoryRepository.findAll();
        List<ProductCategoryResponse> productCategoryResponseList=new ArrayList<>();
        Map<String,String>mp1=categoryData();
        Map<String,String>mp2=subCategoryData();
        for(ProductCategoryDocument document: productCategoryDocumentList){
            ProductCategoryResponse proRes=new ProductCategoryResponse();
            proRes.setId(document.getId());
            proRes.setName(document.getName());
            proRes.setDescription(document.getDescription());
            proRes.setImageUrl(document.getImageUrl());
            proRes.setTags(document.getTags());
            proRes.setCategoryName(mp1.get(document.getCategoryId()));
            proRes.setSubCategoryName(mp2.get(document.getSubCategoryId()));
            proRes.setFeatured(document.isFeatured());
            proRes.setBestSeller(document.isBestSeller());
            productCategoryResponseList.add(proRes);
        }
        return productCategoryResponseList;
    }

    @Override
    public String createProductCategory (ProductCategoryRequest productCategoryRequest) {
        ProductCategoryDocument document = new ProductCategoryDocument();
        document.setName(productCategoryRequest.getName());
        document.setDescription(productCategoryRequest.getDescription());
        document.setImageUrl(productCategoryRequest.getImageUrl());
        document.setTags(productCategoryRequest.getTags());
        document.setCategoryId(productCategoryRequest.getCategoryId());
        document.setSubCategoryId(productCategoryRequest.getSubCategoryId());
        document.setFeatured(productCategoryRequest.isFeatured());
        document.setBestSeller(productCategoryRequest.isBestSeller());
        document.setBestSellerPosition(productCategoryRequest.getBestSellerPosition());
        document.setBrandAndPosition(productCategoryRequest.getBrandAndPosition());
        productCategoryRepository.save(document);
        return "Product Category saved successfully with ID: " + document.getId();
    }

    @Override
    public String editProductCategory (ProductCategoryRequest productCategoryRequest, String id) {
        ProductCategoryDocument document = productCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product category not found"));

        document.setName(productCategoryRequest.getName());
        document.setDescription(productCategoryRequest.getDescription());
        document.setImageUrl(productCategoryRequest.getImageUrl());
        document.setTags(productCategoryRequest.getTags());
        document.setCategoryId(productCategoryRequest.getCategoryId());
        document.setSubCategoryId(productCategoryRequest.getSubCategoryId());
        document.setFeatured(productCategoryRequest.isFeatured());
        document.setBestSeller(productCategoryRequest.isBestSeller());
        document.setBrandAndPosition(productCategoryRequest.getBrandAndPosition());
        document.setBestSellerPosition(productCategoryRequest.getBestSellerPosition());
        productCategoryRepository.save(document);

        return "Data edit successfully";
    }

    @Override
    public ProductCategoryResponse getProductCategoryById (String id) {
        ProductCategoryDocument document = productCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product category not found"));
        Map<String,String>mp1=categoryData();
        Map<String,String>mp2=subCategoryData();
        ProductCategoryResponse response = new ProductCategoryResponse();
        response.setId(document.getId());
        response.setName(document.getName());
        response.setDescription(document.getDescription());
        response.setImageUrl(document.getImageUrl());
        response.setTags(document.getTags());
        response.setCategoryName(mp1.get(document.getCategoryId()));
        response.setSubCategoryName(mp2.get(document.getSubCategoryId()));
        response.setFeatured(document.isFeatured());
        response.setBestSeller(document.isBestSeller());
        response.setBestSellerPosition(document.getBestSellerPosition());
        response.setBrandAndPosition(document.getBrandAndPosition());
        return response;
    }

    @Override
    public String deleteProductCategory (String id) {
        if (!productCategoryRepository.existsById(id)) {
            throw new RuntimeException("Product category not found");
        }
        productCategoryRepository.deleteById(id);
        return "Product category deleted successfully";
    }

    @Override
    public List<ProductEnquiryResponse> getAllProductEnquiryForm() {
        // Fetch all product enquiries from the repository
        List<ProductEnquiryDocument> productEnquiries = productEnquiryRepository.findAll();

        // Map each entity to the response object
        return productEnquiries.stream()
                .map(this::mapToProductEnquiryResponse)
                .collect(Collectors.toList());
    }

    private ProductEnquiryResponse mapToProductEnquiryResponse(ProductEnquiryDocument enquiry) {
        ProductEnquiryResponse response = new ProductEnquiryResponse();
        response.setId(enquiry.getId());
        response.setName(enquiry.getName());
        response.setEmail(enquiry.getEmail());
        response.setStore(enquiry.getStore());
        response.setProductName(enquiry.getProductName());
        response.setMessage(enquiry.getMessage());
        return response;
    }


    public Map<String,String> categoryData(){
        List<CategoryDocument> categoryDocumentsList=categoryRepository.findAll();
        Map<String,String> mpList=new HashMap<>();
        for(CategoryDocument cat: categoryDocumentsList){
            mpList.put(cat.getId(),cat.getName());
        }
        return mpList;
    }
    public Map<String,String> subCategoryData(){
        List<SubCategoryDocument> categoryDocumentsList=subCategoryRepository.findAll();
        Map<String,String> mpList=new HashMap<>();
        for(SubCategoryDocument cat: categoryDocumentsList){
            mpList.put(cat.getId(),cat.getName());
        }
        return mpList;
    }
}




