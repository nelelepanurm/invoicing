package com.schoolproject.invoicing;



import com.schoolproject.invoicing.exception.ApplicationException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Integer createUser(String userName,String password){
        if (userName == null || userName.isBlank()) {
            throw new ApplicationException("Username is not filled.");
        }
        if (password == null || password.isBlank()) {
            throw new ApplicationException("Password is not filled.");
        }
        //String sql = "SELECT EXISTS(SELECT*FROM newuser WHERE user_name = :userName)";
        boolean doesExist = userRepository.checkData(userName);
        if (doesExist == true) {
            throw new ApplicationException("Username already exists. Please choose new one.");
        }
        String encodedPassword = passwordEncoder.encode(password);
        return userRepository.createUser(userName,encodedPassword);
    }

    public String login(String userName,String password){
        String encodedPassword = userRepository.getPassword(userName);
        if(passwordEncoder.matches(password, encodedPassword)) {
            JwtBuilder builder = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, "secret")
                    .claim("username", userName);
            return builder.compact();
        }else{
            throw new ApplicationException("Wrong password");

        }
    }

    public UserDTO findUserByName (String userName) {
        return userRepository.findUserByName(userName);
    }
}
