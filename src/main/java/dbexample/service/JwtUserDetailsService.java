package dbexample.service;

import dbexample.entity.DAOUser;
import dbexample.model.UserDTO;
import dbexample.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*
        JWTUserDetailsService implements the Spring Security UserDetailsService interface.
        It overrides the loadUserByUsername for fetching user details from the database using the username.
        The Spring Security Authentication Manager calls this method for getting the user details from the database
        when authenticating the user details provided by the user. Here we are getting the user details from a hardcoded
        User List. In the next tutorial we will be adding the DAO implementation for fetching User Details from the Database.
        Also the password for a user is stored in encrypted format using BCrypt.
        Previously we have seen Spring Boot Security - Password Encoding Using Bcrypt.
        Here using the Online Bcrypt Generator you can generate the Bcrypt for a password.
        */
@Service
public class JwtUserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    //@Override
    public UserDetails loadUserByUsername(String username)
                        throws UsernameNotFoundException{
        DAOUser user = userDAO.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with user:"+username);
            }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
                new ArrayList<>());

    }
    public DAOUser save(UserDTO user){
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDAO.save(newUser);
    }

}
