package mk.finki.ukim.mk.lab1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

import java.util.Locale;

@OpenAPIDefinition(
        info = @Info(
                description = "Open API specification",
                title = "Open API for book rent",
                version = "1.0"
        ),
//        servers = {
//                @Server(
//                        description = "Local ENV",
//                        url = "https://localhost:8080"
//                ),
//                @Server(
//                        description = "PROD ENV",
//                        url = "https://something.com"
//                )
//        },
        security = {
                @SecurityRequirement(
                        name="bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
