package middleware.e_interceptor02.configurations;

import middleware.e_interceptor02.interseptor.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMvcConfigure implements WebMvcConfigurer {

    @Autowired
    private MonthInterceptor monthInterceptor;

    @Override
    public void addInterceptors (InterceptorRegistry registry){
        registry.addInterceptor(monthInterceptor).addPathPatterns("/months","/user");
    }
}
