package com.kfriday.daeyeong.bound.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bound_id")
    private Long id;

    @Column(nullable = false)
    private Long trackingNo;

    @Builder
    private Bound(Long trackingNo) {
        this.trackingNo = trackingNo;
    }

    public static Bound of(Long trackingNo) {
        return builder()
                .trackingNo(trackingNo)
                .build();
    }
}
