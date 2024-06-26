package com.kfriday.daeyeong.image.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ImageType {
    PKG("PKG"),
    OTHER("OTHER"),
    ;

    private final String description;
}
