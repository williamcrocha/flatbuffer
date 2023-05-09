package br.com.williamrocha.flatbuffer;

import br.com.williamrocha.flatbuffer.dto.ProductDTO;
import br.com.williamrocha.flatbuffer.fb.ProductBufferBuilder;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;

@Slf4j
@Service
public class ExampleService {

    @PostConstruct
    public void run(){
        ProductDTO productDTO_1 = ProductDTO.builder()
                .id(1)
                .name("name")
                .description("description")
                .partNumber("part number")
                .build();
        ByteBuffer byteBuffer = ProductBufferBuilder.getProductBuffer(productDTO_1);

        ProductDTO productDTO_2 = ProductBufferBuilder.getProductDTO(byteBuffer);
        final String line = "--------------------------------------------------------";
        log.info(line);
        log.info("ProductDTO_1: {}",productDTO_1);
        log.info("ProductDTO_2: {}",productDTO_2);
        log.info("Equals? {}",productDTO_1.equals(productDTO_2));
        log.info(line);
    }
}
