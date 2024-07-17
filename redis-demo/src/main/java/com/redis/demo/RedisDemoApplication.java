package com.redis.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.demo.model.Product;
import com.redis.demo.repo.ProductRepo;

@SpringBootApplication
@RestController
@RequestMapping("/product")

public class RedisDemoApplication {
	
	@Autowired
	private ProductRepo repo;
	
	@PostMapping("/save")
	public Product save(@RequestBody Product p) {
		return repo.save(p);
	}
	
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return repo.findProductById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String remove(@PathVariable int id) {
		return repo.deleteProduct(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}

}
