package StarWars;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Core.API.GlobalAPIOne;

import javax.ws.rs.core.Response;

public class StarWarsApi extends GlobalAPIOne {

    @Test()
    public void StarWarsTest()
    {
        SoftAssert softAssertion= new SoftAssert();

        //Ищем персонажа (Luke Skywalker)
        String url="https://swapi.co/api/people/1/";
        Response Response = ApiGet(url);
        JSONObject Body_Response = new JSONObject(Response.readEntity(String.class));
        String homeworld = Body_Response.getString("homeworld");
        System.out.println("Body_Response: " + Body_Response);
        Assert.assertTrue(Response.getStatus() == 200);
        softAssertion.assertTrue(Body_Response.getString("name").contains("Luke Skywalker"),"Персонаж не Luke Skywalker");

        //Ищем Планету
        Response Response2 = ApiGet(homeworld);
        JSONObject Body_Response2 = new JSONObject(Response2.readEntity(String.class));
        String filmUrl = Body_Response2.getJSONArray("films").get(0).toString();
        Assert.assertTrue(Response2.getStatus() == 200);
        softAssertion.assertTrue(Body_Response2.getString("name").contains("Tatooine"),"Планета не Tatooine");
        softAssertion.assertTrue(Body_Response2.getString("population").contains("200000"),"Население не 200000");
        System.out.println("Body_Response2: " + Body_Response2);

        //Ищем Фильм
        Response Response3 = ApiGet(filmUrl);
        JSONObject Body_Response3 = new JSONObject(Response3.readEntity(String.class));
        Assert.assertTrue(Response3.getStatus() == 200);
        softAssertion.assertTrue(Body_Response3.getString("title").contains("Attack of the Clones"),"Название фильма не 'Attack of the Clones'");
        softAssertion.assertTrue(Body_Response3.getJSONArray("characters").toString().contains(url),"Luke Skywalker не принадлежит фильму");
        softAssertion.assertTrue(Body_Response3.getJSONArray("planets").toString().contains(homeworld),"Планета не принадлежит фильму");
        System.out.println("Body_Response3: " + Body_Response3);

        softAssertion.assertAll();
    }


}
