package com.example.test.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import com.example.test.model.Customer;
import com.example.test.repository.CustomerRepository;
import com.example.test.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    //private CustomerService customerService;
    private CustomerRepository customerRepository;    

    @RequestMapping(value={"/admin/customer"}, method = RequestMethod.GET)
    public ModelAndView index(){    	
        ModelAndView modelAndView = new ModelAndView();   
        modelAndView.setViewName("srtdash/customer/index");
        modelAndView.addObject("customers", customerRepository.findAll());
        return modelAndView;
    }
    
    @RequestMapping(value={"/admin/customer/create"}, method = RequestMethod.GET)
    public ModelAndView create(){    	
        ModelAndView modelAndView = new ModelAndView();   
        modelAndView.setViewName("srtdash/customer/create");       
        return modelAndView;
    }
    
    @RequestMapping(value={"/admin/customer"}, method = RequestMethod.POST)
    public String store(@Valid Customer cust, BindingResult bindingResult){    	
        customerRepository.save(cust);
        return "redirect:/admin/customer";
    }
    
    @RequestMapping(value={"/admin/customer/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int itemId){    	
        ModelAndView modelAndView = new ModelAndView();   
        modelAndView.setViewName("srtdash/customer/edit");  
        modelAndView.addObject("customer", customerRepository.findById(itemId));
        modelAndView.addObject("itemId",itemId);
        return modelAndView;
    }
    
    @RequestMapping(value={"/admin/customer/delete/{id}"}, method = RequestMethod.GET)
    public String destroy(@PathVariable("id") int itemId) {
    	customerRepository.deleteById(itemId);    	 
    	return "redirect:/admin/customer";
    }

}