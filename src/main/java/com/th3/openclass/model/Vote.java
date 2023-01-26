package com.th3.openclass.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "VOTES")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Vote extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Post post;
}
