package com.supermarket.exception;

/**
 * The type Finalized bill cannot be modified exception.
 *
 * @author Siva Takkoli
 */
public class BillNotFinalizedException extends SuperMarketException {

    /**
     * Instantiates a new Finalized bill cannot be modified exception.
     *
     * @param msg the msg
     */
    public BillNotFinalizedException(String msg) {
        super(msg);
    }
}
