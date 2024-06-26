package com.kfriday.daeyeong.bound.controller;

import com.kfriday.daeyeong._common.response.error.ErrorResponse;
import com.kfriday.daeyeong._common.response.success.SuccessResponse;
import com.kfriday.daeyeong.bound.dto.request.CreateBoundRequest;
import com.kfriday.daeyeong.bound.dto.response.ReadBoundResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "입출고 단건 조회",
            description = """
                    path variable로 bound-id 넣어주세요. \n
                    """)
    @ApiResponse(responseCode = "200",
            description = "성공")
    @ApiResponse(responseCode = "404",
            description = """ 
                    해당 입출고 정보가 없는 경우
                    """,
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @GetMapping(value = "/{bound-id}")
    SuccessResponse<ReadBoundResponse> read(@PathVariable(name = "bound-id")
                                            @Schema(description = "입출고 고유번호", example = "1")
                                            Long boundId);

    @Operation(summary = "입출고 삭제",
            description = """
                    path variable로 bound-id 넣어주세요. \n
                    """)
    @ApiResponse(responseCode = "200",
            description = "성공")
    @ApiResponse(responseCode = "404",
            description = """ 
                    해당 입출고 정보가 없는 경우
                    """,
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @DeleteMapping(value = "/{bound-id}")
    SuccessResponse<Void> delete(@PathVariable(name = "bound-id")
                                 @Schema(description = "입출고 고유번호", example = "1")
                                 Long boundId);
}
