package com.maksystem.Project.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maksystem.Project.Models.AppResponse;
import com.maksystem.Project.Models.Profile;
import com.maksystem.Project.Services.FileStorageService;
import com.maksystem.Project.Services.ProfileService;
import com.maksystem.Project.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    ProfileService applicationService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    FileStorageService fileStorageService;

//    POST MAPPING
    @RequestMapping(value = AppConstants.EMPLOYEE_URI, method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AppResponse createEmployee(
            @RequestParam(value = AppConstants.EMPLOYEE_JSON_PARAM, required = true) String empJson,
            @RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) MultipartFile file)
            throws JsonParseException, JsonMappingException, IOException {
        System.out.println(empJson);
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
                .path(fileName).toUriString();

        Profile employee = objectMapper.readValue(empJson, Profile.class);
        employee.setProfilePicPath(fileDownloadUri);
        applicationService.createEmployee(employee);

        return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);
    }

    @RequestMapping(value = AppConstants.EMPLOYEE_URI, method = RequestMethod.GET)
    public List<Profile> getAllEmployees() {
        return applicationService.getAllEmployees();
    }

    @RequestMapping(value = AppConstants.DOWNLOAD_URI, method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (contentType == null) {
            contentType = AppConstants.DEFAULT_CONTENT_TYPE;
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        String.format(AppConstants.FILE_DOWNLOAD_HTTP_HEADER, resource.getFilename()))
                .body(resource);
    }
}