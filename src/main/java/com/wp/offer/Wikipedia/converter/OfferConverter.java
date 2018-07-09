package com.wp.offer.Wikipedia.converter;

import com.wp.offer.Wikipedia.domain.WikiOffer;
import com.wp.offer.Wikipedia.domain.WikiOfferDto;

import java.util.Date;

/**
 * Created by suneel on 05/07/2018.
 */
public class OfferConverter {

    public static WikiOffer dtoToEntity(WikiOfferDto offerDto) {
        if (offerDto == null) return new WikiOffer();
        return new WikiOffer(offerDto.getId(),offerDto.getName(),offerDto.getDescription(),offerDto.getPrice(),
                offerDto.getCurrency(),offerDto.getOfferStartDate(),offerDto.getDaysValid(),offerDto.getOfferStatus());
    }

    public static WikiOfferDto entityToDto(WikiOffer offer) {
        if (offer == null) return new WikiOfferDto();
        String offerCurrentStatus = "";
        String offerStatusMsg = "";
        if (daysFromCurrenDates(offer.getOfferStartDate())> offer.getDaysValid()) {
            offerCurrentStatus = "EXPIRED";
        } else {
            offerCurrentStatus = offer.getOfferStatus();
            if (offerCurrentStatus.equals("CANCELLED"))
                offerStatusMsg = "Offer is Cancelled";
            else
                offerStatusMsg = "Offer is Active for another "  + daysFromCurrenDates(offer.getOfferStartDate());
        }
        return new WikiOfferDto(offer.getId(),offer.getName(),offer.getDescription(),offer.getPrice(),offer.getCurrency(),offer.getOfferStartDate(),offer.getDaysValid(),offerCurrentStatus,offerStatusMsg);
    }

    public static long daysFromCurrenDates(Date date) {
        return (new Date().getTime() - date.getTime())/(1000*60*60*24);
    }


}
