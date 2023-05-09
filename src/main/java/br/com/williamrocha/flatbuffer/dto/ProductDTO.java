package br.com.williamrocha.flatbuffer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    Integer id;

    String name;

    String description;

    String partNumber;

}
