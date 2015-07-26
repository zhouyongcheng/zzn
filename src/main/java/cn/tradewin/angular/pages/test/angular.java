package cn.tradewin.angular.pages.test;

import org.apache.tapestry5.annotations.Events;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;

//@Import(stack={"AngularStack"}, library={"context:js/controllers/controllers-angular.js"})
@Events({ "test"})
public class angular {

	@OnEvent(value="test")
    JSONArray onTestResponse() {
        JSONObject o = new JSONObject();
        o.put("username", "zhouyc");
        o.put("age", 37);
        
        JSONObject b = new JSONObject();
        b.put("username", "anxw");
        b.put("age", 34);

        JSONArray a = new JSONArray();
        a.put(o);
        a.put(b);
        return a;
    }
}
