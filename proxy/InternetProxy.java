package proxy;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ahmad Alrefai
 * 
 */
public class InternetProxy implements ISP {

    private List<String> blockedSites = Arrays.asList("facebook", "porno", "twitter");

    @Override
    public String serverSite(String url) {
        logSite(url);
        if (blockedSites.contains(url)) {
            return "Naughty Boy, this site is blocked. Return to work!!!";
        }

        return new Etisalat().serverSite(url);
    }

    private void logSite(String url) {
        System.out.printf("[%d] %s%n", System.currentTimeMillis(), url);
    }
}
