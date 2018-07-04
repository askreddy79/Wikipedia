package com.wp.offer.Wikipedia.api.rest;

/**
 * Created by suneel on 03/07/2018.
 */

import com.wp.offer.Wikipedia.domain.WikiOffer;
import com.wp.offer.Wikipedia.service.WikiOfferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/wiki/v1/offers")
@Api(tags = {"offers"})
public class WikiOfferController extends AbstractRestHandler {

    @Autowired
    private WikiOfferService wikiOfferService;


    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create an offer for wikipedia.", notes = "Returns the URL of the new resource in the Location header.")
    public void createWikiOffer(@RequestBody WikiOffer offer,
                            HttpServletRequest request, HttpServletResponse response) {
        WikiOffer createdOffer = this.wikiOfferService.createOffer(offer);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdOffer.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all offers.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<WikiOffer> getAllOffers(@ApiParam(value = "The page number (zero-based)", required = true)
                            @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                @ApiParam(value = "Tha page size", required = true)
                            @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                HttpServletRequest request, HttpServletResponse response) {
        return this.wikiOfferService.getAllOffers(page, size);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single offer.", notes = "You have to provide a valid wikiOffer Id.")
    public
    @ResponseBody
    WikiOffer getOffer(@ApiParam(value = "The ID of the wikioffer.", required = true)
                   @PathVariable("id") Long id,
                   HttpServletRequest request, HttpServletResponse response) throws Exception {
        WikiOffer offer = this.wikiOfferService.getOffer(id);
        checkResourceFound(offer);
        return offer;
    }


}
