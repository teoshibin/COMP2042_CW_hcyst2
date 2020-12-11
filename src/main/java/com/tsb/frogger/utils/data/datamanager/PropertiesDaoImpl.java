package com.tsb.frogger.utils.data.datamanager;

import com.tsb.frogger.core.RuntimeData;

import java.net.URL;

public class PropertiesDaoImpl implements PropertiesDao {

    @Override
    public String getName(String propertyKey) {
        return RuntimeData.assets.getProperty(propertyKey);
    }

    @Override
    public URL getURL(String propertyKey) {
        return getClass().getResource(getName(propertyKey));
    }

    @Override
    public String getExternal(String propertyKey) {
        return getURL(propertyKey).toExternalForm();
    }
}
