package APP2019;

import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("driver")
public class DriverService {
    DriverInterface serviceInterface = new DriverInterface();

    //GET Drivers - All
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public ArrayList<Driver> getDrivers() {
        ArrayList<Driver> driverList = new ArrayList<Driver>();
        driverList = serviceInterface.getAll();

        return driverList;
    }

    //GET Driver - Single
    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Driver getDriver(@PathParam("id") String id) {

        return serviceInterface.getOne(id);

    }

    // GET Driver - Conditions
    // Ex:http://localhost:8080/api/driver/driverdetails?licnum=200&rating=3
    @GET
    @Path("driverdetails")
    @Produces({ MediaType.APPLICATION_JSON})
    public ArrayList<Driver> getDriversWithParams(@QueryParam("licnum") String licnum,
                                                  @QueryParam("rating") String rating) {
        ArrayList<Driver> driverList = new ArrayList<Driver>();
        driverList = serviceInterface.getAll();
        ArrayList<Driver> resultList = new ArrayList<Driver>();


        for(Driver driver: driverList){
            if(Integer.parseInt(licnum) == driver.getDrivingLicenseNumber()
                    && Integer.parseInt(rating) == driver.getRating()){
                resultList.add(driver);
            }
        }

        return resultList;
    }
}
