package middleware.e_interceptor02.configurations;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMvcConfigure implements WebMvcConfigurer {



    @Override
    public void addInterceptors (InterceptorRegistry registry){
        //registry.addInterceptor();
    }
}
