package com.syntacticsuger.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDTO {
    private ResponseStatus responseStatus;
    private Long userId;
}
