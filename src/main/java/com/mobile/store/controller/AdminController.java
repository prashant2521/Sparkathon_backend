package com.mobile.store.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.store.dto.Admin;
import com.mobile.store.exception.AdminException;
import com.mobile.store.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

	@PostMapping("admin")
	public Admin registerUser(@Valid @RequestBody Admin admin) throws AdminException, MethodArgumentNotValidException {

		return this.adminService.registerAdmin(admin);

	}

	@GetMapping("admins")
	public List<Admin> getAdmin() throws AdminException {
		return this.adminService.getAdmin();

	}

	@PutMapping("admin")
	public Admin updateAdmin(@Valid @RequestBody Admin admin) throws AdminException, MethodArgumentNotValidException {
		return this.adminService.updateAdmin(admin);

	}

	@DeleteMapping("admin/{adminId}/{adminPassword}")
	public String deleteAdmin(@PathVariable Integer adminId, @PathVariable String adminPassword) throws AdminException {
		return this.adminService.deleteAdmin(adminId, adminPassword);

	}

	@PostMapping("admin/login/{adminId}/{adminPassword}")
	public Boolean login(@PathVariable Integer adminId, @PathVariable String adminPassword) throws AdminException {
		return this.adminService.login(adminId, adminPassword);

	}
}