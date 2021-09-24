package pl.sda.security;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.sda.model.Role;
import pl.sda.service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/logout", "/users/register","/", "/trips/mainpage","/hotels/all","/trips/all")
                .permitAll()


                .and()
//                .authorizeRequests()
//                .antMatchers("users/{userId}", "/trips/all", "/trips/{tripId}","/trips/mainpage",
//                "/hotels/{hotelId}", "/hotels/all")
//                .hasRole("ROLE_" + Role.USER)
//                .and()

                .authorizeRequests()
                .antMatchers("/users/**", "/trips/**","/hotels/**")
                .hasRole(Role.ADMIN.name())

                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .permitAll();

    }
}
