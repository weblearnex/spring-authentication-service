package springauthenticationservice.springauthenticationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

    	
    	
        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/resources/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
        	
            http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/users")
                .hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
                .permitAll().and().logout().permitAll();

            http.csrf().disable();
        }

        @Override
        public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
            authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin")
                .authorities("ROLE_ADMIN");
        }
        
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }
    
   


