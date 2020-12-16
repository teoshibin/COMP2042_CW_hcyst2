package com.tsb.frogger.utils.data.datamanager;

import com.tsb.frogger.core.RuntimeData;

import java.net.URL;

/**
 * assets property data access object implementation
 */
public class AssetsDaoImpl implements AssetsDao {
    /**
     * get name
     *
     * @param propertyKey key
     * @return name
     */
    @Override
    public String getName(String propertyKey) {
        return RuntimeData.assets.getProperty(propertyKey);
    }

    /**
     * get URL
     *
     * @param propertyKey key
     * @return URL
     */
    @Override
    public URL getURL(String propertyKey) {
        return getClass().getResource(getName(propertyKey));
    }

    /**
     * get external form
     *
     * @param propertyKey key
     * @return string external form
     */
    @Override
    public String getExternal(String propertyKey) {
        return getURL(propertyKey).toExternalForm();
    }
}
