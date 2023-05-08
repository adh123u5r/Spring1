package com.example.Chair.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Chair.Model.UserModel;

@Repository

public interface UserRepo extends JpaRepository<UserModel, Integer> {

	

	

}
