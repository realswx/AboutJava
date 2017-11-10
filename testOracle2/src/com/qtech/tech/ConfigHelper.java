package com.qtech.tech;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @author Jay
 * @date 
 */
public class ConfigHelper
{
	private static Map<String, Properties> configCache = new HashMap<String, Properties>();

	public static URL findAsResource(String path)
	{
		URL url = null;

		url = Thread.currentThread().getContextClassLoader().getResource(path);

		if (null != url)
		{
			return url;
		}

		url = ConfigHelper.class.getClassLoader().getResource(path);

		if (null != url)
		{
			return url;
		}

		url = ClassLoader.getSystemClassLoader().getResource(path);

		return url;
	}

	public static Properties getConfig(String confName) throws IOException
	{
		if (null == configCache.get(confName))
		{
			Properties conf = new Properties();

			InputStream is = findAsResource(confName).openStream();

			conf.load(is);
			is.close();

			configCache.put(confName, conf);

			return conf;
		}
		
		return configCache.get(confName);
	}
}
