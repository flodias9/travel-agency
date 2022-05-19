package com.floriandias.travelagency.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="address")
    private String address;

    @Column(name="post_code")
    private String postCode;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="date_updated")
    @UpdateTimestamp
    private Date dateUpdated;

    @OneToMany(mappedBy="client")
    private List<Booking> bookings;

}
