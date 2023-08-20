package com.CoreService.QP.CoreService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "series_category")
@Getter
@Setter
public class SeriesCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "series_id", referencedColumnName = "id")
    @JsonBackReference
    private Series series;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public SeriesCategory() {
    }

    public SeriesCategory(Series series, Category category) {
        this.series = series;
        this.category = category;
    }
}
