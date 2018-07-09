package com.wp.offer.Wikipedia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by suneel on 05/07/2018.
 */
public class WikiOfferDto {
    private long id;
    private String name;
    private String description;
    private double price;
    private String currency;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private Date offerStartDate;
    private int daysValid;
    private String offerStatus;
    private String offerStatusMsg;

    public WikiOfferDto() {
    }

    public WikiOfferDto(long id, String name, String description, double price, String currency, Date offerStartDate, int daysValid, String offerStatus, String offerStatusMsg) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.offerStartDate = offerStartDate;
        this.daysValid = daysValid;
        this.offerStatus = offerStatus;
        this.offerStatusMsg = offerStatusMsg;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getOfferStartDate() {
        return offerStartDate;
    }

    public void setOfferStartDate(Date offerStartDate) {
        this.offerStartDate = offerStartDate;
    }

    public int getDaysValid() {
        return daysValid;
    }

    public void setDaysValid(int daysValid) {
        this.daysValid = daysValid;
    }

    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
    }

    public void setOfferStatusMsg(String offerStatusMsg) {
        this.offerStatusMsg = offerStatusMsg;
    }

    public String getOfferStatusMsg() {
        return offerStatusMsg;
    }


}
