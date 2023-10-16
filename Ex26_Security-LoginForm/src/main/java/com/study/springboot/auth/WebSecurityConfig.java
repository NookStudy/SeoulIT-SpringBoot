package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType; 

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {  

	@Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf((csrf) -> csrf.disable())
		.cors((cors) -> cors.disable())
    	.authorizeHttpRequests(request -> request  
    		/*
    			스프링 부트 3.0부터 적용된 스프링 시큐리티 6.0 에서 forward 방식 페이지 
    			이동에도 default로 인증이 걸리도록 변경되어서 JSP나 타임리프 등 컨트롤러에서 
    			화면 파일명을 리턴해 ViewResolver가 작동해 페이지 이동을 하는 경우 이처럼 
    			설정을 해야 한다.
    		*/
    		.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
    		
    		// 	/ : 모든 요청명에 대해 권한없이 접근할 수 있다.
    		.requestMatchers("/").permitAll()
    		//정적 리소스(static하위)에는 권한없이 접근할 수 있다.
            .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
            //권한없이 접근할 수 있다.
            .requestMatchers("/guest/**").permitAll()  // 모두에게 허용.
            //USER, ADMIN 권한 중 하나가 있어야 접근할 수 있다.
            .requestMatchers("/member/**").hasAnyRole("USER", "ADMIN") // 두권한 허용
            //ADMIN 권한만 접근 할 수 있다.
            .requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN만 허용
            .anyRequest().authenticated()	// 어떠한 요청이라도 인증 필요
        );
    //로그인 페이지 설정(시큐리티의 디폴트 페이지를 사용한다.)
    http.formLogin((formLogin) ->
				    formLogin.loginPage("/loginForm") 			// default : /login
				    .loginProcessingUrl("/j_spring_security_check")	// 바꾸면 안됨.
				    .failureUrl("/loginError") 			// default : /login?error
				    //.defaultSuccessUrl("/")
				    .usernameParameter("j_username")	// default : j_username
				    .passwordParameter("j_password") 	// default : j_password
    				.permitAll()); // 기본 로그인 페이지	
    
    http.logout((logout) ->
			    logout.logoutUrl("/logout") // default
			    .logoutSuccessUrl("/")	// 처음 페이지로
				.permitAll());	// 로그 아웃 기본 설정 (/logout으로 인증 해제)
    

        
        // ssl을 사용하지 않으면 true로 사용
        // 테스트 할때는 disable로 해야함. 우리가 localhost를 사용하기때문에 enabled이면 로그인 안됨.
        
		return http.build();  
    }
 
	@Bean
    // users() 메서드는 빠른 테스트를 위해 등록이 간단한 inMemory 방식의 인증 사용자를 등록
    protected UserDetailsService users() 
    {
        UserDetails user = User.builder()
        		.username("user")
        		.password(passwordEncoder().encode("1234"))
        		.roles("USER")	// ROLE_USER 에서 ROLE_ 자동으로 붙는다.
        		.build();
        UserDetails admin = User.builder()
        		.username("admin")
        		.password(passwordEncoder().encode("1234"))
        		.roles("USER", "ADMIN")	
        		.build();
        
        // 메모리에 사용자 정보를 담는다.
        return new InMemoryUserDetailsManager(user, admin);
    }
    
    // passwordEncoder() 추가   //버전업 되면서 아래와 같이 수정됨.
    public PasswordEncoder passwordEncoder() {
      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
