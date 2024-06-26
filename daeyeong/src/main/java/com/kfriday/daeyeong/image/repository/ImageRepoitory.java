package com.kfriday.daeyeong.image.repository;

import com.kfriday.daeyeong.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepoitory extends JpaRepository<Image, Long> {
}
