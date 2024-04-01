package com.ckchallenge.product.controller;

import com.ckchallenge.product.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("/")
    public String getHome() {
        return "CK Enerji Java";
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<String> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String nodeJsUrl = "http://localhost:3000/api/";

        ResponseEntity<String> response = restTemplate.getForEntity(nodeJsUrl + "getAllProducts", String.class);
        return response;
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<String> getProduct(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        String nodeJsUrl = "http://localhost:3000/api/";

        ResponseEntity<String> response = restTemplate.getForEntity(nodeJsUrl + "getProduct/" + id, String.class);
        return response;
    }

    @PostMapping()
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        RestTemplate restTemplate = new RestTemplate();
        String nodeJsUrl = "http://localhost:3000/api/addProduct";
        ResponseEntity<String> response = restTemplate.postForEntity(nodeJsUrl, product, String.class);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody Product product) {
        RestTemplate restTemplate = new RestTemplate();
         String nodeJsUrl = "http://localhost:3000/api/updateProduct/" + id;

        restTemplate.put(nodeJsUrl, product);
        return ResponseEntity.ok("Ürün başarıyla güncellendi");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        String nodeJsUrl = "http://localhost:3000/api/deleteProduct/";

        String nodeJsUrlWithId = nodeJsUrl + id;
        restTemplate.delete(nodeJsUrlWithId);
        return ResponseEntity.ok("Ürün başarıyla silindi");
    }


}
