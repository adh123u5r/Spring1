package com.example.Chair.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Chair.Model.LoanApplicationModel;
import com.example.Chair.Repository.LoanApplicationRepo;
import com.example.Chair.Repository.LoginRepo;
import com.example.Chair.Service.LoanApplicationService;




	@RestController
	@RequestMapping("/saveTrees")
	public class LoanApplicationController {
		
		@Autowired
		public LoanApplicationService laser;
		@PostMapping(" ")
		public LoanApplicationModel addDetails(@RequestBody LoanApplicationModel tr)
		{
			return laser.saveDetails(tr);
		}
		@GetMapping(" ")
		public List<LoanApplicationModel> read()
		{
			return laser.getDetails();
		}
		@GetMapping("/{treeid}")
		public Optional<LoanApplicationModel> readById(@PathVariable int loanid)
		{
			return laser.getDetailsById(loanid);
		}
		@PutMapping("/Update")
		public String update(@RequestBody LoanApplicationModel lp_model)
		{
			return laser.updateDetails(lp_model);
		}
		@DeleteMapping("/Delete")
		public String delete(@RequestParam ("tid") int treeid)
		{
			return laser.deleteByRequestParamId(treeid);
		}
		
		@GetMapping("/sortAsc/{loanid}")
		public List<LoanApplicationModel> sortAscend(@PathVariable("loanid") String loanid)
		{
			return laser.sortAsc(loanid);
		}
		@GetMapping("/sortDesc/{loanid}")
		public List<LoanApplicationModel> sortDesc(@PathVariable("loanid") String loanid)
		{
			return laser.sortDesc(loanid);
		}
		
		@GetMapping("/pagination/{pageNo}/{pageSize}")
		public List<LoanApplicationModel> paginationData(@PathVariable("pageNo")int pnu,@PathVariable("pageSize") int psize)
		{
			return laser.paginationData(pnu,psize);
		}
		
		@GetMapping("/pagiantionAndSorting/{pageNo}/{pageSize}/{loanid}")
		public List<LoanApplicationModel> paginationAndSorting(@PathVariable("pageNo") int pnu,@PathVariable("pageSize") int psize,@PathVariable("loanid") String loanid )
		{
			return laser.paginationAndSorting(pnu, psize, loanid);
		}
		
		@Autowired
		public LoanApplicationRepo laser1; 
		
		@GetMapping("getG")
		public List<LoanApplicationModel> getD()
		{
			return laser.getAll();
		}
		
		@GetMapping("byOwnerName/{id}")
		public List<LoanApplicationModel> getName(@PathVariable("id") int gid)	{
			return laser.byOwnerName(gid);
		}
		
		@GetMapping("startend/{start}/{end}")
		public List<LoanApplicationModel> startEnd(@PathVariable("start") int start,@PathVariable("end") int end)	{
			return laser.startEnd(start,end);
		}
		
		@DeleteMapping("delete/{id}/{name}")
		public String deleteGarage(@PathVariable("id") int id,@PathVariable("name") String oname)
		{
			laser.deleteDet(id, oname);
			return "Deleted";
		}
		
		@GetMapping("jpql")
		public List<LoanApplicationModel> getJp()
		{
			return laser.getAll();
		}
		
		@GetMapping("jp/{id}")
		public List<LoanApplicationModel> getjpql(@PathVariable("id")int gid)
		{
			return laser.jpql(gid);
		}

}
