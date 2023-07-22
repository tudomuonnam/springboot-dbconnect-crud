package dbexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class WebSecurityConfig {
//    @Autowired
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;
//    @Autowired
//    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        // configure AuthenticationManager so that it knows from where to load
//        // user for matching credentials
//        // Use BCryptPasswordEncoder
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    public JwtRequestFilter getJwtRequestFilter() {
//        return jwtRequestFilter;
//    }
//
//    public void setJwtRequestFilter(JwtRequestFilter jwtRequestFilter) {
//        this.jwtRequestFilter = jwtRequestFilter;
//    }
////
////    @Bean
////    @Override
////    public AuthenticationManager authenticationManagerBean() throws Exception{
////        return super.authenticationManagerBean();
////    }
////    @Bean
//////    protected void configure(HttpSecurity httpSecurity) throws Exception{
//////        //We don't need CFRS in this example
////////        httpSecurity.csrf().disable().
////////                authorizeHttpRequests()
//////
//////
//////    }
////    public WebSecurityCustomizer webSecurityCustomizer(){
////        return (web -> web.ignoring().antMatcher("/authenticate", "/register"))
////    }

}
