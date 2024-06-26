package com.kfriday.daeyeong.bound.dto.request;

import com.kfriday.daeyeong.image.dto.request.CreateImageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(name = "CreateBoundRequest", description = "입출고 등록 요청")
public class CreateBoundRequest {

    @NotNull(message = "trackingNo: 값이 null이 아니어야 합니다.")
    @Min(value = 1, message = "trackingNo: 값이 1 이상이어야 합니다.")
    @Schema(description = "트래킹 번호", example = "111122223333")
    private Long trackingNo;

    @Valid
    private List<CreateImageRequest> images;
}
