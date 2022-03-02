package com.test.hplusapp.config;

import com.sun.xml.bind.v2.runtime.unmarshaller.XmlVisitor;
import com.test.hplusapp.converters.StringToGenderConverter;
import com.test.hplusapp.interceptors.LoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

import javax.sql.rowset.spi.XmlReader;

@Configuration
@ComponentScan(basePackages = "com.test.hplusapp")
public class ApplicationConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("css/**", "images/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/images/");
    }

//     resolving views through xml file
//     views.xml file is used for reolving views xml ways.
    @Bean
    public XmlViewResolver xmlViewResolver(){
        XmlViewResolver viewResolver = new XmlViewResolver();
        viewResolver.setLocation(new ClassPathResource("views.xml"));

        // chaining the view resolver
        viewResolver.setOrder(1);

        return viewResolver;
    }

//     internalviewresolver
    @Bean
    public InternalResourceViewResolver jspViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);

        // chaining the view resolver
        viewResolver.setOrder(2);

        return viewResolver;
    }

//     resolving views through properties file
//     it will use views.properties file
//    @Bean
//    public ResourceBundleViewResolver resourceBundleViewResolver(){
//        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
//        viewResolver.setBasename("views");
//        return viewResolver;
//    }


    // to add our gender converter in formatters so that spring knows about it.
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToGenderConverter());
    }



    // adding our custom LoggingInterceptor in registry so that spring knows about it-
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/*");
    }
}
