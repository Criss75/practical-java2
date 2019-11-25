package com.course.practicaljava2.rest.service;

import java.util.List;

public interface CarPromotionService {

	List<String> PROMOTION_TYPES = List.of("Bonus", "Discount");

	boolean isValidPromotionType(String promotionType);

}
