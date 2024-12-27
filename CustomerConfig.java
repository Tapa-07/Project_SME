package org.tapa.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.tapa.customer.security.JwtAuthenticationEntryPoint;
import org.tapa.customer.security.JwtAuthenticationFilter;

@Configuration
@EnableMethodSecurity
/** * Configuration class for Spring Security settings. */
public class CustomerConfig {

	@Autowired
	JwtAuthenticationEntryPoint entryPoint;

	@Autowired
	JwtAuthenticationFilter filter;

	/**
	 * * Configures the security filter chain.
	 * 
	 * @param http the HttpSecurity object
	 * @return the SecurityFilterChain object
	 * @throws Exception if there is a security configuration issue.
	 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(config -> config.disable());
		/**
		 * auth.requestMatchers("/api/auth/login").permitAll().anyRequest()----> This
		 * allows all users to access the /api/auth/login endpoint without
		 * authentication.
		 */
		http.authorizeHttpRequests(
				auth -> auth.requestMatchers("/api/auth/login").permitAll().anyRequest().authenticated())
				/**
				 * anyRequest().authenticated())----> This requires authentication for any other
				 * requests.
				 */

				.sessionManagement(smc -> smc.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.exceptionHandling(ehc -> ehc.authenticationEntryPoint(entryPoint))
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	/**
	 * * Creates a PasswordEncoder bean using BCrypt. * *
	 * @return the PasswordEncoder bean
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
