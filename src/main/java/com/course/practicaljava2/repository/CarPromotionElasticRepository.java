package com.course.practicaljava2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.course.practicaljava2.rest.domain.CarPromotion;

@Repository
public interface CarPromotionElasticRepository extends ElasticsearchRepository<CarPromotion, String> {

	public Page<CarPromotion> findByType(String type, Pageable pageable);

}