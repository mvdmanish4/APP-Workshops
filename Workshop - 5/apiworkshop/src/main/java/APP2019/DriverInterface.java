package APP2019;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;

public class DriverInterface {

    MongoCollection<Document> collection;

    public DriverInterface() {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("APP19_Workshop5");

        this.collection = database.getCollection("driver");
    }

    public ArrayList<Driver> getAll() {

        ArrayList<Driver> driverList = new ArrayList<Driver>();

        FindIterable<Document> results = collection.find();
        if (results == null) {
            return  driverList;
        }
        for (Document item : results) {
            Driver driver = new Driver(
                    item.getString("firstName"),
                    item.getString("middleName"),
                    item.getString("lastName"),
                    item.getString("emailId"),
                    item.getString("password"),
                    item.getString("phoneNumber"),
                    item.getString("address1"),
                    item.getString("address2"),
                    item.getString("city"),
                    item.getString("state"),
                    item.getString("country"),
                    item.getString("postalCode"),
                    item.getInteger("rating"),
                    item.getInteger("drivingLicenseNumber"),
                    item.getString("dlIssuedState")
            );
            driver.setId(item.getObjectId("_id").toString());
            driverList.add(driver);
        }
        return driverList;
    }


    public Driver getOne(String id) {


        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));

        Document item = collection.find(query).first();
        if (item == null) {
            return  null;
        }
        Driver driver = new Driver(
                item.getString("firstName"),
                item.getString("middleName"),
                item.getString("lastName"),
                item.getString("emailId"),
                item.getString("password"),
                item.getString("phoneNumber"),
                item.getString("address1"),
                item.getString("address2"),
                item.getString("city"),
                item.getString("state"),
                item.getString("country"),
                item.getString("postalCode"),
                item.getInteger("rating"),
                item.getInteger("drivingLicenseNumber"),
                item.getString("dlIssuedState")
        );
        driver.setId(item.getObjectId("_id").toString());
        return driver;

    }
}
