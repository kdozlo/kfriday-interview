package com.kfriday.daeyeong.image.controller;

import com.kfriday.daeyeong._common.response.error.ErrorResponse;
import com.kfriday.daeyeong._common.response.success.SuccessResponse;
import com.kfriday.daeyeong.image.dto.request.UpdateImageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "images", description = "이미지 파일")
@RequestMapping("/api/images")
public interface ImageControllerDocs {

    @Operation(summary = "이미지 유형 수정",
            description = """
                    request body 넣어주세요.
                    """)
    @ApiResponse(responseCode = "200",
            description = "성공")
    @ApiResponse(responseCode = "404",
            description = """ 
                    해당 입출고 재고의 이미지명이 없는 경우
                    """,
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @PutMapping()
    SuccessResponse<Void> update(@RequestBody
                                 @Valid
                                 UpdateImageRequest request);
}
