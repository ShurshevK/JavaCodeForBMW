package com.example.demo.domain;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;




@Getter
@Setter

@NoArgsConstructor
@Entity
@Table(name = "appuser")
public class AppUser{

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "app_user_id"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;







    public AppUser(String firstName,
                   String lastName,
                   String email,
                   String password,
                   String phoneNumber

                   ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;


    }
}



