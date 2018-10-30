package VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;
    private Integer type;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
