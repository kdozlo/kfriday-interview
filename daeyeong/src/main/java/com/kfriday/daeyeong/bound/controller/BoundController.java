package com.kfriday.daeyeong.bound.controller;

import com.kfriday.daeyeong._common.response.success.SuccessResponse;
import com.kfriday.daeyeong._common.response.success.SuccessType;
import com.kfriday.daeyeong.bound.dto.request.CreateBoundRequest;
import com.kfriday.daeyeong.bound.service.BoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoundController implements BoundControllerDocs {

    private final BoundService boundService;

    @Override
    public SuccessResponse<Void> create(CreateBoundRequest request) {

        boundService.create(request);

        return  SuccessResponse.of(SuccessType.CREATE_BOUND_SUCCESS);
    }

    @Override
    public SuccessResponse<Void> delete(Long boundId) {

        System.out.println("boundId : " + boundId);
        boundService.delete(boundId);

        return SuccessResponse.of(SuccessType.DELETE_BOUND_SUCCESS);
    }
}
