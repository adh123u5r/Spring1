package com.example.Chair.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Chair.Model.AdminModel;
import com.example.Chair.Repository.AdminRepo;


	@Service
	public class AdminService {
		@Autowired                      
		AdminRepo are;
		public AdminModel saveDetails(AdminModel tm)
		{
			return are.save(tm);
		}
		public List<AdminModel> getDetails()
		{
			return are.findAll();
		}
		public Optional<AdminModel> getDetailsById(int Email)
		{
			return are.findById(Email);
		}
		public String updateDetails(AdminModel lp_model)
		{
			are.save(lp_model);
			return "Updated!";
		}
		public String deleteByRequestParamId(int Email)
		{
			are.deleteById(Email);
			return "Deleted!";
		}
		public AdminRepo getare() {
			return are;
		}
		public void setare(AdminRepo are) {
			this.are = are;
		}
	    
		// sorting
		public List<AdminModel> sortAsc(String field) 
		{
			return are.findAll(Sort.by(field).ascending());
		}
		
		public List<AdminModel> sortDesc(String field)
		{
			return are.findAll(Sort.by(field).descending());
		}
		
		// Pagination
		public List<AdminModel> paginationData (int pageNo, int pageSize) 
		{
			Page<AdminModel> p = are.findAll(PageRequest.of(pageNo, pageSize));
			return p.getContent();
		}
		
		// PaginationAndSorting
		public List<AdminModel> paginationAndSorting(int pageNo, int pagesize,String field)
		{
			Page<AdminModel> p = are.findAll(PageRequest.of(pageNo, pagesize, Sort.by(field).ascending()));
			return p.getContent();
		}
		public List<AdminModel> byOwnerName(int gid) {
			// TODO Auto-generated method stub
			return null;
		}
		public List<AdminModel> startEnd(int start, int end) {
			// TODO Auto-generated method stub
			return null;
		}
		public void deleteDet(int id, String oname) {
			// TODO Auto-generated method stub
			
		}
		public List<AdminModel> jpql(int gid) {
			// TODO Auto-generated method stub
			return null;
		}
		public List<AdminModel> getAll() {
			// TODO Auto-generated method stub
			return null;
		}
		public List<AdminModel> getALLData() {
			// TODO Auto-generated method stub
			return null;
		}
}

		

