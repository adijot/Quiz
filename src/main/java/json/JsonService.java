package json;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class JsonService{
    JsonNode jsonNode;

    public JsonService (String jsonFile) {
        try {
            String filePath = System.getProperty("user.dir")  + "\\src\\main\\java\\files\\" + jsonFile;
            jsonNode = new ObjectMapper().readTree(new File(filePath));
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Brak pliku : " + jsonFile);

        }
    }

    public JsonService (String jsonFile, String projectPath) {
        try {
            String filePath = System.getProperty("user.dir")  + projectPath + jsonFile;
            jsonNode = new ObjectMapper().readTree(new File(filePath));
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Brak pliku : " + jsonFile);
        }
    }

    public JsonNode getJsonNode(){
        return jsonNode;
    }

}
