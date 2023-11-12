package com.fit.Travelo.repository;

import com.fit.Travelo.entity.TourInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
TourInfoRepository extends JpaRepository<TourInfo, Long> {
}
