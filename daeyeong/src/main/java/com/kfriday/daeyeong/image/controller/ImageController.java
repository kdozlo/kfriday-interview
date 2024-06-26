package com.kfriday.daeyeong.image.controller;

import com.kfriday.daeyeong._common.response.success.SuccessResponse;
import com.kfriday.daeyeong._common.response.success.SuccessType;
import com.kfriday.daeyeong.image.dto.request.UpdateImageRequest;
import com.kfriday.daeyeong.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ImageController implements ImageControllerDocs {

    private final ImageService imageService;

    @Override
    public SuccessResponse<Void> update(UpdateImageRequest request) {

        imageService.update(request);

        return SuccessResponse.of(SuccessType.UPDATE_IMAGE_TYPE_SUCCESS);
    }
}
