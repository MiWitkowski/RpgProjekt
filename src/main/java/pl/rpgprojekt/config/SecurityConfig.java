package pl.rpgprojekt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource())
                .passwordEncoder(passwordEncoder())
               /* .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder().encode("user123")).roles("ADMIN")
               */;
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .csrf().disable()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
    }


    @Bean
    public DataSource dataSource () {
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/rpg_projekt");
        dataSource.setUsername("root");
        dataSource.setPassword("coderslab");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }


}