package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "location",nullable = false)
    private String location;

    @Column(name = "license_number",nullable = false)
    private String license_number;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "status",nullable = false)
    private int status;

}
