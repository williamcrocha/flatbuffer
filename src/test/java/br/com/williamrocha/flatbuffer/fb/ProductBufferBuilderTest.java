package br.com.williamrocha.flatbuffer.fb;

import br.com.williamrocha.flatbuffer.dto.ProductDTO;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductBufferBuilderTest {

    @Test
    void whenProductWithIdNull_thenReturnProductWithIdZero(){
        ByteBuffer byteBuffer = ProductBufferBuilder.getProductBuffer(
                ProductDTO.builder().build()
        );
        ProductDTO productDTO = ProductBufferBuilder.getProductDTO(byteBuffer);
        assertEquals(0,productDTO.getId());
    }

    @Test
    void whenProductWithName_thenReturnProductWithName(){
        ByteBuffer byteBuffer = ProductBufferBuilder.getProductBuffer(
                ProductDTO.builder().name("test").build()
        );
        ProductDTO productDTO = ProductBufferBuilder.getProductDTO(byteBuffer);
        assertEquals("test",productDTO.getName());
    }

    @Test
    void whenProductWithDescription_thenReturnProductWithDescription(){
        ByteBuffer byteBuffer = ProductBufferBuilder.getProductBuffer(
                ProductDTO.builder().description("test").build()
        );
        ProductDTO productDTO = ProductBufferBuilder.getProductDTO(byteBuffer);
        assertEquals("test",productDTO.getDescription());
    }

    @Test
    void whenProductWithPartNumber_thenReturnProductWithPartNumber(){
        ByteBuffer byteBuffer = ProductBufferBuilder.getProductBuffer(
                ProductDTO.builder().partNumber("test").build()
        );
        ProductDTO productDTO = ProductBufferBuilder.getProductDTO(byteBuffer);
        assertEquals("test",productDTO.getPartNumber());
    }

    @Test
    void whenConvertBackProductDTO_thenMustBeEquals(){
        ProductDTO productDTO_1 = ProductDTO.builder()
                .id(1)
                .name("name")
                .description("description")
                .partNumber("part number")
                .build();
        ByteBuffer byteBuffer = ProductBufferBuilder.getProductBuffer(productDTO_1);

        ProductDTO productDTO_2 = ProductBufferBuilder.getProductDTO(byteBuffer);
        assertEquals(productDTO_1,productDTO_2);
    }

}