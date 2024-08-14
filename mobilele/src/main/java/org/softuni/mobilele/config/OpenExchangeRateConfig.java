package org.softuni.mobilele.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "open.exchange.rates")
public class OpenExchangeRateConfig {
    private String appID;

    private List<String> symbols;

    private String host;

    private String schema;

    private String path;

    private boolean isEnabled;

    @Override
    public String toString() {
        return "OpenExchangeRateConfig{" +
                "appID='" + appID + '\'' +
                ", symbols=" + symbols +
                ", host='" + host + '\'' +
                ", schema='" + schema + '\'' +
                ", path='" + path + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
