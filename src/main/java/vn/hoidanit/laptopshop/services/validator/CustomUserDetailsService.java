package vn.hoidanit.laptopshop.services.validator;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// Ensure this is your User domain class
import vn.hoidanit.laptopshop.services.UserService;

public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        vn.hoidanit.laptopshop.domain.User user = this.userService.getUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Assuming user.getRoles() returns a collection of roles assigned to the user
        return new User(
                user.getEmail(),
                user.getPassWord(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
