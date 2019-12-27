package ru.reksoft.interns.carstore.jwt;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.dao.UsersRepository;
import ru.reksoft.interns.carstore.entity.Users;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    Users users = usersRepository.getByLogin(username);
	    if (users!=null) {
	        return new User(users.getLogin(),passwordEncoder.encode(users.getPassword()), Arrays.asList(new SimpleGrantedAuthority(users.getRule())));
        }
	    else {
	        throw new UsernameNotFoundException("User not found with username: " + username);
        }
	}
}