package jdc.spring.accountwebservice.documentation;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
            new Info()
                    .title("Account Fetcher Web Service")
                    .version("1.0.0")
                    .contact(
                            new Contact()
                                .email("deniscernat@gmail.com")
                                .name("Denis Cernat")
                    )
        );
    }
}
