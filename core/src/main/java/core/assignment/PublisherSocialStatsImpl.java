package core.assignment;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class PublisherSocialStatsImpl implements PublisherSocialStats {

    public static String getPublisher(Article article) throws MalformedURLException {
        URL aURL = new URL(article.canonicalUrl);
        final int lastIndex = aURL.getHost().lastIndexOf(".");
        final int secondlastIndex = aURL.getHost().substring(0, lastIndex).lastIndexOf(".");
        if (secondlastIndex == -1) {
            return aURL.getHost();
        } else {
            return aURL.getHost().substring(secondlastIndex + 1, aURL.getHost().length());
        }
    }

    @Override
    public int countDomainsWithMin2Articles(final List<Article> articles) {
        int count = 0;
        final Set<String> domains = new HashSet<>();
        final Set<String> domainsArticle = new HashSet<>();
        synchronized (this) {
            if (articles.size() >= Math.pow(10, 6)) {
                throw new UnsupportedOperationException();
            }
            for (Article article : articles) {
                try {
                    if (!domains.add(getDomain(article)) && domainsArticle.add(getDomain(article))) {
                        count++;
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(PublisherSocialStatsImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }

    @Override
    public PublisherTotalShares getTopSocialPublisher(final List<Article> articles) {
        final Map<String, PublisherTotalShares> publishers = new HashMap<>();
        PublisherTotalShares topTotalShares = null;
        synchronized (this) {
            if (articles.size() >= Math.pow(10, 6)) {
                throw new UnsupportedOperationException();
            }
            for (final Article article : articles) {
                try {
                    final String puString = getPublisher(article);
                    if (null != publishers.get(puString)) {
                        publishers.put(puString, new PublisherTotalShares(puString,
                                publishers.get(puString).totalShares + article.shares));
                    } else {
                        publishers.put(puString, new PublisherTotalShares(puString, article.shares));
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(PublisherSocialStatsImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            int top = 0;
            for (PublisherTotalShares a : publishers.values()) {
                if (top <= a.totalShares) {
                    topTotalShares = a;
                    top = a.totalShares;
                }
            }
        }
        return topTotalShares;
    }

    @Override
    public boolean areAboveMethodsThreadSafe() {
        // TODO Auto-generated method stub
        return false;
    }

    private String getDomain(final Article article) throws MalformedURLException {
        URL url = new URL(article.canonicalUrl);
        return url.getHost();
    }

    @Test
    public void sameDomainSameArtclesTest() {
        final String canonicalURL = "http://blog.newswhip.com/index.php/2015/03/a-qa-with-ashish-patel-nowthiss-vp-of-social";
        Article article = new Article(canonicalURL, 1);
        List<Article> articleList = Arrays.asList(article, article);
        assertEquals(1, countDomainsWithMin2Articles(articleList));
    }

    @Test
    public void sameDomainDiffrentArtclesTest() {
        final String canonicalURL = "http://blog.newswhip.com/index.php/2015/03/a-qa-with-ashish-patel-nowthiss-vp-of-social";
        final String canonicalURL2 = "http://blog.newswhip.com/index.php/2015/03/different-content-different-facebook-interactions";
        final String canonicalURL3 = "http://blog.newswhip.com/index.php/2015/03/different-content-different-facebook-photos";
        List<Article> articleList = Arrays.asList(new Article(canonicalURL, 1), new Article(canonicalURL2, 1),
                new Article(canonicalURL3, 1));
        assertEquals(1, countDomainsWithMin2Articles(articleList));
    }

    @Test
    public void testGetTopSocialPublisher() {
        List<PublisherSocialStats.Article> articles = new ArrayList<>();
        PublisherSocialStatsImpl instance = new PublisherSocialStatsImpl();
        PublisherSocialStats.Article article1 = new PublisherSocialStats.Article(
                "http://blog.newswhip.com/index.php/2015/03/a-qa-with-ashish-patel-nowthiss-vp-of-social", 70);
        PublisherSocialStats.Article article2 = new PublisherSocialStats.Article(
                "http://www.newswhip.com/index.php/2015/03/different-content-different-facebook-interactions", 2);
        PublisherSocialStats.Article article3 = new PublisherSocialStats.Article(
                "http://www.newswhip1.com/index.php/2015/03/different-content-dions", 2);
        PublisherSocialStats.Article article5 = new PublisherSocialStats.Article(
                "http://newswhip.com/index.php/2015/03/dfferent-facebook-interactions", 2);
        PublisherSocialStats.Article article4 = new PublisherSocialStats.Article(
                "http://something.newswhip.com/index.php/2015/03/different-content-different-facebook-interactions", 2);
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        int expResult = 76;
        PublisherSocialStats.PublisherTotalShares result = instance.getTopSocialPublisher(articles);
        assertEquals(expResult, result.totalShares);
        assertEquals("newswhip.com", result.publisher);
    }

}
