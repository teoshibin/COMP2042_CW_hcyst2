package com.tsb.frogger.utils.data.datamanager;

import java.net.URL;

public interface AssetsDao {
    String getName(String propertyKey);
    URL getURL(String propertyKey);
    String getExternal(String propertyKey);
}
