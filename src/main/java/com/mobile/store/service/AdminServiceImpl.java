package com.mobile.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.store.dao.AdminRepository;

import com.mobile.store.dto.Admin;
import com.mobile.store.exception.AdminException;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminRepository;

	
	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		Integer adminId = admin.getAdminId();
		Optional<Admin> tempAdmin = this.adminRepository.findById(adminId);
		if (tempAdmin.isPresent()) {
			throw new AdminException("Admin already exists!");
		}
		return adminRepository.save(admin);
	}


	@Override
	public String deleteAdmin(Integer adminId, String adminPassword) throws AdminException {
		String isDeleted;
		Optional<Admin> admin = this.adminRepository.findById(adminId);
		if (admin.isEmpty()) {
			throw new AdminException("Admin does not exist for id " + adminId);
		}
		Admin newAdmin = admin.get();
			if (!(newAdmin.getAdminPassword().equals(adminPassword))) {
				throw new AdminException("Incorrect Password");
			}
			this.adminRepository.deleteById(adminId);
			isDeleted = "Successful";
		return isDeleted;
	}


	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {

		Optional<Admin> foundAdmin = this.adminRepository.findById(admin.getAdminId());
		if (foundAdmin.isEmpty()) {
			throw new AdminException("Admin doesnot exists for id " + admin.getAdminId());
		}
		return this.adminRepository.save(admin);
	}


	@Override
	public List<Admin> getAdmin() throws AdminException {
		List<Admin> admin = this.adminRepository.findAll();
		if (admin.isEmpty())
			throw new AdminException("admin not found");
		return this.adminRepository.findAll();
	}


	@Override
	public Boolean login(Integer adminId, String adminPassword) throws AdminException {
		boolean isLogedin = false;
		Optional<Admin> foundAdmin = this.adminRepository.findById(adminId);
		if (foundAdmin.isEmpty()) {
			throw new AdminException("Admin doesnot exists for id " + adminId);
		}
		if (!foundAdmin.get().getAdminPassword().equals(adminPassword)) {
			throw new AdminException("Incorrect password");
		}
		if (foundAdmin.get().getAdminPassword().equals(adminPassword)) {
			isLogedin = true;
		}
		return isLogedin;
	}

}