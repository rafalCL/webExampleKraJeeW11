package pl.coderslab.web.post.zad2;

public class Censor {
    private static final String[] FORBIDDEN_WORDS = {"cholera", "kurde", "motyla noga"};

    public static String doCensor(final String toBeCensored) {
        String censored = toBeCensored;

        for(String forbidden : FORBIDDEN_WORDS) {
            censored = censored.replaceAll(forbidden, "*".repeat(forbidden.length()));
        }
        return censored;
    }
}
