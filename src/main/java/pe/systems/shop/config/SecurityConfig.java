package pe.systems.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import pe.systems.shop.service.UserDetailsServiceImpl;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = UserDetailsServiceImpl.class)
public class SecurityConfig  extends  WebSecurityConfigurerAdapter{
	
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/faces/**", "/javax.faces.resource/**", "/resources/**", "/faces/reporte/**","/photosproductos/**","/photos/**","/photosfondos/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/login**").permitAll()
                .antMatchers("/registro**").permitAll()
                .antMatchers("/inicio**").permitAll()
                .antMatchers("/verproducto**").permitAll()
                .antMatchers("/productos**").permitAll()
                .antMatchers("/historia**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .rememberMe();
    }

    @Autowired
    public void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
