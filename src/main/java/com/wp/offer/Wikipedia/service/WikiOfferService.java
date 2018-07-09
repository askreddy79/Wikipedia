package com.wp.offer.Wikipedia.service;

import com.wp.offer.Wikipedia.converter.OfferConverter;
import com.wp.offer.Wikipedia.domain.WikiOffer;
import com.wp.offer.Wikipedia.domain.WikiOfferDto;
import com.wp.offer.Wikipedia.repository.WikiOfferRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public WikiOfferDto getOffer(long id) {
        return OfferConverter.entityToDto(wikiOfferRepository.findById(id).orElse(null));
    }

    public WikiOfferDto createOffer(WikiOfferDto offerDto) throws ConstraintViolationException {

        return OfferConverter.entityToDto(wikiOfferRepository.save(OfferConverter.dtoToEntity(offerDto)));
    }

    public WikiOfferDto getOfferName(String name) {
        return OfferConverter.entityToDto(wikiOfferRepository.findWikiOfferByName(name));
    }

    //Users can call this method to update offer with cancel status
    public void updateOffer(WikiOfferDto offerDto,String status) {
        WikiOffer offer = OfferConverter.dtoToEntity(offerDto);
        offer.setOfferStatus(status);

        wikiOfferRepository.save(offer);
    }

    public List<WikiOfferDto> getAllOffers(Integer page, Integer size) {

        return wikiOfferRepository.findAll().stream().map(OfferConverter::entityToDto).collect(Collectors.toList());

    }

    public WikiOfferDto cancelOffer(WikiOfferDto offerDto) {
        WikiOffer offer = OfferConverter.dtoToEntity(offerDto);
        offer.setOfferStatus("CANCELLED");
        return OfferConverter.entityToDto(wikiOfferRepository.save(offer));
    }

}
