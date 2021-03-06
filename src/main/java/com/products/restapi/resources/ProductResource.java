package com.products.restapi.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.restapi.error.ResourceNotFoundException;
import com.products.restapi.models.Product;
import com.products.restapi.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="REST API PRODUCTS")
@CrossOrigin(origins="*")
public class ProductResource {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value="Returns a list of products")
	public List<Product> getProducts() {
		 return productRepository.findAll();
	}
	
	@GetMapping("/products/{id}")	 
	@ApiOperation(value="Returns a unique product")
	public Product getProduct(@PathVariable(value="id")long id) {
		verifyIfProductExists(id); 
		return productRepository.findById(id);
	}
	
	@PostMapping("/product")
	@ApiOperation(value="Create a product")
	public Product postProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/product/{id}")
	@ApiOperation(value="Delete a product")
	public void deleteProduct(@PathVariable(value="id")long id) {
		verifyIfProductExists(id);
		productRepository.deleteById(id);
	}
	
	@PutMapping("/product")
	@ApiOperation(value="Updates a product")
	public Product updateProduct(@RequestBody Product product) {
		verifyIfProductExists(product.getId());
		return productRepository.save(product);
	}
	
	private void verifyIfProductExists(long id) {
		if (productRepository.findById(id) == null)
			throw new ResourceNotFoundException("Product not found for ID: " + id);
	}
}
