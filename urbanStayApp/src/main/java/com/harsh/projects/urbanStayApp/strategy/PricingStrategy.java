package com.harsh.projects.urbanStayApp.strategy;

import com.harsh.projects.urbanStayApp.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
