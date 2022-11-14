import java.text.SimpleDateFormat;
import java.util.Date;

/** Класс для логирования*/
public class Logger {
    private static final boolean DEBUG = true;
    private static final int PADDING = 10;
    private String pad;
    private String moduleName;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("[yyyy-MM-dd][HH:mm:ss:SSSS]");
    /** Конструктор класса, в каждом модуле вызывается со своим названием*/
    public Logger(String moduleName){
        this.moduleName = moduleName;
        pad = "";
        for(int i = 0; i < PADDING - moduleName.length(); i++){
            pad += " ";
        }
    }
    // Выводит сообщение в консоль с timestamp
    public void log(Object object){
        String message;
        if(object instanceof String) message = (String)object;
        else message = object.toString();
        if(DEBUG && message.length() != 0){
            String time = dateFormat.format(new Date());
            System.out.println(time + "[" + moduleName + "]" + pad + ": " + message);
        }
    }
}
