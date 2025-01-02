package com.example.admin.service;

import com.example.admin.dto.ContactResponse;
import com.example.admin.dto.SubscribeResponse;

import java.util.List;

public interface ContactService {
    public List<ContactResponse> getAllContact();
    public byte[] downloadExcelSheet();
    public List<SubscribeResponse> getAllSubscribe();
    public byte[] downloadSubscribe();
}
