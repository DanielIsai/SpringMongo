package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.example.demo.util.PersonResponse;

@Controller
public class WebPersonController {
	
	private final PersonService personService;
	private PersonResponse personResponse;
		
	public WebPersonController(PersonService personService, PersonResponse personResponse) {
		this.personService = personService;
		this.personResponse = personResponse;
	}
	
	@GetMapping("/Menu")
	public String Menu() {
		return "Menu";
	}

	@GetMapping("/Create")
	public String Create() {
		return "AddPerson";
	}
	

	
	@PostMapping("/detailsCreate")
	public String detailsCreate(@RequestParam("cname") String cname, @RequestParam("cemail") String cemail, @RequestParam("cphone") String cphone, ModelMap modelMap) {
		personResponse = personService.save(new Person(null,cname,cemail,cphone));
		modelMap.put("message",personResponse.getMessage());
		return "Status";
	}
	
	@GetMapping("/ObtainAll")
	public String ObtainAll(ModelMap modelMap) {
		personResponse = personService.findAll();
		modelMap.put("list", personResponse.getMessage());
		return "ViewAll";
	}
	
	@GetMapping("/ObtainById")
	public String ObtainById() {
		return "ObtainById";
	}
	
	@PostMapping("/detailsObtainById")
	public String detailsObtainById(@RequestParam("cid") UUID cid, ModelMap modelMap) {
		personResponse = personService.findById(new Person(cid,"",null,null));
		String cname = "",cemail = "",cphone="";
		if(!personResponse.getPersonResult().isEmpty()) {
			cname = personResponse.getPersonResult().get(0).getName();
			cemail = personResponse.getPersonResult().get(0).getEmail();
			cphone = personResponse.getPersonResult().get(0).getPhone();
		}
		
		modelMap.put("action", personResponse.getMessage());
		modelMap.put("cid", cid);
		modelMap.put("cname", cname);
		modelMap.put("cemail", cemail);
		modelMap.put("cphone", cphone);
		return "ViewCostumer";
	}
	
	
	@GetMapping("/DeleteById")
	public String DeleteById() {
		return "DeleteById";
	}
	
	@PostMapping("/detailsDeleteById")
	public String detailsDeleteById(@RequestParam("cid") UUID cid, ModelMap modelMap) {
		personResponse = personService.delete(new Person(cid,"",null,null));
		modelMap.put("message", personResponse.getMessage());
		return "Status";
	}
	
	@GetMapping("/DeleteAll")
	public String DeleteAll(ModelMap modelMap) {
		personResponse = personService.deleteAll();
		modelMap.put("message", personResponse.getMessage());
		return "Status";
	}
	
	
	@GetMapping("/UpdateById")
	public String UpdateById() {
		return "UpdatedById";
	}
	
	@PostMapping("/detailsUpdateById")
	public String detailsUpdateById(@RequestParam("cid") UUID cid, @RequestParam("cname") String cname, @RequestParam("cemail") String cemail, @RequestParam("cphone") String cphone, ModelMap modelMap) {
		personResponse = personService.update(new Person(cid,cname,cemail,cphone));
		modelMap.put("message", personResponse.getMessage());		
		return "Status";
		
		
		
	}
	
	
	
	
	
	

}
