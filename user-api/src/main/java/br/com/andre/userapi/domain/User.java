package br.com.andre.userapi.domain;

import lombok.*;
import static lombok.EqualsAndHashCode.Include;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "TB_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;


}
