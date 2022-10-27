package lk.com.reddit.service;

import lk.com.reddit.dto.RegisterRequest;
import lk.com.reddit.model.AppUser;
import lk.com.reddit.model.VerificationToken;
import lk.com.reddit.repository.UserRepository;
import lk.com.reddit.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 10/26/2022
 */
@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;

    public AuthService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                       VerificationTokenRepository verificationTokenRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.verificationTokenRepository = verificationTokenRepository;
    }

    @Transactional
    public void signUp(RegisterRequest registerRequest) {
        AppUser user = new AppUser();
        user.setAppUserName(registerRequest.getUserName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        user.setCreated(Instant.now());
        user.setEnabled(false);
        userRepository.save(user);
        generateVerificationToken(user);
    }

    public void generateVerificationToken(AppUser user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setAppUser(user);
        verificationTokenRepository.save(verificationToken);
    }

}
