package com.imagine.book.services.impl;

import com.imagine.book.exceptions.DuplicateUsernameException;
import com.imagine.book.exceptions.InvalidPasswordException;
import com.imagine.book.exceptions.InvalidUsernameException;
import com.imagine.book.model.entity.User;
import com.imagine.book.repositories.UserRepository;
import com.imagine.book.services.UsersService;
import com.imagine.book.utils.GenerateRandomHexCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService
{
    public static final AtomicInteger userId = new AtomicInteger(-1);
    public static final StringBuilder authToken = new StringBuilder();

    @Autowired
    private UserRepository userRepository;
    @Override
    public String register(String firstName, String lastName, String username, String password)
    {
        try
        {
            Optional<User> userOptional = userRepository.findByUserName(username);
            if(userOptional.isEmpty())
            {
                User user = User.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .username(username)
                        .password(password).build();
                userRepository.save(user);

                return "User registered";
            }
            else
                throw new DuplicateUsernameException("Username is already registered. " +
                        "Please try a different username");
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String login(String username, String password)
    {
        try
        {
            Optional<User> userOptional = userRepository.findByUserName(username);
            if(userOptional.isPresent())
            {
                User user = userOptional.get();
                if(password.equals(user.getPassword()))
                {
                    userId.set(user.getUserId());
                    authToken.append(GenerateRandomHexCode.generateHex());
                    return "Login successful.";
                }
                else
                    throw new InvalidPasswordException("Password is incorrect.");
            }
            else
                throw new InvalidUsernameException("Invalid username.");
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            e.printStackTrace();

            return e.getMessage();
        }
    }

    @Override
    public String logout()
    {
        try
        {
            userId.set(-1);
            authToken.setLength(0);

            return "Logout successful";
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            e.printStackTrace();

            return e.getMessage();
        }
    }
}
