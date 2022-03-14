package  edu.escuelaing.arep;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.*;


public class MongoConexion {

    public static void main(String[] args) {
        port(getPort());
        post("/",(req, res)->{
            res.type("application/json");
            return insert(Integer.valueOf(req.queryParams("value")));
        });
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String insert(int a){
        MongoClient mongoClient = new MongoClient("db");
        MongoDatabase db = mongoClient.getDatabase("Lista");
        MongoCollection<Document> collection = db.getCollection("datos");
        if(collection.countDocuments()==10){
            collection.deleteOne(Filters.eq("id",0));
            Document updated = new Document().append("$inc", new Document().append("id", -1));
            collection.updateMany(Filters.gt("id",0),updated);
        }
        collection.insertOne(new Document().append("id",collection.countDocuments()).append("value", a));
        ArrayList<String> res = new ArrayList<>();
        collection.find().forEach((Consumer<Document>) (Document d) -> { res.add(d.get("value").toString());});
        mongoClient.close();
        return Arrays.toString(res.toArray(new String[res.size()]));
    }
} 
