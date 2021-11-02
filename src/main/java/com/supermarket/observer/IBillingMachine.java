package com.supermarket.observer;

import com.supermarket.domain.Item;
import com.supermarket.offer.AbstractOffer;

/**
 * The interface Observer. Could have use the java Obeservable but did this as a chance to
 * demonstrate the internals of a simple Observables.
 *
 * @author Siva Takkoli
 */
public interface IBillingMachine {
    /**
     * Add item.
     *
     * @param item the item
     */
    void addItem(Item item);

    /**
     * Subscribe.
     *
     * @param offer the offer
     */
    void subscribe(AbstractOffer offer);
}
