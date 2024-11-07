package mk.ukim.finki.wpaud.service.implementation;

import mk.ukim.finki.wpaud.model.User;
import mk.ukim.finki.wpaud.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.wpaud.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.wpaud.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.wpaud.repository.InMemoryUserRepository;
import mk.ukim.finki.wpaud.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService {

    private final InMemoryUserRepository userRepository;

    public AuthServiceImplementation(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String firstName, String lastName) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || repeatPassword == null || repeatPassword.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }
        User user = new User(username, password, firstName, lastName);
        userRepository.saveOrUpdate(user);
        return user;
    }
}
