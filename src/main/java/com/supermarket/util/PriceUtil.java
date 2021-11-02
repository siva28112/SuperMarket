package com.supermarket.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The type Price util.
 *
 * @author Siva Takkoli
 */
public class PriceUtil {
    /**
     * Price format string.
     *
     * @param b the b
     * @return the string
     */
    public static String priceFormat(BigDecimal b) {
        return b.setScale(2, RoundingMode.HALF_EVEN).toEngineeringString();
    }
}
