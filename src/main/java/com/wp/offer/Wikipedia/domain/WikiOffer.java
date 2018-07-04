package com.wp.offer.Wikipedia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by suneel on 03/07/2018.
 */
@Entity
@Table(name = "wikioffer")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WikiOffer {

    @Id
    //@GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String name;

    private String description;
    private double price;
    private String currency;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private Date offerStartDate;
    private int daysValid;
    private String offerStatus;

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


    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
    }

    public int getDaysValid() {
        return daysValid;
    }

    public void setDaysValid(int daysValid) {
        this.daysValid = daysValid;
    }


}
