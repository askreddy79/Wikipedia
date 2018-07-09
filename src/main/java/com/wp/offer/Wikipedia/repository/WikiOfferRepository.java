package com.wp.offer.Wikipedia.repository;

import com.wp.offer.Wikipedia.domain.WikiOffer;
import com.wp.offer.Wikipedia.domain.WikiOfferDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by suneel on 03/07/2018.
 */
public interface WikiOfferRepository extends JpaRepository<WikiOffer,Long> {
    WikiOffer findWikiOfferByName(String name);
}
