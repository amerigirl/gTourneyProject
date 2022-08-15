package TournamentOrganizer.models;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity {

    @NotBlank(message = "Description is required!")
    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Location is required")
    @NotNull
    @Size(max = 50, message = "Location is too long!")
    private String location;

    @NotBlank(message = "Email required!")
    @Email(message = "Invalid email! Try again!")
    private String contactEmail;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "Date is required!")
    @NotNull
    private String date;

    @NotBlank(message = "Entry Fee is required!")
    @NotNull
    private String entryFee;

    @NotNull
    private TypeOfTournament typeOfTournament;

    @NotBlank(message = "Total audience capacity is required!")
    @NotNull
    private String totalAudienceCapacity;

    private String numberOfContestants;

    public EventDetails(
            String description,
            String location,
            String contactEmail,
            String date,
            String entryFee,
            TypeOfTournament typeOfTournament,
            String totalAudienceCapacity,
            String numberOfContestants
    ) {
        this.description = description;
        this.location = location;
        this.contactEmail = contactEmail;
        this.date = date;
        this.entryFee = entryFee;
        this.typeOfTournament = typeOfTournament;
        this.totalAudienceCapacity = totalAudienceCapacity;
        this.numberOfContestants = numberOfContestants;
    }

    public EventDetails () {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }

    public TypeOfTournament getTypeOfTournament() {
        return typeOfTournament;
    }

    public void setTypeOfTournament(TypeOfTournament typeOfTournament) {
        this.typeOfTournament = typeOfTournament;
    }

    public String getTotalAudienceCapacity() {
        return totalAudienceCapacity;
    }

    public void setTotalAudienceCapacity(String totalAudienceCapacity) {
        this.totalAudienceCapacity = totalAudienceCapacity;
    }

    public String getNumberOfContestants() {
        return numberOfContestants;
    }

    public void setNumberOfContestants(String numberOfContestants) {
        this.numberOfContestants = numberOfContestants;
    }
}
