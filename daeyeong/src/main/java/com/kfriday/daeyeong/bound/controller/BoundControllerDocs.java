package com.kfriday.daeyeong.bound.controller;

import com.kfriday.daeyeong._common.response.error.ErrorResponse;
import com.kfriday.daeyeong._common.response.success.SuccessResponse;
import com.kfriday.daeyeong.bound.dto.request.CreateBoundRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "bounds", description = "입출고")
@RequestMapping("/api/bounds")
public interface BoundControllerDocs {

    @Operation(summary = "입출고 생성",
            description = """
                    request body 넣어주세요.
                    """)
    @ApiResponse(responseCode = "200",
            description = "성공")
    @ApiResponse(responseCode = "409",
            description = """
                    트래킹 번호가 중복되는 경우
                    """,
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @PostMapping
    SuccessResponse<Void> create(@RequestBody @Valid CreateBoundRequest request);
}
