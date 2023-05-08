package com.example.Chair.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Chair.Model.LoanApplicationModel;
import com.example.Chair.Repository.LoanApplicationRepo;


@Service
public class LoanApplicationService {
	@Autowired                      
	LoanApplicationRepo larep;
	public LoanApplicationModel saveDetails(LoanApplicationModel lm)
	{
		return larep.save(lm);
	}
	public List<LoanApplicationModel> getDetails()
	{
		return larep.findAll();
	}
	public Optional<LoanApplicationModel> getDetailsById(int Email)
	{
		return larep.findById(Email);
	}
	public String updateDetails(LoanApplicationModel lp_model)
	{
		larep.save(lp_model);
		return "Updated!";
	}
	public String deleteByRequestParamId(int treeid)
	{
		larep.deleteById(treeid);
		return "Deleted!";
	}
	public LoanApplicationRepo getlare() {
		return larep;
	}
	public void setlarep(LoanApplicationRepo larep) {
		this.larep = larep;
	}
    
	// sorting
	public List<LoanApplicationModel> sortAsc(String field) 
	{
		return larep.findAll(Sort.by(field).ascending());
	}
	
	public List<LoanApplicationModel> sortDesc(String field)
	{
		return larep.findAll(Sort.by(field).descending());
	}
	
	// Pagination
	public List<LoanApplicationModel> paginationData (int pageNo, int pageSize) 
	{
		Page<LoanApplicationModel> p = larep.findAll(PageRequest.of(pageNo, pageSize));
		return p.getContent();
	}
	
	// PaginationAndSorting
	public List<LoanApplicationModel> paginationAndSorting(int pageNo, int pagesize,String field)
	{
		Page<LoanApplicationModel> p = larep.findAll(PageRequest.of(pageNo, pagesize, Sort.by(field).ascending()));
		return p.getContent();
	}
	public List<LoanApplicationModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<LoanApplicationModel> byOwnerName(int gid) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<LoanApplicationModel> startEnd(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deleteDet(int id, String oname) {
		// TODO Auto-generated method stub
		
	}
	public List<LoanApplicationModel> jpql(int gid) {
		// TODO Auto-generated method stub
		return null;
	}
}