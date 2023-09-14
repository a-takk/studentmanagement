package com.example.studentmanagement.Security;

import com.example.studentmanagement.Entity.RoleEntity;
import com.example.studentmanagement.Entity.UserEntity;
import com.example.studentmanagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //takes a string param of email and passes it through to the userrepository, queries the
    //database to find a user with the email, if username is null it throws a usernamenotfoundexception
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Could not find email");
        }

        //if user entity is found using the userrepository which finds the email via the database, it will return
        //the email, password and gets a object of role that is mapped and collected into a list, that is linked to the email.
        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                getAuthorities(userEntity.getRoles()));
    }

    //takes a role entity set as an input, uses stream to process the roles and maps the roles to a grantedauthoritiy object
    //and then collects the mapped objects into a list
    private Collection<? extends GrantedAuthority> getAuthorities(Set<RoleEntity> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }
}


