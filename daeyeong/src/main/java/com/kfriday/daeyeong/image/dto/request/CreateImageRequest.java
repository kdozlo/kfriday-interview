package com.kfriday.daeyeong.image.dto.request;

import com.kfriday.daeyeong._common.annotation.Enum;
import com.kfriday.daeyeong.image.entity.ImageType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "CreateImageRequest", description = "이미지 등록 요청")
public class CreateImageRequest {

    @NotBlank(message = "filename: 값이 비어 있지 않아야 합니다.")
    @Schema(description = "이미지명", example = "image1.jpg")
    private String filename;

    @Enum(enumClass = ImageType.class, ignoreCase = true)
    @Schema(description = "이미지 유형", example = "PKG")
    private String type;
}
