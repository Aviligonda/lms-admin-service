package com.bridgelabz.lmsadminservice.controller;

import com.bridgelabz.lmsadminservice.dto.AdminDTO;
import com.bridgelabz.lmsadminservice.exception.CustomException;
import com.bridgelabz.lmsadminservice.model.AdminModel;
import com.bridgelabz.lmsadminservice.service.IAdminService;
import com.bridgelabz.lmsadminservice.util.ResponseClass;
import org.springframework.beans.factory.annotation.Autowired;
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
    public AdminModel addAdmin(@Valid @RequestBody AdminDTO adminDTO) {
        return adminService.addAdmin(adminDTO);
    }

    /*
     * Purpose : Retrive All Admin Details
     * @author : Aviligonda Sreenivasulu
     * @Param : token
     * */
    @GetMapping("/getAllAdmins")
    public List<AdminModel> getAllAdmins(@RequestHeader String token) {
        return adminService.getAllAdmins(token);
    }

    /*
     * Purpose : Existing Admin Details Update
     * @author : Aviligonda Sreenivasulu
     * @Param :  token,adminDTO and id
     * */
    @PutMapping("/updateAdminDetails/{id}")
    public AdminModel updateDetails(@RequestHeader String token,
                                    @Valid @RequestBody AdminDTO adminDTO,
                                    @PathVariable Long id) {
        return adminService.updateAdminDetails(id, token, adminDTO);
    }

    /*
     * Purpose : Delete Admin Details
     * @author : Aviligonda Sreenivasulu
     * @Param : token and id
     * */
    @DeleteMapping("/deleteAdminDetails/{id}")
    public AdminModel deleteAdminDetails(@PathVariable Long id,
                                         @RequestHeader String token) {
        return adminService.deleteAdminDetails(id, token);
    }

    /*
     * Purpose : Login the with admin Email and Password
     * @author : Aviligonda Sreenivasulu
     * @Param : emailId and password
     * */
    @PostMapping("/loginAdmin")
    public ResponseClass loginAdmin(@RequestParam String emailId,
                                    @RequestParam String password) {
        return adminService.loginAdmin(emailId, password);
    }

    /*
     * Purpose : Update Login Password
     * @author : Aviligonda Sreenivasulu
     * @Param : token and password
     * */
    @PutMapping("/updatePassword")
    public AdminModel updatePassword(@RequestHeader String token,
                                     @RequestParam String password) {
        return adminService.updatePassword(token, password);
    }

    /*
     * Purpose : Reset Login Password
     * @author : Aviligonda Sreenivasulu
     * @Param : emailId
     * */
    @PutMapping("/resetPassword")
    public CustomException resetPassword(@RequestParam String emailId) {
        return adminService.resetPassword(emailId);
    }

    /*
     * Purpose : Set Profile Path of Admin
     * @author : Aviligonda Sreenivasulu
     * @Param :  profilePath,id and token
     * */
    @PostMapping("/addProfilePath")
    public AdminModel addProfilePath(@RequestParam Long id,
                                     @RequestHeader String token,
                                     @RequestParam String profilePath) {
        return adminService.addProfile(id, profilePath, token);
    }
}

