package no.movies.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "USER_ID")
private int id;
@Column(name = "EMAIL")

private String email;
@Column(name = "PASSWORD")

private String password;
@Column(name = "NAME")
private String name;
@Column(name = "LAST_NAME")
private String lastName;
@Column(name = "ACTIVE")
private int active;
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
private Set<Role> roles;
}