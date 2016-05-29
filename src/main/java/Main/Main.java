package Main; /**
 * Created by saleta on 5/23/2016.
 */

import static spark.Spark.*;

public class Main {
    public static void main(String[] args)
    {
        staticFileLocation("/publico");

        new ManejoTemplates().manejarTemplates();
    }
}
