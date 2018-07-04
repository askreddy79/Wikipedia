package com.wp.offer.Wikipedia.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by suneel on 03/07/2018.
 */
@XmlRootElement
public class RestErrorInfo {
    public final String detail;
    public final String message;

    public RestErrorInfo(Exception ex, String detail) {
        this.message = ex.getLocalizedMessage();
        this.detail = detail;
    }
}
