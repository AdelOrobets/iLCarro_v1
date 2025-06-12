package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class to represent the user
 * Uses Lombok to autogenerate getters, setters, constructors and other methods
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLombok {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // for login
    public UserLombok(String email, String password) {
        this.username = email;
        this.password = password;
    }
}
