package com.redisexample.rediscache;

import com.redisexample.rediscache.entity.Product;
import com.redisexample.rediscache.repository.ProductDAO;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
@EnableCaching
public class RedisCacheApplication {

	@Autowired
	private ProductDAO productDAO;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return productDAO.saveProduct(product);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productDAO.findAll();
	}

	@GetMapping("/{id}")
	@Cacheable(key = "#id", value = "Product", unless = "#result.price>1000")
	public Product getById(@PathVariable int id) {
		return productDAO.findById(id);
	}

	@DeleteMapping("/{id}")
	@CacheEvict(key = "#id", value = "Product")
	public String deleteProduct(@PathVariable int id) {
		productDAO.deleteProduct(id);
		return "Product deleted";
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

}
