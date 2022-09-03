package com.bridgelabz.lmsadminservice.service;

import com.bridgelabz.lmsadminservice.dto.AdminDTO;
import com.bridgelabz.lmsadminservice.exception.CustomException;
import com.bridgelabz.lmsadminservice.model.AdminModel;
import com.bridgelabz.lmsadminservice.util.ResponseClass;

import java.util.List;

public interface IAdminService {
    AdminModel addAdmin(AdminDTO adminDTO);

    List<AdminModel> getAllAdmins(String token);

    AdminModel updateAdminDetails(Long id, String token, AdminDTO adminDTO);

    AdminModel deleteAdminDetails(Long id, String token);

    ResponseClass loginAdmin(String emailId, String password);

    AdminModel updatePassword(String token, String password);

    CustomException resetPassword(String emailId);

    AdminModel addProfile(Long id, String profilePath, String token);
}
