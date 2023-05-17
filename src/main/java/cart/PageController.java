package cart;

import cart.product.application.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author minsukim on 2023/05/07
 * @project jwp-cart
 * @description
 */
@Controller
public class PageController {

    private final ProductService productService;

    public PageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String main(Model model){

        model.addAttribute("products", productService.getAllProductList());

        return "index";
    }

    @GetMapping("/admin")
    public String adminMain(Model model){

        model.addAttribute("products", productService.getAllProductList());

        return "admin";
    }

    @GetMapping("/settings")
    public String settings(Model model) {

        return "settings";
    }
}
