package TournamentOrganizer.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Login extends AbstractEntity {


    @NotBlank
    @Size(min = 3, max = 15, message = "username must be between 3 and 15 characters")
    private String userLogin;

    @NotBlank
    @Size(min = 3, max = 15, message = "username must be between 3 and 15 characters")
    private String userPassword;


    //constructor
        public Login(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;

    }

    //no arg constructor
    public Login() {

    }
////created a method for checking if a user is already registered 9/6
//    public void isAlreadyRegistered() throws SQLException {
//        Scanner sc = new Scanner(System.in); //not sure if this is necessary (isn't it already in the html?)
//
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/golf_tournament", userLogin, userPassword);
//        try {
//            Statement stmt = con.createStatement();
//
//            System.out.println("userLogin: ");
//            userLogin = sc.next(); //the login name the user gives me
//
//            String SQL = "SELECT * FROM login WHERE userLogin='" + userLogin + "'"; //not sure about the quote setup here
//
//        } catch (Exception e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
//
//    }


    //getters and setters
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}

//do I need a 2 string, and override methods??
