package br.com.williamrocha.flatbuffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FlatbufferApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FlatbufferApplication.class)
                .web(WebApplicationType.NONE)
                        .run(args);
    }

}
