package com.wp.offer.Wikipedia.service;

import com.wp.offer.Wikipedia.domain.WikiOffer;
import com.wp.offer.Wikipedia.repository.WikiOfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by suneel on 03/07/2018.
 */
@Service
public class WikiOfferService {
    private static final Logger log = LoggerFactory.getLogger(WikiOfferService.class);

    @Autowired
    private WikiOfferRepository wikiOfferRepository;

    public WikiOfferService() {

    }

    public WikiOffer getOffer(long id) {
        return wikiOfferRepository.findById(id).orElse(null);
    }

    public WikiOffer createOffer(WikiOffer offer) {
        return wikiOfferRepository.save(offer);
    }

    public WikiOffer getOfferName(String name) {
        return wikiOfferRepository.findWikiOfferByName(name);
    }

    //Users can call this method to update offer with cancel status
    public void updateOffer(WikiOffer offer,String status) {
        offer.setOfferStatus(status);
        wikiOfferRepository.save(offer);
    }

    public Page<WikiOffer> getAllOffers(Integer page, Integer size) {
        Page pageOfOffers = wikiOfferRepository.findAll(new PageRequest(page, size));
        return pageOfOffers;
    }

}
