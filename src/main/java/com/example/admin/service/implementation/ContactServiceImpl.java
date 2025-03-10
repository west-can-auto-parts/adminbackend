package com.example.admin.service.implementation;

import com.example.admin.dto.ContactResponse;
import com.example.admin.dto.SubscribeResponse;
import com.example.admin.entity.ContactDocument;
import com.example.admin.entity.SubCategoryDocument;
import com.example.admin.entity.SubscribeDocument;
import com.example.admin.repository.ContactRepository;
import com.example.admin.repository.SubscribeRepository;
import com.example.admin.service.ContactService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private SubscribeRepository subscribeRepository;

    @Override
    public List<ContactResponse> getAllContact () {
        List<ContactDocument> contactDocumentList=contactRepository.findAll();
        List<ContactResponse> contactResponseList = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (ContactDocument contactDocument : contactDocumentList) {
            ContactResponse response = new ContactResponse();
            response.setId(contactDocument.getId());
            response.setFirstName(contactDocument.getFirstName());
            response.setLastName(contactDocument.getLastName());
            response.setCompanyName(contactDocument.getCompanyName());
            response.setEmail(contactDocument.getEmail());
            response.setPhoneNumber(contactDocument.getPhoneNumber());
            response.setMessage(contactDocument.getMessage());
            response.setAgreed(contactDocument.isAgreed());
            LocalDate createdDate = contactDocument.getCreatedAt().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            response.setCreatedAt(createdDate.format(dateFormatter));
            contactResponseList.add(response);
        }
        return contactResponseList;
    }

    @Override
    public byte[] downloadExcelSheet () {
        List<ContactDocument> contacts = contactRepository.findAll();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Create the Excel workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Contacts");

        // Create the header row
        Row headerRow = sheet.createRow(0);
        String[] headers = { "First Name", "Last Name", "Company Name", "Email", "Phone Number", "Message", "Agreed", "Created At" };
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            cell.setCellStyle(style);
        }

        // Populate the data rows
        int rowIdx = 1;
        for (ContactDocument contact : contacts) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(contact.getFirstName());
            row.createCell(1).setCellValue(contact.getLastName());
            row.createCell(2).setCellValue(contact.getCompanyName());
            row.createCell(3).setCellValue(contact.getEmail());
            row.createCell(4).setCellValue(contact.getPhoneNumber());
            row.createCell(5).setCellValue(contact.getMessage());
            row.createCell(6).setCellValue(contact.isAgreed() ? "Yes" : "No");
            LocalDate createdDate = contact.getCreatedAt().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            row.createCell(7).setCellValue(createdDate.format(dateFormatter)); // Format as required
        }

        // Autosize columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the workbook to a byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] excelData = outputStream.toByteArray();
        return excelData;
    }

    @Override
    public List<SubscribeResponse> getAllSubscribe () {
        List<SubscribeDocument> subscribeDocumentList= subscribeRepository.findAll();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<SubscribeResponse> subscribeResponsesList=new ArrayList<>();
        for(SubscribeDocument sub:subscribeDocumentList){
            SubscribeResponse subscribeResponse=new SubscribeResponse();
            subscribeResponse.setId(sub.getId());
            subscribeResponse.setEmail(sub.getEmail());
            LocalDate createdDate = sub.getSubscribedAt().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            subscribeResponse.setSubscribedAt(createdDate.format(dateFormatter));
            subscribeResponsesList.add(subscribeResponse);
        }
        return subscribeResponsesList;
    }

    @Override
    public byte[] downloadSubscribe () {
        List<SubscribeDocument> subscribeDocumentList = subscribeRepository.findAll();
        // Create the Excel workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Subscribe");

        // Create the header row
        Row headerRow = sheet.createRow(0);
        String[] headers = { "Email","SubscribedAt"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            cell.setCellStyle(style);
        }

        // Populate the data rows
        int rowIdx = 1;
        for (SubscribeDocument sub : subscribeDocumentList) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(sub.getEmail());
            row.createCell(1).setCellValue(sub.getSubscribedAt());
        }
        // Autosize columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
        // Write the workbook to a byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] excelData = outputStream.toByteArray();
        return excelData;
    }
}
