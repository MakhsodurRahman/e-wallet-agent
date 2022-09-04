package com.ewallet.ewalletagent.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AgentResponseDto {

    private Long id;
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
    private String profilePhotoUrl;
    private String nidCardPhotoUrl;
}
