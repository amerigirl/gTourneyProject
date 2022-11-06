package TournamentOrganizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

    //  Creates a spring-managed object to allow the app to access our filter
    @Bean
    public AuthenticationFilter authenticationFilter() { //creates an object to allow the app access to the filter
        return new AuthenticationFilter();
    }


    // Register the filter with the Spring container
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( authenticationFilter() );
    }

}

