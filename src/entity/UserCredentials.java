package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "user_credential")
public class UserCredentials {
    @Id
    @Column(name = "user_name")
    private String username;
    @Column(name = "pass_word")
    private String password;
}
