package com.example.Chair.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Chair.Model.LoginModel;
import com.example.Chair.Repository.LoginRepo;


	@Service
	public class LoginService {
		@Autowired                      
		LoginRepo lrep;
		public LoginModel saveDetails(LoginModel lm)
		{
			return lrep.save(lm);
		}
		public List<LoginModel> getDetails()
		{
			return lrep.findAll();
		}
		public Optional<LoginModel> getDetailsById(int Email)
		{
			return lrep.findById(Email);
		}
		public String updateDetails(LoginModel lp_model)
		{
			lrep.save(lp_model);
			return "Updated!";
		}
		public String deleteByRequestParamId(int Email)
		{
			lrep.deleteById(Email);
			return "Deleted!";
		}
		public LoginRepo getlrep() {
			return lrep;
		}
		public void setlrep(LoginRepo lrep) {
			this.lrep = lrep;
		}
	    
		// sorting
		public List<LoginModel> sortAsc(String field) 
		{
			return lrep.findAll(Sort.by(field).ascending());
		}
		
		public List<LoginModel> sortDesc(String field)
		{
			return lrep.findAll(Sort.by(field).descending());
		}
		
		// Pagination
		public List<LoginModel> paginationData (int pageNo, int pageSize) 
		{
			Page<LoginModel> p = lrep.findAll(PageRequest.of(pageNo, pageSize));
			return p.getContent();
		}
		
		// PaginationAndSorting
		public List<LoginModel> paginationAndSorting(int pageNo, int pagesize,String field)
		{
			Page<LoginModel> p = lrep.findAll(PageRequest.of(pageNo, pagesize, Sort.by(field).ascending()));
			return p.getContent();
		}
		public List<LoginModel> byOwnerName(int gid) {
			// TODO Auto-generated method stub
			return null;
		}
		public List<LoginModel> getALLData() {
			// TODO Auto-generated method stub
			return null;
		}
		public List<LoginModel> startEnd(int start, int end) {
			// TODO Auto-generated method stub
			return null;
		}
		public void deleteDet(int id, String oname) {
			// TODO Auto-generated method stub
			
		}
		public List<LoginModel> jpql(int gid) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
}

		

