package com.syntacticsuger.bookmyshow.controllers;

import com.syntacticsuger.bookmyshow.dto.ResponseStatus;
import com.syntacticsuger.bookmyshow.dto.SignupRequestDTO;
import com.syntacticsuger.bookmyshow.dto.SignupResponseDTO;
import com.syntacticsuger.bookmyshow.models.User;
import com.syntacticsuger.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public SignupResponseDTO signUp(SignupRequestDTO signupRequestDTO){
        SignupResponseDTO response = new SignupResponseDTO();
        try {
            User user = userService.signUp(signupRequestDTO.getEmail(), signupRequestDTO.getPassword());
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setUserId(user.getId());
        }catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
