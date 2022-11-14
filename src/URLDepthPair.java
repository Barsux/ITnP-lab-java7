import java.net.*;

public class URLDepthPair {
    private static final String MODULE_NAME = "URLDepthPair";
    private static final Logger l = new Logger(MODULE_NAME);
    private String url;
    private URL urlObject;
    private int depth;
    public URLDepthPair(String url, int depth){
        this.url = url;
        try{
            urlObject = new URL(url);
        } catch (MalformedURLException e) {
            l.log("Неправильный URL" + url);
            return;
        }
        this.depth = depth;
    }
    public String getURL(){
        return url;
    }
    public int getDepth(){
        return depth;
    }
    public String toString(){
        return url + " " + depth;
    }

    public String getHost(){
        return urlObject.getHost();
    }
    public String getPath(){
        return urlObject.getPath();
    }

    public boolean equals(Object o){
        if(o instanceof URLDepthPair){
            URLDepthPair p = (URLDepthPair)o;
            return url.equals(p.url);
        }
        return false;
    }
    public int hashCode(){
        return url.hashCode();
    }
}
