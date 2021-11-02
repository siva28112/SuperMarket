package com.supermarket.observer;

import com.supermarket.domain.Item;

/**
 * The interface Subject. Could have use the java Obeservable but did this as a chance to
 * demonstrate the internals of a simple Observables.
 *
 * @author Siva Takkoli
 */
public interface IBillingConsole {
    /**
     * Add item.
     *
     * @param item the item
     */
    void addItem(Item item);
}
