package com.oss.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;  

import com.oss.impl.DelegateImpl;
  
@RestController  
@EnableAutoConfiguration  
public class Application{  
	
	protected static Logger logger=LoggerFactory.getLogger(Application.class);
	
    @RequestMapping("/")  
    String home() {  
    	logger.info("reveive request");
    	return DelegateImpl.home();  
    }  
      
    @RequestMapping(value = "/hello/{myName}", method = RequestMethod.POST)   
    String index(@PathVariable String myName) {  
        return "Hello "+myName+"!!!";  
    }  
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}  