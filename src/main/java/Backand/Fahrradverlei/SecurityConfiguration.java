package Backand.Fahrradverlei;



	import java.util.Arrays;

	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.web.cors.CorsConfiguration;
	import org.springframework.web.cors.CorsConfigurationSource;
	import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

	@Configuration
	@EnableWebSecurity
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {auth.inMemoryAuthentication()
	        .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
	        .and()
	        .withUser("admin").password(passwordEncoder().encode("password")).roles("ADMIN");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
			        .authorizeRequests()
			        .anyRequest()
			        .permitAll()
			        .and()
			        .cors()
	                .configurationSource(corsConfigurationSource())
	                .and()
			        .csrf().disable()
	        ;
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    } 

	    @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();

	        configuration.setAllowedOrigins(Arrays.asList(
	        		"https://localhost/",
	        		"https://localhost:3000/",
	        		"http://localhost/",
	        		"http://localhost:3000/",
	        		"http://localhost:5173"));
	        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "DELETE", "PATCH", "POST"));
	        configuration.setAllowCredentials(true);
	        configuration.setAllowedHeaders(Arrays.asList("*"));

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);

	        return source;
	    }
	} 


