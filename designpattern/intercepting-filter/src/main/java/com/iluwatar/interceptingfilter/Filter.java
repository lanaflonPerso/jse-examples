package com.iluwatar.interceptingfilter;

/**
 * Filter interface Filters perform certain tasks prior or after execution of request by request handler. In this case,
 * before the request is handled by the target, the request undergoes through each Filter
 * 
 * @author joshzambales
 *
 */
public interface Filter {

    /**
     * Execute order processing filter.
     * 
     * @param order
     * @return empty string on success, otherwise error message.
     */
    String execute(Order order);

    /**
     * Get next filter in chain after this.
     *
     * @return
     */
    Filter getNext();

    /**
     * Set next filter in chain after this.
     *
     * @param filter
     */
    void setNext(Filter filter);

    /**
     * Get last filter in the chain.
     * 
     * @return
     */
    Filter getLast();
}
