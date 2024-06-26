package com.kfriday.daeyeong.image.dto.request;

import com.kfriday.daeyeong._common.annotation.Enum;
import com.kfriday.daeyeong.image.entity.ImageType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "UpdateImageRequest", description = "이미지 수정 요청, 이미지 유형만 변경 가능")
public class UpdateImageRequest {

    @NotNull(message = "boundId: 값이 null이 아니어야 합니다.")
    @Schema(description = "입출력 고유번호", example = "1")
    private Long boundId;

    @NotBlank(message = "filename: 값이 비어 있지 않아야 합니다.")
    @Schema(description = "이미지명", example = "image1.jpg")
    private String filename;

    @Enum(enumClass = ImageType.class, ignoreCase = true)
    @Schema(description = "이미지 유형", example = "OTHER")
    private String type;
}
