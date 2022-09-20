package TournamentOrganizer.models;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name is required!")
    @NotNull
    @Size(min = 3, max = 100, message = "Name must be between 3 and 50 characters!")
    private String name;

    @NotBlank(message = "Address is required")
    @NotNull
    @Size(max = 100, message = "Address is too long!")
    private String address;

    @NotBlank(message = "City is required")
    @NotNull
    @Size(max = 100, message = "City is too long!")
    private String city;

    @NotBlank(message = "State is required")
    @NotNull
    @Size(max = 100, message = "State is too long!")
    private String state;

    @NotBlank(message = "Description is required!")
    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Competitive level required!")
    @NotNull
    private String competitiveLevel;

    @NotBlank(message = "Summary is required!")
    @NotNull
    @Size(max = 500, message = "Summary is too long!")
    private String summary;

    @NotBlank(message = "Entry Fee is required!")
    @NotNull
    private String entryFee;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "Date is required!")
    @NotNull
    private String date;

    public Event(String name, String address, String city, String state, String description,   String competitiveLevel, String summary, String entryFee, String date) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.description = description;
        this.competitiveLevel = competitiveLevel;
        this.summary = summary;
        this.entryFee = entryFee;
        this.date = date;
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompetitiveLevel() {
        return competitiveLevel;
    }

    public void setCompetitiveLevel(String competitiveLevel) {
        this.competitiveLevel = competitiveLevel;
    }
    
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return name;
    }
}

