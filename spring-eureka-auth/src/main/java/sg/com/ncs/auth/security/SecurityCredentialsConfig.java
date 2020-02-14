package sg.com.ncs.auth.security;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import sg.com.ncs.common.security.JwtConfig;

@EnableWebSecurity // Enable security config. This annotation denotes config for spring security.
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtConfig jwtConfig;

	@Bean
	public CorsFilter corsFilter() {

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // you USUALLY want this
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.setAllowedMethods(Arrays.asList("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				// make sure we use stateless session; session won't be used to store user's
				// state.
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// handle an authorized attempts
				.exceptionHandling()
				.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized")).and()
				// Add a filter to validate user credentials and add token in the response
				// header

				// What's the authenticationManager()?
				// An object provided by WebSecurityConfigurerAdapter, used to authenticate the
				// user passing user's credentials
				// The filter needs this auth manager to authenticate the user.
				.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))
				.authorizeRequests()
				// allow all POST requests
				.antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
				// any other requests must be authenticated
				.anyRequest().authenticated();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		// each Authentication provider is tested in order
		// if one passes then its following Authentication providers are skipped

		// DataBase Authentication
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

		// ldap Authentication
		auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").groupSearchBase("ou=groups").contextSource()
				.url("ldap://localhost:8389/dc=springframework,dc=org").and().passwordCompare()
				.passwordEncoder(new BCryptPasswordEncoder()).passwordAttribute("userPassword");

		/*
		 * LdapContextSource ldapContextSource = new LdapContextSource();
		 * 
		 * ldapContextSource.setUrl("ldap://192.168.XXX.XXX:389");
		 * ldapContextSource.setBase("dc=companyname,dc=com");
		 * ldapContextSource.setUserDn(
		 * "cn=user,cn=testgroup,ou=Test,dc=companyname,dc=com");
		 * ldapContextSource.setPassword("user1234");
		 * ldapContextSource.afterPropertiesSet();
		 * 
		 * // LDAP Authentication auth.ldapAuthentication() // The {0} in the (uid={0})
		 * will be replaced by the username entered in the // form.
		 * .userSearchBase("ou=Group").userSearchFilter("uid={0}")
		 * 
		 * // .userDnPatterns("uid={0},ou=people")//does the same thing
		 * 
		 * // Specifies where the search for Roles start //
		 * .groupSearchBase("ou=mathematicians") // in groups we search for member //
		 * .groupSearchFilter("member={0}") //
		 * .contextSource().ldif("classpath:test-server.ldif");
		 * 
		 * .contextSource(ldapContextSource);
		 */

	}

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}