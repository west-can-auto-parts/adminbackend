package com.example.admin.controller;

import com.example.admin.dto.ContactResponse;
import com.example.admin.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/api")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public ResponseEntity<List<ContactResponse>> fetchAllContact(){
        List<ContactResponse> responses=contactService.getAllContact();
        return ResponseEntity.ok().body(responses);
    }
    @GetMapping("/download-contacts")
    public ResponseEntity<byte[]> downloadContactsExcel() {
        byte[] excelData=contactService.downloadExcelSheet();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=contacts.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(excelData);
    }
}
