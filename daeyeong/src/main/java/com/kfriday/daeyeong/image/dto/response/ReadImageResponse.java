package com.kfriday.daeyeong.image.dto.response;

import com.kfriday.daeyeong.image.entity.Image;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Schema(name = "ReadImagesResponse", description = "이미지 조회")
public class ReadImageResponse {

    @Schema(description = "이미지명", example = "image1.jpg")
    private String filename;

    @Schema(description = "이미지 유형", example = "PKG")
    private String type;

    @Builder
    private ReadImageResponse(String filename, String type) {
        this.filename = filename;
        this.type = type;
    }

    public static ReadImageResponse from(Image image) {

        return builder()
                .filename(image.getFilename())
                .type(image.getType().getDescription())
                .build();
    }
}
