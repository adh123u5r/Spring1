package com.example.Chair.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Chair.Model.UserModel;
import com.example.Chair.Repository.UserRepo;



	@Service
	public class UserService {
		@Autowired                      
		UserRepo urep;
		public UserModel saveDetails(UserModel um)
		{
			return urep.save(um);
		}
		public List<UserModel> getDetails()
		{
			return urep.findAll();
		}
		public Optional<UserModel> getDetailsById(int Email)
		{
			return urep.findById(Email);
		}
		public String updateDetails(UserModel lp_model)
		{
			urep.save(lp_model);
			return "Updated!";
		}
		public String deleteByRequestParamId(int Email)
		{
			urep.deleteById(Email);
			return "Deleted!";
		}
		public UserRepo getTre() {
			return urep;
		}
		public void setTre(UserRepo tre) {
			this.urep = urep;
		}
	    
		// sorting
		public List<UserModel> sortAsc(String field) 
		{
			return urep.findAll(Sort.by(field).ascending());
		}
		
		public List<UserModel> sortDesc(String field)
		{
			return urep.findAll(Sort.by(field).descending());
		}
		
		// Pagination
		public List<UserModel> paginationData (int pageNo, int pageSize) 
		{
			Page<UserModel> p = urep.findAll(PageRequest.of(pageNo, pageSize));
			return p.getContent();
		}
		
		// PaginationAndSorting
		public List<UserModel> paginationAndSorting(int pageNo, int pagesize,String field)
		{
			Page<UserModel> p = urep.findAll(PageRequest.of(pageNo, pagesize, Sort.by(field).ascending()));
			return p.getContent();
		}
		public List<UserModel> jpql(int gid) {
			// TODO Auto-generated method stub
			return null;
		}
		public void deleteDet(int id, String oname) {
			// TODO Auto-generated method stub
			
		}
		public List<UserModel> byOwnerName(int gid) {
			// TODO Auto-generated method stub
			return null;
		}
		public List<UserModel> getAll() {
			// TODO Auto-generated method stub
			return null;
		}
		public List<UserModel> startEnd(int start, int end) {
			// TODO Auto-generated method stub
			return null;
		}
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	