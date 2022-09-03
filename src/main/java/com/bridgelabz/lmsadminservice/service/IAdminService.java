package com.bridgelabz.lmsadminservice.service;

import com.bridgelabz.lmsadminservice.dto.AdminDTO;
import com.bridgelabz.lmsadminservice.model.AdminModel;
import com.bridgelabz.lmsadminservice.util.Response;
import com.bridgelabz.lmsadminservice.util.ResponseClass;

import java.util.List;

public interface IAdminService {
    Response addAdmin(AdminDTO adminDTO);

    List<AdminModel> getAllAdmins(String token);

    Response updateAdminDetails(Long id, String token, AdminDTO adminDTO);

    Response deleteAdminDetails(Long id, String token);

    ResponseClass loginAdmin(String emailId, String password);

    Response updatePassword(String token, String password);

    Response resetPassword(String emailId);

    Response addProfile(Long id, String profilePath, String token);

    Boolean validate(String token);
}
