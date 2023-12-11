package com.syntacticsuger.bookmyshow;

import com.syntacticsuger.bookmyshow.controllers.UserController;
import com.syntacticsuger.bookmyshow.dto.SignupRequestDTO;
import com.syntacticsuger.bookmyshow.dto.SignupResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class BookmyshowApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;
    public static void main(String[] args) {
        SpringApplication.run(BookmyshowApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
        signupRequestDTO.setEmail("test2@gmail.com");
        signupRequestDTO.setPassword("password");
        SignupResponseDTO response = userController.signUp(signupRequestDTO);
    }
}
