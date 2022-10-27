package lk.com.reddit.controller;

import lk.com.reddit.dto.RegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Achintha Kalunayaka
 * @since 10/26/2022
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("signup")
    public void signUp(@RequestBody RegisterRequest registerRequest) {

    }
}
