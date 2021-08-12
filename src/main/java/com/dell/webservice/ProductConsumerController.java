package com.dell.webservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dell.webservice.entity.Product;

@RestController
@RequestMapping("/api/consumer")
public class ProductConsumerController {
	
	@GetMapping("/products/{id}")
	public Product fetchProduct(@PathVariable("id") long id) {
		// consume api
		// define a http url 
		String url = "http://localhost:9000/api/products/"+id;
		
		// use rest template
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Product> product = restTemplate.getForEntity(url, Product.class);
		
		return product.getBody();
	}

	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
		// consume api
		// define a http url 
		String url = "http://localhost:9000/api/products/"+id;
		
		// use rest template
		RestTemplate restTemplate = new RestTemplate();
		
		 restTemplate.put(url, product);
		
		return "product updated !";
	}
}
