package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "favorite_series")
@Getter
@Setter
@EqualsAndHashCode
public class FavoriteSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "series_id", referencedColumnName = "id", nullable = false)
    private Series series;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    public FavoriteSeries(Series series, Integer userId) {
        this.series = series;
        this.userId = userId;
    }

    public FavoriteSeries() {
    }
}