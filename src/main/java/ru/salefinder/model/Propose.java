package ru.salefinder.model;

import java.sql.Timestamp;

/**
 * Determines Propose in website shop.
 */
public class Propose<P extends Propose> implements Comparable<P> {
    /**
     * Id of propose.
     */
    private int id;
    /**
     * Site name.
     */
    private String site;
    /**
     * Prise propose.
     */
    private float price;
    /**
     * Name of propose.
     */
    private String name;
    /**
     * Date of parsing from website.
     */
    private Timestamp date;

    /**
     * Default constructor.
     *
     * @param id of propose.
     * @param site name.
     * @param price of product.
     * @param name of proposal.
     * @param date of parsing.
     */
    public Propose(final int id,
                   final String site,
                   final float price,
                   final String name,
                   final Timestamp date) {
        this.id = id;
        this.site = site;
        this.price = price;
        this.name = name;
        this.date = date;
    }

    /**
     * Compare of prices.
     *
     * @param p inner price.
     * @return if prices equals 0, current less -1, inner less 1.
     */
    public int compareTo(final P p) {
        return price == p.getPrice() ? 0 : (price > p.getPrice() ? 1 : -1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Propose{" +
                "id=" + id +
                ", site='" + site + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
