package com.floriandias.travelagency.travelagency.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="step")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Step implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(name="day_number")
    private Integer dayNumber;

    @Column(name="starting_hour")
    private String startingHour;

    @Column(name="ending_hour")
    private String endingHour;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="date_updated")
    @UpdateTimestamp
    private Date dateUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="place_id", nullable=false)
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tour_id", nullable=false)
    private Tour tour;

}
