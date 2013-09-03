package com.shareaholic.storm.demo;

import java.net.URI;
import java.util.Date;

public class PageView {

    public final String domain;

    public final long id;

    public final Date loggedAt;

    public final String socialSource;

    public final String trafficSource;

    public final URI url;

    public PageView() {
        this(0, "", "", null, "", null);
    }

    public PageView(long id, String trafficSource, String socialSource, URI url, String domain, Date loggedAt) {
        this.id = id;
        this.trafficSource = trafficSource;
        this.socialSource = socialSource;
        this.url = url;
        this.domain = domain;
        this.loggedAt = loggedAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PageView other = (PageView) obj;
        if (domain == null) {
            if (other.domain != null) {
                return false;
            }
        } else if (!domain.equals(other.domain)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (loggedAt == null) {
            if (other.loggedAt != null) {
                return false;
            }
        } else if (!loggedAt.equals(other.loggedAt)) {
            return false;
        }
        if (socialSource == null) {
            if (other.socialSource != null) {
                return false;
            }
        } else if (!socialSource.equals(other.socialSource)) {
            return false;
        }
        if (trafficSource == null) {
            if (other.trafficSource != null) {
                return false;
            }
        } else if (!trafficSource.equals(other.trafficSource)) {
            return false;
        }
        if (url == null) {
            if (other.url != null) {
                return false;
            }
        } else if (!url.equals(other.url)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (domain == null ? 0 : domain.hashCode());
        result = prime * result + (int) (id ^ id >>> 32);
        result = prime * result + (loggedAt == null ? 0 : loggedAt.hashCode());
        result = prime * result + (socialSource == null ? 0 : socialSource.hashCode());
        result = prime * result + (trafficSource == null ? 0 : trafficSource.hashCode());
        result = prime * result + (url == null ? 0 : url.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PageView [id=" + id + ", trafficSource=" + trafficSource + ", socialSource=" + socialSource + ", url=" + url + ", domain=" + domain + ", loggedAt=" + loggedAt + "]";
    }
}