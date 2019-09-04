import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MongoJava {

 public static void main (String args[]) {

     MongoClient mongoCli = new MongoClient();
     MongoDatabase db = mongoCli.getDatabase("sm2019");

     db.createCollection("APP");
     db.createCollection("PDV");
     db.createCollection("FSM");
     db.createCollection("SEM");

     collectionInsert(db,"PDV","PDV - Assg 1","Assignment 1 submission","Tom Hanks","A");
     collectionInsert(db,"FSM","FSM - Assg 1","Assignment 1 submission","Tom Hanks","B");
     collectionInsert(db,"APP","APP - Assg 1","Assignment 1 submission","Tom Hanks","C");
     collectionInsert(db,"SEM","SEM - Assg 1","Assignment 1 submission","Tom Hanks","D");

     collectionUpdate(db,"PDV","PDV - Assg 1","B");
     collectionUpdate(db,"FSM","FSM - Assg 1","C");
     collectionUpdate(db,"APP","APP - Assg 1","D");
     collectionUpdate(db,"SEM","SEM - Assg 1","Fail");

     retrieveDocuments(db,"PDV");
     retrieveDocuments(db,"FSM");
     retrieveDocuments(db,"APP");
     retrieveDocuments(db,"SEM");

     deleteDocuments(db,"SEM", "SEM - Assg 1");

     retrieveDocuments(db,"PDV");
     retrieveDocuments(db,"FSM");
     retrieveDocuments(db,"APP");
     retrieveDocuments(db,"SEM");

     retrieveCollections(db);

     collectionsDrop(db,"SEM");
     collectionsDrop(db,"FSM");

     retrieveCollections(db);
 }

    private static void collectionsDrop(MongoDatabase db, String collectionName){
        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.drop();
    }

    private static void retrieveCollections(MongoDatabase db){
        MongoIterable<String> values = db.listCollectionNames();
        for (String s : values) {
            System.out.println(s);
        }
    }

    private static void deleteDocuments(MongoDatabase db, String collectionName, String title){
        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.deleteOne(Filters.eq("title", title));
    }

    private static void retrieveDocuments(MongoDatabase db, String collectionName){
        MongoCollection<Document> collection = db.getCollection(collectionName);
        FindIterable<Document> iterDoc = collection.find(); int i = 1;
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
    }

    private static void collectionInsert(MongoDatabase db, String collectionName, String title, String description,String student, String grade){
        MongoCollection<Document> collection = db.getCollection(collectionName);
        Document document = new Document("title", title).append("description", description).append("student", student).append("grade", grade);
        collection.insertOne(document);
    }

    private static void collectionUpdate(MongoDatabase db, String collectionName, String title,String grade){
        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.updateOne(Filters.eq("title", title), Updates.set("grade", grade));
    }
}
