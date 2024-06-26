package com.kfriday.daeyeong.bound.dto.response;

import com.kfriday.daeyeong.bound.entity.Bound;
import com.kfriday.daeyeong.image.dto.response.ReadImageResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Schema(name = "ReadBoundResponse", description = "입출ㅠ 조회")
public class ReadBoundResponse {

    @Schema(description = "입출력 고유번호", example = "1")
    private Long id;

    @Schema(description = "트래킹 번호", example = "111122223333")
    private Long trackingNo;

    private List<ReadImageResponse> images;

    @Builder
    private ReadBoundResponse(Long id, Long trackingNo, List<ReadImageResponse> images) {
        this.id = id;
        this.trackingNo = trackingNo;
        this.images = images;
    }

    public static ReadBoundResponse of(Bound bound, List<ReadImageResponse> images) {

        return builder()
                .id(bound.getId())
                .trackingNo(bound.getTrackingNo())
                .images(images)
                .build();
    }
}
