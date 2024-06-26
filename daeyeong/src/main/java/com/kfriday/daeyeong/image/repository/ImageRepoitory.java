package com.kfriday.daeyeong.image.repository;

import com.kfriday.daeyeong.bound.entity.Bound;
import com.kfriday.daeyeong.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepoitory extends JpaRepository<Image, Long> {

    List<Image> findAllByBound(Bound bound);
}
