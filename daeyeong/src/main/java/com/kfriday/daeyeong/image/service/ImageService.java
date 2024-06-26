package com.kfriday.daeyeong.image.service;

import com.kfriday.daeyeong._common.response.error.ErrorType;
import com.kfriday.daeyeong._common.response.error.exception.BusinessException;
import com.kfriday.daeyeong.image.dto.request.UpdateImageRequest;
import com.kfriday.daeyeong.image.entity.Image;
import com.kfriday.daeyeong.image.repository.ImageRepoitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageService {

    private final ImageRepoitory imageRepoitory;

    @Transactional
    public void update(UpdateImageRequest request) {

        Image image = imageRepoitory.findByBoundIdAndFilename(request.getBoundId(), request.getFilename())
                .orElseThrow(() -> new BusinessException(ErrorType.IMAGE_NOT_FOUND));

        image.updateType(request.getType());
    }
}
