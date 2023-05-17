package cart.member.controller;

import cart.member.application.MemberService;
import cart.member.controller.dto.MemberResponse;
import cart.product.application.ProductService;
import cart.product.controller.dto.ProductRequest;
import cart.product.controller.dto.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author minsukim on 2023/05/07
 * @project jwp-cart
 * @description
 */
@RestController
@RequestMapping("/members")
public class MemberApiController {

    private final MemberService memberService;

    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
    * @description test용
    **/
    @GetMapping("/allMembers")
    public ResponseEntity<List<MemberResponse>> getAllMembers(){

         List<MemberResponse> responses = memberService.getAllMembers();

         return ResponseEntity.ok(responses);
    }

}
