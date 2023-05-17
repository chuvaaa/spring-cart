package cart;

import cart.member.application.MemberService;
import cart.member.controller.dto.MemberResponse;
import cart.product.application.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author minsukim on 2023/05/07
 * @project jwp-cart
 * @description
 */
@Controller
public class PageController {

    private final ProductService productService;
    private final MemberService memberService;

    public PageController(ProductService productService, MemberService memberService) {
        this.productService = productService;
        this.memberService = memberService;
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

        List<MemberResponse> memberResponses = memberService.getAllMembers();
        model.addAttribute("members", memberResponses);

        return "settings";
    }
}
