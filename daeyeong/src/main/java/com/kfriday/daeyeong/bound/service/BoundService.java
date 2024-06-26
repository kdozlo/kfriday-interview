package com.kfriday.daeyeong.bound.service;

import com.kfriday.daeyeong._common.response.error.ErrorType;
import com.kfriday.daeyeong._common.response.error.exception.BusinessException;
import com.kfriday.daeyeong.bound.dto.request.CreateBoundRequest;
import com.kfriday.daeyeong.bound.dto.response.ReadBoundResponse;
import com.kfriday.daeyeong.bound.entity.Bound;
import com.kfriday.daeyeong.bound.repository.BoundRepository;
import com.kfriday.daeyeong.image.dto.request.CreateImageRequest;
import com.kfriday.daeyeong.image.dto.response.ReadImageResponse;
import com.kfriday.daeyeong.image.entity.Image;
import com.kfriday.daeyeong.image.repository.ImageRepoitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoundService {

    private final BoundRepository boundRepository;
    private final ImageRepoitory imageRepoitory;

    @Transactional
    public void create(CreateBoundRequest request) {

        // 트래킹 번호 중복 확인
        if(boundRepository.findByTrackingNo(request.getTrackingNo()).isPresent())
            throw new BusinessException(ErrorType.BOUND_TRACKING_NO_CONFLICT);

        Bound bound = boundRepository.save(Bound.of(request.getTrackingNo()));

        List<Image> images = new ArrayList<>();
        for (CreateImageRequest i : request.getImages()) {
            images.add(Image.of(i, bound));
        }

        imageRepoitory.saveAll(images);
    }

    public ReadBoundResponse read(Long id) {
        Bound bound = validBound(id);

        List<ReadImageResponse> images = imageRepoitory.findAllByBound(bound)
                .stream()
                .map(ReadImageResponse::from)
                .toList();

        return ReadBoundResponse.of(bound, images);
    }

    @Transactional
    public void delete(Long id) {

        Bound bound = validBound(id);

        List<Image> images = imageRepoitory.findAllByBound(bound);

        imageRepoitory.deleteAll(images);

        boundRepository.delete(bound);
    }

    private Bound validBound(Long id) {

        return boundRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorType.BOUND_NOT_FOUND));
    }
}
