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
public class FavoriteSeriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "series_id", referencedColumnName = "id", nullable = false)
    private SeriesEntity series;

    @Column(name = "user_id", nullable = false)
    private int userId;

    public FavoriteSeriesEntity(SeriesEntity series, int userId) {
        this.series = series;
        this.userId = userId;
    }

    public FavoriteSeriesEntity() {
    }
}