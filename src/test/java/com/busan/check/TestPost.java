package com.busan.check;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController 
public class TestPost {

	public class HttpController{
	    
	    	//Test용 
	        @PostMapping("ajax/post")
	        public String postTest(@RequestParam(value="kwd", required=false, defaultValue="0") String parameter) {
	            return parameter;
	        }


	}
}
