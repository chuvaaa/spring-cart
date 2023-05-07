package cart.application;

import cart.controller.dto.ProductRequest;
import cart.controller.dto.ProductResponse;
import cart.domain.Product;
import cart.domain.Products;
import cart.infra.ProductDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author minsukim on 2023/05/07
 * @project jwp-cart
 * @description
 */
@Service
public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = productRequest.productOf();
        productDao.create(product);
        return ProductResponse.of(product);
    }

    public ProductResponse updateProduct(ProductRequest productRequest, int id) {
        Product product = getProductById(id);

        System.out.println(product.getName());
        product.updateProduct(productRequest.getName(), productRequest.getImage(), productRequest.getPrice());

        return ProductResponse.of(product);
    }

    public List<ProductResponse> getAllProductList() {
        Products products = productDao.findAllProducts();

        return products.CreateProductResponseList();
    }

    public Product getProductById(int id) {
        return productDao.findById(id);
    }
}
