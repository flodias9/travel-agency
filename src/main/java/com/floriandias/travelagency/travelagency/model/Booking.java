package com.floriandias.travelagency.travelagency.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.floriandias.travelagency.travelagency.enumeration.BookingValidationEnum;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(name="validation")
    private BookingValidationEnum validation;

    @Column(name="place_wanted_number")
    private Integer placeWantedNb;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="date_updated")
    @UpdateTimestamp
    private Date dateUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tour_id", nullable=false)
    private Tour tour;

    @OneToMany(mappedBy="booking")
    private List<Payment> payments;

}
