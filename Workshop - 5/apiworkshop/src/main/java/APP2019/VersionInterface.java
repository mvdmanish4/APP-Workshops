package APP2019;

import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class VersionInterface {


    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public JSONObject getAll() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("version", "0.0.1");
            obj.put("date", "2019-09-23");
        }
        catch(Exception e) {
            System.out.println("Could not set version");
        }
        return obj;
    }

}