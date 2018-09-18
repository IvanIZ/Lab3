import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int countWord(final String url) {
        String output = urlToString(url);
        int count = 0;
        for (int i = 0; i < output.length() - 1; i++) {
            if (output.substring(i, i + 1).equals(" ")) {
                count++;
            }
        }
        return count;
    }
    public static int countUniqueWord(final String url, final String search) {
        int count = 0;
        String output = urlToString(url);
        for (int i = 0; i < output.length(); i++) {
            if (output.contains(search)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] unused){
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
    }
}
