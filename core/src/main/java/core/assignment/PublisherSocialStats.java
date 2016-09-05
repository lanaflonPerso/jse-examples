package core.assignment;

import java.util.List;

public interface PublisherSocialStats {
    // ===========================================================
    // Methods
    // ===========================================================

    // TODO You need to implement this
    int countDomainsWithMin2Articles(List<Article> articles);

    // TODO You need to implement this
    PublisherTotalShares getTopSocialPublisher(List<Article> articles);

    // TODO explain with a comment
    boolean areAboveMethodsThreadSafe();

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    public static class PublisherTotalShares {
        public final String publisher;
        public final int totalShares;

        public PublisherTotalShares(String publisher, int totalShares) {
            this.publisher = publisher;
            this.totalShares = totalShares;
        }
    }

    public static class Article {
        public final String canonicalUrl;
        public final int shares;

        public Article(String canonicalUrl, int shares) {
            this.canonicalUrl = canonicalUrl;
            this.shares = shares;
        }
    }
}
