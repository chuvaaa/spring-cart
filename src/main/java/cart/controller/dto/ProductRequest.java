package cart.controller.dto;

import cart.domain.Product;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Getter
@ToString
public class ProductRequest {

    @Size(max = 10, message = "10글자를 넘을 수 없습니다")
    private String name;

    @Size(max = 200)
    private String image;

    @Digits(integer = 10, fraction = 0)
    private int price;

    public Product productOf() {
        return Product.of(name, image, price);
    }
}
