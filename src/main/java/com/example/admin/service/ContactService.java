package com.example.admin.service;

import com.example.admin.dto.ContactResponse;

import java.util.List;

public interface ContactService {
    public List<ContactResponse> getAllContact();
    public byte[] downloadExcelSheet();
}
