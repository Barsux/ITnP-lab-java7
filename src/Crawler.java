import java.net.*;
import java.util.LinkedList;


public class Crawler {
    private static final String MODULE_NAME = "Crawler";
    private static final Logger l = new Logger(MODULE_NAME);
    private static LinkedList<URLDepthPair> openPairs = new LinkedList<URLDepthPair>();
    private static LinkedList<URLDepthPair> closedPairs = new LinkedList<URLDepthPair>();
    public static String parseURL(String url){
        return url;
    }
    public static int parseDepth(String digit){
        try {
            return Integer.parseInt(digit);
        } catch (NumberFormatException e) {
            System.out.println("Invalid depth: " + digit);
            return -1;
        }
    }
    public static void main(String[] args){
        if(args.length != 2){
           System.out.println("Usage: java Crawler <URL> <depth>");
            System.exit(1);
        }
        String url = parseURL(args[0]);
        if(url == null){
            System.exit(1);
        }
        int maxDepth = parseDepth(args[1]);
        if(maxDepth == -1){
            System.exit(1);
        }
        l.log("Консольные аргументы верны.");
        openPairs.add(new URLDepthPair(url, 1));
        int ctr = 1;
        while(!openPairs.isEmpty()) {
            SiteReader reader = new SiteReader(openPairs, maxDepth);
            LinkedList<URLDepthPair> temp = reader.read();
            closedPairs.addAll(openPairs);
            openPairs.clear();
            for(URLDepthPair p : temp){
                if(!closedPairs.contains(p)){
                    openPairs.add(p);
                }
            }
            l.log("Шаг " + ctr++ + " | Ссылок обработано: " + closedPairs.size());
        }
        l.log("Все ссылки обработаны.");
        l.log("Вывод результатов:");
        for(URLDepthPair p : closedPairs){
            System.out.println(p);
        }
    }
}
