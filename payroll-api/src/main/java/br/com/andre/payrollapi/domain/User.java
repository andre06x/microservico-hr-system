package br.com.andre.payrollapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.EqualsAndHashCode.Include;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {

    private Long id;

    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;


}
