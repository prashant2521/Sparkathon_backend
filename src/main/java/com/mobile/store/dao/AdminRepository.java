package com.mobile.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.store.dto.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
