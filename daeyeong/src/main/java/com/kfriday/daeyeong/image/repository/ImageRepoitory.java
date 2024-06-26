package com.kfriday.daeyeong.image.repository;

import com.kfriday.daeyeong.bound.entity.Bound;
import com.kfriday.daeyeong.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepoitory extends JpaRepository<Image, Long> {

    List<Image> findAllByBound(Bound bound);
    Optional<Image> findByBoundIdAndFilename(Long boundId, String filename);
}
