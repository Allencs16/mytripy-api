package com.breallencs.mytripyapi.core.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("my-tripy")
public class MyTripyApiProperty {
    
    private String originAllowed = "http://localhost:4200";

    private final Security security = new Security();
	
	public Security getSecurity() {
		return security;
	}

	public String getOriginAllowed() {
		return originAllowed;
	}

	public void setOriginAllowed(String originPermitida) {
		this.originAllowed = originPermitida;
	}

	public static class Security{

		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
	
	}
}
