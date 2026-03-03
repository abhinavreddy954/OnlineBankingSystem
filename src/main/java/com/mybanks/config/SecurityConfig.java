package com.mybanks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.mybanks.security.CustomAuthenticationFailureHandler;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable()) // enable in prod if using cookies
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/login", "/public/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin(form -> form
//                .loginPage("/login")
//                .defaultSuccessUrl("/", true)
//                .permitAll()
//            )
//            .logout(logout -> logout
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .clearAuthentication(true)
//                .permitAll()
//            );
//
//        return http.build();
//    }
//}


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	@Bean
//	@Order(1)
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//	    http
//	        .csrf(csrf -> csrf.disable())
//
//	        .authorizeHttpRequests(auth -> auth
//	            .requestMatchers("/", "/home", "/user/login", "/perform_userlogin").permitAll()
//	            .requestMatchers("/customer/**").authenticated()
//	            .anyRequest().permitAll()   // IMPORTANT CHANGE
//	        )
//
//	        .formLogin(form -> form
//	            .loginPage("/user/login")
//	            .loginProcessingUrl("/perform_userlogin")
//	            .defaultSuccessUrl("/customer", true)
//	            .failureUrl("/user/login?error=true")
//	            .permitAll()
//	        )
//	        
//	        .logout(logout -> logout
//	            .logoutUrl("/user/logout")
//	            .logoutSuccessUrl("/user/login")
//	            .permitAll()
//	        );
//	      
//	       
//
//	    return http.build();
//	}
//	
//	
//    //WORKER SECURITY 
//    @Bean
//    @Order(2)
//    public SecurityFilterChain workerSecurity(HttpSecurity http) throws Exception {
//    	
//    	 http
//	        .csrf(csrf -> csrf.disable())
//
//	        .authorizeHttpRequests(auth -> auth
//	            .requestMatchers("/", "/home", "/worker/login", "/perform_workerlogin").permitAll()
//	            .requestMatchers("/worker/**").authenticated()
//	            .anyRequest().permitAll()   // IMPORTANT CHANGE
//	        )
//
//            .formLogin(form -> form
//                .loginPage("/worker/login")
//                .loginProcessingUrl("/perform_workerlogin")
//                .defaultSuccessUrl("/employee", true)
//                .failureUrl("/worker/login?error=true")
//            )
//
//            .logout(logout -> logout
//                .logoutUrl("/worker/logout")
//                .logoutSuccessUrl("/worker/login")
//            );
//
//        return http.build();
//    }
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}
//
//
//
//}







//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Autowired
//	private CustomAuthenticationFailureHandler failureHandler;
//
//    // ================= USER SECURITY =================
//    @Bean
//    @Order(1)
//    public SecurityFilterChain userSecurity(HttpSecurity http) throws Exception {
//
//       /* http
//          .securityMatcher("/customer/**", "/user/**", "/perform_userlogin","/editbankinternetaccountdetails","/fetchAllAddressforNewACC")
//
//            .csrf(csrf -> csrf.disable())
//
//            .authorizeHttpRequests(auth -> auth
//            	    .requestMatchers("/user/login").permitAll()
//            	    .requestMatchers("/customer/**").hasRole("USER")
//            	    .anyRequest().authenticated()
//            	)*/
//    	   http
//           .securityMatcher("/customer/**", "/user/**", "/perform_userlogin")
//           .csrf(csrf -> csrf.disable())
//
//           .authorizeHttpRequests(auth -> auth
//               .requestMatchers("/user/login").permitAll()
//               .requestMatchers("/customer/**").hasRole("USER")
//               .anyRequest().authenticated()  // ALWAYS LAST
//           )
//           
//
//
//            .formLogin(form -> form
//                .loginPage("/user/login")
//                .loginProcessingUrl("/perform_userlogin")
//                .defaultSuccessUrl("/customer", true)
//                .failureHandler(failureHandler)
//                //.failureUrl("/user/login?error=true")
//            )
//
//            .logout(logout -> logout
//                .logoutUrl("/user/logout")
//                .logoutSuccessUrl("/user/login")
//                );
//
//        return http.build();
//    }
//
//    // ================= WORKER SECURITY =================
//    @Bean
//    @Order(2)
//    public SecurityFilterChain workerSecurity(HttpSecurity http) throws Exception {
//
//        http
//            .securityMatcher("/employee/**", "/worker/**", "/perform_workerlogin")
//            .csrf(csrf -> csrf.disable())
//
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/worker/login", "/perform_workerlogin").permitAll()
//                .anyRequest().authenticated()
//            )
//
//            .formLogin(form -> form
//                .loginPage("/worker/login")
//                .loginProcessingUrl("/perform_workerlogin")
//                .defaultSuccessUrl("/employee", true)
//                .failureHandler(failureHandler)
//                //.failureUrl("/worker/login?error=true")
//            )
//
//            .logout(logout -> logout
//                .logoutUrl("/worker/logout")
//                .logoutSuccessUrl("/worker/login")
//            );
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}




@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomAuthenticationFailureHandler failureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);

        provider.setHideUserNotFoundExceptions(false); 

        return provider;
    }

    @Bean
    @Order(1)
    public SecurityFilterChain userSecurity(HttpSecurity http,
                                            DaoAuthenticationProvider provider) throws Exception {

        http
            .securityMatcher("/customer/**", "/user/**", "/perform_userlogin")
            .authenticationProvider(provider)  
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/login").permitAll()
                .requestMatchers("/customer/**").hasRole("USER")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/user/login")
                .loginProcessingUrl("/perform_userlogin")
                .defaultSuccessUrl("/customer", true)
                .failureHandler(failureHandler)
            )
            .logout(logout -> logout
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/user/login")
            );

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain workerSecurity(HttpSecurity http,
                                              DaoAuthenticationProvider provider) throws Exception {

        http
            .securityMatcher("/employee/**", "/worker/**", "/perform_workerlogin")
            .authenticationProvider(provider) 
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/worker/login", "/perform_workerlogin").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/worker/login")
                .loginProcessingUrl("/perform_workerlogin")
                .defaultSuccessUrl("/employee", true)
                .failureHandler(failureHandler)
            )
            .logout(logout -> logout
                .logoutUrl("/worker/logout")
                .logoutSuccessUrl("/worker/login")
            );

        return http.build();
    }
}



