package middleware.e_interceptor01.configurations;

import middleware.e_interceptor01.interseptors.ApiLoggingInterceptor;
import middleware.e_interceptor01.interseptors.LegacyIntercepotr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private ApiLoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private LegacyIntercepotr legacyIntercepotr;

    @Override
    public void addInterceptors (InterceptorRegistry registry){
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(legacyIntercepotr);
    }

}
