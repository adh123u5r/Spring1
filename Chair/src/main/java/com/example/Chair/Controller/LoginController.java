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
import com.example.Chair.Model.LoginModel;
import com.example.Chair.Repository.LoginRepo;
import com.example.Chair.Service.LoginService;




	@RestController
	@RequestMapping("/saveTrees")
	public class LoginController {
		
		@Autowired
		public LoginService lser;
		@PostMapping(" ")
		public LoginModel addDetails(@RequestBody LoginModel tr)
		{
			return lser.saveDetails(tr);
		}
		@GetMapping(" ")
		public List<LoginModel> read()
		{
			return lser.getDetails();
		}
		@GetMapping("/{Email}")
		public Optional<LoginModel> readById(@PathVariable int Email)
		{
			return lser.getDetailsById(Email);
		}
		@PutMapping("/Update")
		public String update(@RequestBody LoginModel lp_model)
		{
			return lser.updateDetails(lp_model);
		}
		@DeleteMapping("/Delete")
		public String delete(@RequestParam ("tid") int Email)
		{
			return lser.deleteByRequestParamId(Email);
		}
		
		@GetMapping("/sortAsc/{treename}")
		public List<LoginModel> sortAscend(@PathVariable("Email") String Email)
		{
			return lser.sortAsc(Email);
		}
		@GetMapping("/sortDesc/{Email}")
		public List<LoginModel> sortDesc(@PathVariable("Email") String Email)
		{
			return lser.sortDesc(Email);
		}
		
		@GetMapping("/pagination/{pageNo}/{pageSize}")
		public List<LoginModel> paginationData(@PathVariable("pageNo")int pnu,@PathVariable("pageSize") int psize)
		{
			return lser.paginationData(pnu,psize);
		}
		
		@GetMapping("/pagiantionAndSorting/{pageNo}/{pageSize}/{Email}")
		public List<LoginModel> paginationAndSorting(@PathVariable("pageNo") int pnu,@PathVariable("pageSize") int psize,@PathVariable("Email") String Email)
		{
			return lser.paginationAndSorting(pnu, psize, Email);
		}
		
		@Autowired
		public LoginRepo lser1; 
		
		@GetMapping("getG")
		public List<LoginModel> getD()
		{
			return lser.getALLData();
		}
		
		@GetMapping("byOwnerName/{id}")
		public List<LoginModel> getName(@PathVariable("id") int gid)	{
			return lser.byOwnerName(gid);
		}
		
		@GetMapping("startend/{start}/{end}")
		public List<LoginModel> startEnd(@PathVariable("start") int start,@PathVariable("end") int end)	{
			return lser.startEnd(start,end);
		}
		
		@DeleteMapping("delete/{id}/{name}")
		public String deleteGarage(@PathVariable("id") int id,@PathVariable("name") String oname)
		{
			lser.deleteDet(id, oname);
			return "Deleted";
		}
		
		@GetMapping("jpql")
		public List<LoginModel> getJp()
		{
			return lser.getALLData();
		}
		
		@GetMapping("jp/{id}")
		public List<LoginModel> getjpql(@PathVariable("id")int gid)
		{
			return lser.jpql(gid);
		}

}
