package ru.avito.ads.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.avito.ads.model.record.AdvertisementStatus;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Advertisement extends AbstractEntity{
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AdvertisementStatus status;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Account owner;
}
