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

import com.example.Chair.Model.AdminModel;
import com.example.Chair.Repository.AdminRepo;
import com.example.Chair.Service.AdminService;

	@RestController
	@RequestMapping("/saveTrees")
	public class AdminController {
		
		@Autowired
		public AdminService aser;
		@PostMapping(" ")
		public AdminModel addDetails(@RequestBody AdminModel tr)
		{
			return aser.saveDetails(tr);
		}
		@GetMapping(" ")
		public List<AdminModel> read()
		{
			return aser.getDetails();
		}
		@GetMapping("/{Email}")
		public Optional<AdminModel> readById(@PathVariable int Email)
		{
			return aser.getDetailsById(Email);
		}
		@PutMapping("/Update")
		public String update(@RequestBody AdminModel lp_model)
		{
			return aser.updateDetails(lp_model);
		}
		@DeleteMapping("/Delete")
		public String delete(@RequestParam ("tid") int Email)
		{
			return aser.deleteByRequestParamId(Email);
		}
		
		@GetMapping("/sortAsc/{Email}")
		public List<AdminModel> sortAscend(@PathVariable("Email") String Email)
		{
			return aser.sortAsc(Email);
		}
		@GetMapping("/sortDesc/{Password}")
		public List<AdminModel> sortDesc(@PathVariable("Password") String Email)
		{
			return aser.sortDesc(Email);
		}
		
		@GetMapping("/pagination/{pageNo}/{pageSize}")
		public List<AdminModel> paginationData(@PathVariable("pageNo")int pnu,@PathVariable("pageSize") int psize)
		{
			return aser.paginationData(pnu,psize);
		}
		
		@GetMapping("/pagiantionAndSorting/{pageNo}/{pageSize}/{Email}")
		public List<AdminModel> paginationAndSorting(@PathVariable("pageNo") int pnu,@PathVariable("pageSize") int psize,@PathVariable("Email") String Email)
		{
			return aser.paginationAndSorting(pnu, psize, Email);
		}
		
		@Autowired
		public AdminRepo aser1; 
		
		@GetMapping("getG")
		public List<AdminModel> getD()
		{
			return aser.getALLData();
		}
		
		@GetMapping("byOwnerName/{id}")
		public List<AdminModel> getName(@PathVariable("id") int gid)	{
			return aser.byOwnerName(gid);
		}
		
		@GetMapping("startend/{start}/{end}")
		public List<AdminModel> startEnd(@PathVariable("start") int start,@PathVariable("end") int end)	{
			return aser.startEnd(start,end);
		}
		
		@DeleteMapping("delete/{id}/{name}")
		public String deleteGarage(@PathVariable("id") int id,@PathVariable("name") String oname)
		{
			aser.deleteDet(id, oname);
			return "Deleted";
		}
		
		@GetMapping("jpql")
		public List<AdminModel> getJp()
		{
			return aser.getAll();
		}
		
		@GetMapping("jp/{id}")
		public List<AdminModel> getjpql(@PathVariable("id")int gid)
		{
			return aser.jpql(gid);
		}

}
