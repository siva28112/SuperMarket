package com.supermarket;

import com.supermarket.domain.Bill;
import com.supermarket.domain.Item;
import com.supermarket.observer.BillingConsole;
import com.supermarket.observer.BillingMachine;
import com.supermarket.offer.AbstractOffer;
import com.supermarket.offer.BuyNGetMAbstractOffer;
import com.supermarket.offer.BuyNGetMPercentOffDiscountAbstractOffer;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static com.supermarket.domain.Products.*;

/**
 * Unit test for simple App.
 *
 * @author Siva Takkoli
 */
public class TwoBuy1Get1Test {

    private final Item greenTea = new Item(GR1, new BigDecimal("3.11"));
    private final Item strawberries = new Item(SR1, new BigDecimal("5.00"));
    private final Item coffee = new Item(CF1, new BigDecimal("11.23"));
    private final AbstractOffer buy1Get1FreeOfferForTea = new BuyNGetMAbstractOffer(greenTea, 1, 1);
    private final AbstractOffer buy1Get1FreeOfferForStrawberries = new BuyNGetMAbstractOffer(strawberries, 1, 1);
    private final AbstractOffer buy3GetAtTwoThirdsOfferForCoffee = new BuyNGetMPercentOffDiscountAbstractOffer(
            "Buy 3+ and get all at 2/3 price Offer",
            coffee,
            3,
            new BigDecimal(1).divide(new BigDecimal(3), new MathContext(5)));

    private Bill bill;
    private BillingMachine offerObserver;

    /**
     * Sets .
     */
    @Before
    public void setup() {
        bill = new Bill();
        offerObserver = new BillingMachine(bill);
        offerObserver.subscribe(buy1Get1FreeOfferForTea);
        offerObserver.subscribe(buy1Get1FreeOfferForStrawberries);
        offerObserver.subscribe(buy3GetAtTwoThirdsOfferForCoffee);
    }

    /**
     * Basket 3.
     */
    @Test
    public void basket3() {
        final String expected = "Welcome to 'A Small Chain Of \uD83D\uDED2 SuperMarket'\n" +
                "1. Pay SR1: Strawberries £5.00\n" +
                "2. Free! SR1: Strawberries £5.00\n" +
                "3. Pay GR1: Green Tea £3.11\n" +
                "4. Free! GR1: Green Tea £3.11\n" +
                "5. Pay SR1: Strawberries £5.00\n" +
                "6. Free! SR1: Strawberries £5.00\n" +
                "You only pay: £13.11\n" +
                "**Thank you for visiting us!**\n\n";

        BillingConsole billingConsole = new BillingConsole(offerObserver);
        billingConsole.addItem(strawberries);
        billingConsole.addItem(greenTea);
        billingConsole.addItem(strawberries);

        bill.finalizeBill();
        TestCase.assertEquals(expected, bill.print());
    }

}
