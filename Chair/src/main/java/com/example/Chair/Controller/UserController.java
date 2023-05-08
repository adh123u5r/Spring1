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

import com.example.Chair.Model.UserModel;
import com.example.Chair.Repository.UserRepo;
import com.example.Chair.Service.UserService;


	@RestController
	@RequestMapping("/saveTrees")
	public class UserController {
		
		@Autowired
		public UserService user;
		@PostMapping(" ")
		public UserModel addDetails(@RequestBody UserModel tr)
		{
			return user.saveDetails(tr);
		}
		@GetMapping(" ")
		public List<UserModel> read()
		{
			return user.getDetails();
		}
		@GetMapping("/{treeid}")
		public Optional<UserModel> readById(@PathVariable int Email)
		{
			return user.getDetailsById(Email);
		}
		@PutMapping("/Update")
		public String update(@RequestBody UserModel lp_model)
		{
			return user.updateDetails(lp_model);
		}
		@DeleteMapping("/Delete")
		public String delete(@RequestParam ("tid") int Email)
		{
			return user.deleteByRequestParamId(Email);
		}
		
		@GetMapping("/sortAsc/{treename}")
		public List<UserModel> sortAscend(@PathVariable("Email") String Email)
		{
			return user.sortAsc(Email);
		}
		@GetMapping("/sortDesc/{treename}")
		public List<UserModel> sortDesc(@PathVariable("Email") String Email)
		{
			return user.sortDesc(Email);
		}
		
		@GetMapping("/pagination/{pageNo}/{pageSize}")
		public List<UserModel> paginationData(@PathVariable("pageNo")int pnu,@PathVariable("pageSize") int psize)
		{
			return user.paginationData(pnu,psize);
		}
		
		@GetMapping("/pagiantionAndSorting/{pageNo}/{pageSize}/{Email}")
		public List<UserModel> paginationAndSorting(@PathVariable("pageNo") int pnu,@PathVariable("pageSize") int psize,@PathVariable("Email") String Email)
		{
			return user.paginationAndSorting(pnu, psize, Email);
		}
		
		@Autowired
		public UserRepo user1; 
		
		@GetMapping("getG")
		public List<UserModel> getD()
		{
			return user.getAll();
		}
		
		@GetMapping("byOwnerName/{id}")
		public List<UserModel> getName(@PathVariable("id") int gid)	{
			return user.byOwnerName(gid);
		}
		
		@GetMapping("startend/{start}/{end}")
		public List<UserModel> startEnd(@PathVariable("start") int start,@PathVariable("end") int end)	{
			return user.startEnd(start,end);
		}
		
		@DeleteMapping("delete/{id}/{name}")
		public String deleteGarage(@PathVariable("id") int id,@PathVariable("name") String oname)
		{
			user.deleteDet(id, oname);
			return "Deleted";
		}
		
		@GetMapping("jpql")
		public List<UserModel> getJp()
		{
			return user.getAll();
		}
		
		@GetMapping("jp/{id}")
		public List<UserModel> getjpql(@PathVariable("id")int gid)
		{
			return user.jpql(gid);
		}

}
