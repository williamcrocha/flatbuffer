package br.com.williamrocha.flatbuffer.fb;

import br.com.williamrocha.flatbuffer.dto.ProductDTO;
import com.google.flatbuffers.FlatBufferBuilder;

import java.nio.ByteBuffer;

public class ProductBufferBuilder {

    public static ByteBuffer getProductBuffer(ProductDTO productDTO){
        FlatBufferBuilder builder = new FlatBufferBuilder();
        // You need create references before call Product.startProduct(builder)
        int productName = 0;
        int productDescription=0;
        int productPartNumber=0;
        if(productDTO.getName() !=null) {
            productName = builder.createString(productDTO.getName());
        }
        if(productDTO.getDescription()!=null) {
            productDescription = builder.createString(productDTO.getDescription());
        }
        if(productDTO.getPartNumber()!=null) {
            productPartNumber = builder.createString(productDTO.getPartNumber());
        }

        Product.startProduct(builder);
        if(productDTO.getId() != null) {
            Product.addId(builder, productDTO.getId());
        }
        if(productDTO.getName()!=null) {
            Product.addName(builder,productName);
        }
        if(productDTO.getDescription()!=null) {
            Product.addDescription(builder, productDescription);
        }
        if(productDTO.getPartNumber()!=null) {
            Product.addPartNumber(builder, productPartNumber);
        }

        builder.finish(Product.endProduct(builder));

        return builder.dataBuffer();
    }

    public static ProductDTO getProductDTO(ByteBuffer byteBuffer){
        Product product = Product.getRootAsProduct(byteBuffer);
        return ProductDTO.builder()
                .id(product.id())
                .name(product.name())
                .description(product.description())
                .partNumber(product.partNumber())
                .build();
    }
}
