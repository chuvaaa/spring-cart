package cart.product.application;

import cart.product.controller.dto.ProductRequest;
import cart.product.controller.dto.ProductResponse;
import cart.product.domain.Product;
import cart.product.domain.Products;
import cart.product.infra.ProductDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author minsukim on 2023/05/07
 * @project jwp-cart
 * @description
 */
@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional
    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = productRequest.productOf();
        productDao.create(product);
        return ProductResponse.of(product);
    }

    @Transactional
    public ProductResponse updateProduct(ProductRequest productRequest, int id) {
        Product product = getProductById(id);

        product.updateProduct(productRequest.getName(), productRequest.getImage(), productRequest.getPrice());
        productDao.update(product);
        return ProductResponse.of(product);
    }

    @Transactional
    public void deleteProduct(int id) {
        Product product = getProductById(id);
        productDao.delete(product);
    }

    public List<ProductResponse> getAllProductList() {
        Products products = productDao.findAllProducts();

        return products.CreateProductResponseList();
    }

    public Product getProductById(int id) {
        return productDao.findById(id);
    }
}
