import com.srik.lib.Handler;

import java.util.HashMap;

public class Testing {

    public static void main(String args[]) throws Exception{

        Handler.init("com.srik.lib");

        HashMap<String,String> queryParams = new HashMap<>();

        queryParams.put("id","1");

        queryParams.put("name","test");

        Object object = Handler.send("hello","POST",queryParams);

        Object aObject = Handler.send("hello","GET",null);

        System.out.println(object +"\n"+ aObject);
    }
}
