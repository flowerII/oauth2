package cn.qianshu.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cn.qianshu.oauth2.service.VUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired  
    private VUserDetailsService userDetailsService;

	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式
        return new BCryptPasswordEncoder();
    }
	
	/*@Bean
    @Override
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义认证与授权
    	//System.out.println("password encode:"+new BCryptPasswordEncoder().encode("123456"));
        auth.userDetailsService(userDetailsService);
    }
	
	/*protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//System.out.println("secret is:"+new BCryptPasswordEncoder().encode("secret"));
		System.out.println("password encode:"+new BCryptPasswordEncoder().encode("123456"));

        auth.inMemoryAuthentication()
                // 在内存中创建用户并为密码加密
                .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");

    }*/
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 将 check_token 暴露出去，否则资源服务器访问时报 403 错误
        web.ignoring().antMatchers("/oauth/check_token");
    }
}
