package  edu.escuelaing.arep;

import static spark.Spark.*;


public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/",(req, res)->{
            return "Hello from Docker";
        });
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }


}
