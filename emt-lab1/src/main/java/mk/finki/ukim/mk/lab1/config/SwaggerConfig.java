//package mk.finki.ukim.mk.lab1.config;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI()
//                .info(new Info().title("Book API")
//                        .version("1.0")
//                        .description("API за менаџирање на книги"))
//                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))  // Барање за најавување
//                .components(new io.swagger.v3.oas.models.Components()
//                        .addSecuritySchemes("basicAuth", new SecurityScheme()
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("basic")));
//    }
//}