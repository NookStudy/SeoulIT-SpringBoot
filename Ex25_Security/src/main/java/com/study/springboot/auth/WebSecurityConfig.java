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

@Configuration	// 설정으로 쓰이는 빈
@EnableWebSecurity  // 이것을 시큐리티라고 함.
public class WebSecurityConfig  {  

	@Bean  // 변경된 코드
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {  
        http.authorizeRequests()  // 인증된 요청, 폴더 마다 권한을 줌.
    		.antMatchers("/").permitAll()
            .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
            .antMatchers("/guest/**").permitAll()  // 모두에게 허용.
            .antMatchers("/member/**").hasAnyRole("USER", "ADMIN") // 두권한 허용
            .antMatchers("/admin/**").hasRole("ADMIN") // ADMIN만 허용
            .anyRequest().authenticated();
        
        // 기본 로그인 폼 부트스트랩으로 되어 있어 디자이너가 변경 못함. 안씀
        http.formLogin()	
                .permitAll();
 
        http.logout()	// 기본으로 되어있음.
                .permitAll();
        
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

    
    // passwordEncoder() 추가   
    // 버전업 되면서 아래와 같이 수정됨.
    // 내부적으로 접두어를 붙일 수 있도록 직접 패스워드인코더를 지정하지 않는다.
    public PasswordEncoder passwordEncoder() {
      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
