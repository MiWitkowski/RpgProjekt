package pl.rpgprojekt.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@EnableScheduling
@EnableAsync
@ComponentScan(basePackages = {"pl.rpgprojekt"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"pl.rpgprojekt"})
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver () {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
        }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory () {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("rpg_projektPersistenceUnit");
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager (EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm;
    }

    @Override
    public void addViewControllers (ViewControllerRegistry registry) {
        registry.addViewController("/register").setViewName("registerForm");
        registry.addViewController("/login").setViewName("loginForm");
    }
}