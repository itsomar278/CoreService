package com.CoreService.QP.CoreService.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
    @Table(name = "series_season")
    @Getter
    @Setter
    @EqualsAndHashCode
    public class SeriesSeasonEntity{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "name", length = 80)
        private String name;

        @ManyToOne
        @JoinColumn(name = "series_id", referencedColumnName = "id", nullable = false)
        private SeriesEntity series;

        @Column(name = "season_no", nullable = false)
        private int seasonNo;

        @Column(name = "url", nullable = false)
        private String url;

        @Column(name = "publish_date", nullable = false)
        private Timestamp publishDate;

        @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<SeasonEpisodeEntity> episodes ;

    public SeriesSeasonEntity() {
    }

    public SeriesSeasonEntity(String name, SeriesEntity series, int seasonNo, String url, Timestamp publishDate, List<SeasonEpisodeEntity> episodes) {
        this.name = name;
        this.series = series;
        this.seasonNo = seasonNo;
        this.url = url;
        this.publishDate = publishDate;
        this.episodes = episodes;
    }

    public SeriesSeasonEntity(String name, SeriesEntity series, int seasonNo, String url, Timestamp publishDate) {
        this.name = name;
        this.series = series;
        this.seasonNo = seasonNo;
        this.url = url;
        this.publishDate = publishDate;
    }

}
