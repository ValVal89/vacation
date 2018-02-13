package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@ToString(exclude = "user")
public class Dashboard {
    @Id
    private String id;
    private String description;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user;

    public Dashboard(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
