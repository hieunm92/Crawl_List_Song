import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();

            content = content.replaceAll("\\n+", "");
            Pattern pattern1 = Pattern.compile("name_song\">(.*?)</a>");
            Matcher matcher1 = pattern1.matcher(content);

            Pattern pattern = Pattern.compile("name_singer\"(.*?)>(.*?)</a>");
            Matcher matcher = pattern.matcher(content);
            while (matcher1.find() && matcher.find()) {
                System.out.println(matcher1.group(1));
                System.out.println(matcher.group(2));

            }

        } catch (Exception e) {

        }
    }
}
