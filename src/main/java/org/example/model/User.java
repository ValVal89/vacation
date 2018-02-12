package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    @Id
    @Column(name = "USER_ID")
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    @OneToMany(mappedBy = "user")
    private HashSet<Settings> settings = new HashSet<>();

}
