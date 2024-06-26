package com.kfriday.daeyeong.image.entity;

import com.kfriday.daeyeong.bound.entity.Bound;
import com.kfriday.daeyeong.image.dto.request.CreateImageRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(nullable = false)
    private String filename;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImageType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bound_id")
    private Bound bound;

    @Builder
    private Image(String filename, ImageType type, Bound bound) {
        this.filename = filename;
        this.type = type;
        this.bound = bound;
    }

    public static Image of(CreateImageRequest request, Bound bound) {
        return builder()
                .filename(request.getFilename())
                .type(ImageType.valueOf(request.getType()))
                .bound(bound)
                .build();
    }

    public void updateType(String type) {
        this.type = ImageType.valueOf(type);
    }
}
