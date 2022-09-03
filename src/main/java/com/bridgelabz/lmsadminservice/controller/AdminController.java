package com.bridgelabz.lmsadminservice.controller;

import com.bridgelabz.lmsadminservice.dto.AdminDTO;
import com.bridgelabz.lmsadminservice.exception.CustomException;
import com.bridgelabz.lmsadminservice.model.AdminModel;
import com.bridgelabz.lmsadminservice.service.IAdminService;
import com.bridgelabz.lmsadminservice.util.Response;
import com.bridgelabz.lmsadminservice.util.ResponseClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;

    /*
     * Purpose : Admin Details Create
     * @author : Aviligonda Sreenivasulu
     * @Param : adminDTO
     * */
    @PostMapping("/addAdmin")
    public ResponseEntity<Response> addAdmin(@Valid @RequestBody AdminDTO adminDTO) {
        Response response = adminService.addAdmin(adminDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Retrive All Admin Details
     * @author : Aviligonda Sreenivasulu
     * @Param : token
     * */
    @GetMapping("/getAllAdmins")
    public ResponseEntity<List<?>> getAllAdmins(@RequestHeader String token) {
        List<AdminModel> response =adminService.getAllAdmins(token);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /*
     * Purpose : Existing Admin Details Update
     * @author : Aviligonda Sreenivasulu
     * @Param :  token,adminDTO and id
     * */
    @PutMapping("/updateAdminDetails/{id}")
    public ResponseEntity<Response> updateDetails(@RequestHeader String token,
                                                  @Valid @RequestBody AdminDTO adminDTO,
                                                  @PathVariable Long id) {
        Response response = adminService.updateAdminDetails(id, token, adminDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Delete Admin Details
     * @author : Aviligonda Sreenivasulu
     * @Param : token and id
     * */
    @DeleteMapping("/deleteAdminDetails/{id}")
    public ResponseEntity<Response> deleteAdminDetails(@PathVariable Long id,
                                                       @RequestHeader String token) {
        Response response = adminService.deleteAdminDetails(id, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Login the with admin Email and Password
     * @author : Aviligonda Sreenivasulu
     * @Param : emailId and password
     * */
    @PostMapping("/loginAdmin")
    public ResponseEntity<ResponseClass> loginAdmin(@RequestParam String emailId,
                                                    @RequestParam String password) {
        ResponseClass responseClass = adminService.loginAdmin(emailId, password);
        return new ResponseEntity<>(responseClass, HttpStatus.OK);
    }

    /*
     * Purpose : Update Login Password
     * @author : Aviligonda Sreenivasulu
     * @Param : token and password
     * */
    @PutMapping("/updatePassword")
    public ResponseEntity<Response> updatePassword(@RequestHeader String token,
                                                   @RequestParam String password) {
        Response response = adminService.updatePassword(token, password);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /*
     * Purpose : Reset Login Password
     * @author : Aviligonda Sreenivasulu
     * @Param : emailId
     * */
    @PutMapping("/resetPassword")
    public ResponseEntity<Response> resetPassword(@RequestParam String emailId) {
        Response response = adminService.resetPassword(emailId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /*
     * Purpose : Set Profile Path of Admin
     * @author : Aviligonda Sreenivasulu
     * @Param :  profilePath,id and token
     * */
    @PostMapping("/addProfilePath")
    public ResponseEntity<Response> addProfilePath(@RequestParam Long id,
                                     @RequestHeader String token,
                                     @RequestParam String profilePath) {
        Response response= adminService.addProfile(id, profilePath, token);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/validate/{token}")
    public Boolean validate(@PathVariable String token) {
        return adminService.validate(token);
    }

}

