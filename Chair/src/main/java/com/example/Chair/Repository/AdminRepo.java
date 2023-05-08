package com.example.Chair.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Chair.Model.AdminModel;


	
	
@Repository
public interface AdminRepo extends JpaRepository<AdminModel, Integer>{


}
