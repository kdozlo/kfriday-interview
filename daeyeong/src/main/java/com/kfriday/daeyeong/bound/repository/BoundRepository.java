package com.kfriday.daeyeong.bound.repository;

import com.kfriday.daeyeong.bound.entity.Bound;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoundRepository extends JpaRepository<Bound, Long> {

    public Optional<Bound> findByTrackingNo(Long trackingNo);
}
