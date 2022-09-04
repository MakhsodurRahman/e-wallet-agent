package com.ewallet.ewalletagent.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AgentRequestDto {

    private String userName;
    private String displayName;
    private String fullName;
    private String birthDate;
    private String address;
    private String phoneNumber;
    private String nidNumber;
    private String email;
    private String gender;
    private String pin;
    private String status;
    private String role;
    private MultipartFile profilePhoto;
    private MultipartFile nidCardPhoto;
}
