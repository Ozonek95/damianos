package com.company;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

enum CoffeType {
    EXPRESSO(5, 5, 5, new BigDecimal(10)), LATTE(2, 2, 0, new BigDecimal(10)), UNKNOWN_TYPE(0, 0, 0,new BigDecimal(10));

    Map<ResourceType, Integer> resourceToQuantityMap = new HashMap<>();
    BigDecimal cost;

    CoffeType(int waterQuantity, int milkQuanity, int beansQuantity, BigDecimal cost) {
        resourceToQuantityMap.put(ResourceType.WATER, waterQuantity);
        resourceToQuantityMap.put(ResourceType.MILK, milkQuanity);
        resourceToQuantityMap.put(ResourceType.BEANS, beansQuantity);
        this.cost = cost;
    }
}
