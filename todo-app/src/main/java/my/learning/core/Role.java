package my.learning.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("userId")
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userName")
    private User userId;

    @JsonProperty("role")
    @Column(name = "role")
    private String role;
}
