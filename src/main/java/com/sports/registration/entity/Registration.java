package com.sports.registration.entity;

import com.sports.registration.enums.RegisterStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Getter
@Setter
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(generator =  "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String categoryId;
    private String userId;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private RegisterStatus registerStatus;
}
