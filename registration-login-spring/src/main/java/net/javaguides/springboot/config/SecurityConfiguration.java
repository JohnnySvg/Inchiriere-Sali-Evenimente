package net.javaguides.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.javaguides.springboot.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	/*
	@Bean
	  public AuthenticationManager manager(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
		
		return auth.build();
	}
	*/
	
	@Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests(auth -> auth.requestMatchers(
		    		 "/registration**",
		    		 "/js**",
		    		 "/css**",
		    		 "/img**",
		    		 "/*.css",
		    		 "/*.js",
		    		 "/*.html",
		    		 "/despre**",
		    		 "/salaPalatului**"
		    		  ).permitAll()
	    		.anyRequest().authenticated())
		     .formLogin(form -> form.loginPage("/login").permitAll())
		     .logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true)
		    		 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		    		 .logoutSuccessUrl("/login?logout").permitAll());
	     
	    
	    return http.build();
	   
	}
}


