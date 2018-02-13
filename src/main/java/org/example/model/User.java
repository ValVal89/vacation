package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    @Id
    @Column(name = "USER_ID")
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @OneToOne(mappedBy = "user")
    private Dashboard dashboard;

}
