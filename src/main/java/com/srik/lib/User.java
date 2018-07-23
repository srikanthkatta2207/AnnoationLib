package com.srik.lib;

import com.srik.lib.annotations.GET;
import com.srik.lib.annotations.PATH;
import com.srik.lib.annotations.POST;
import com.srik.lib.annotations.QueryParam;

@PATH("hello")
public class User {

    String name = "Hi sriknath";

    @GET
    public String getName() {
        return name;
    }

    @POST
    public String postName(@QueryParam("id") String id,@QueryParam("name") String name) {
        return "hi: " + name + "\nyour id is: " + id;
    }

}
