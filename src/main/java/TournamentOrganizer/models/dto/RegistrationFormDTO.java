package TournamentOrganizer.models.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegistrationFormDTO extends LoginFormDTO {

    private String verifyPassword;


    @NotBlank
    @Email
    private String emailAddress;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
