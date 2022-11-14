import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static final boolean DEBUG = true;
    private static final int PADDING = 10;
    private String pad;
    private String moduleName;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("[yyyy-MM-dd][HH:mm:ss:SSSS]");
    public Logger(String moduleName){
        this.moduleName = moduleName;
        pad = "";
        for(int i = 0; i < PADDING - moduleName.length(); i++){
            pad += " ";
        }
    }
    public void log(String message){
        if(DEBUG){
            String time = dateFormat.format(new Date());
            System.out.println(time + "[" + moduleName + "]" + pad + ": " + message);
        }
    }
}
