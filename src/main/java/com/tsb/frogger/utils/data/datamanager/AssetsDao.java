package com.tsb.frogger.utils.data.datamanager;

import java.net.URL;

/**
 * assets property data access object interface
 */
public interface AssetsDao {
    /**
     * get asset name
     *
     * @param propertyKey key
     * @return name
     */
    String getName(String propertyKey);

    /**
     * get URL format
     *
     * @param propertyKey key
     * @return URL
     */
    URL getURL(String propertyKey);

    /**
     * get external form format
     *
     * @param propertyKey key
     * @return string
     */
    String getExternal(String propertyKey);
}
