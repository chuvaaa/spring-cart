package cart.controller;

import cart.application.ProductService;
import cart.controller.dto.ProductRequest;
import cart.controller.dto.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author minsukim on 2023/05/07
 * @project jwp-cart
 * @description
 */
@RestController
@RequestMapping("/products")
public class ProductAdminApiController {

    private final ProductService productService;

    public ProductAdminApiController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest request) {

        ProductResponse response = productService.createProduct(request);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody @Valid ProductRequest request, @PathVariable int id) {
        ProductResponse response = productService.updateProduct(request, id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable int id) {

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }
}
