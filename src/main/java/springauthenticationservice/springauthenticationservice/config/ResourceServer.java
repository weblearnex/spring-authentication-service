package springauthenticationservice.springauthenticationservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
class ResourceServer extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/users")
		.and().
		authorizeRequests()
		.anyRequest()
		.access("#oauth2.hasScope('read')")
		.antMatchers("/")
		.permitAll();
	}
}