package com.cybersoft.cozastoreJava21.Config;

import com.cybersoft.cozastoreJava21.Filter.JwtFilter;
import com.cybersoft.cozastoreJava21.Provider.CustomAuthenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableSpringConfigured
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    // day la filter dung de custom rule lien quan toi link
    //hoac cau hinh cua security
    //java 8,11: antMathchers
    //java 17+: requestAntmathchers
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
    return http.csrf().disable()   // tat cau hinh lien quan toi tan cong csrf
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //khai bao khong su dung session trong project
            .and()
            .authorizeHttpRequests()// quy dinh lai cac rule lien quan toi chung thuc cho link dc goi
            .requestMatchers("/signin","/signup").permitAll()

            .anyRequest().authenticated()// tat ca cac link con lai deu phai kiem tra

            .and()
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }


    @Autowired
    private CustomAuthenProvider customAuthenProvider;
    @Autowired
        private JwtFilter jwtFilter;
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)

                .authenticationProvider(customAuthenProvider)

                .build();
    }
    
}
