package com.wp.offer.Wikipedia.api.rest;

import com.wp.offer.Wikipedia.Exception.DataFormatException;
import com.wp.offer.Wikipedia.Exception.ResourceNotFoundException;
import com.wp.offer.Wikipedia.Exception.ViolationException;
import com.wp.offer.Wikipedia.domain.RestErrorInfo;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * Required to use by any other REST handlers for exception mapping
 * and other common REST API functionality
 * Created by suneel on 03/07/2018.
 */
public abstract class AbstractRestHandler implements ApplicationEventPublisherAware {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    protected ApplicationEventPublisher eventPublisher;

    protected static final String  DEFAULT_PAGE_SIZE = "100";
    protected static final String DEFAULT_PAGE_NUM = "0";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataFormatException.class)
    public
    @ResponseBody
    RestErrorInfo handleDataStoreException(DataFormatException ex, WebRequest request, HttpServletResponse response) {
        log.info("Converting Data Store exception to RestResponse : " + ex.getMessage());

        return new RestErrorInfo(ex, "You messed up.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public
    @ResponseBody
    RestErrorInfo handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request, HttpServletResponse response) {
        log.info("ResourceNotFoundException handler:" + ex.getMessage());

        return new RestErrorInfo(ex, "Sorry I couldn't find it.");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public static <T> T checkResourceFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException("resource not found");
        }
        return resource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ViolationException.class)
    public
    @ResponseBody
    RestErrorInfo handleConstraintViolationException(ViolationException ex, WebRequest request, HttpServletResponse response) {
        log.info("Unique constraint violation Exception handler:" + ex.getMessage());
        return new RestErrorInfo(ex, "Sorry there is already same offer existed");
    }

//    public static <T> T handleConstraintViolationException(final T constraint) {
//        if (constraint == null) {
//            throw new ViolationException("unique constraint violation");
//        }
//        return constraint;
//    }


}
