package ru.appline.servlets.userservlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.logic.User;
import ru.appline.servlets.ServletHelper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @example {"name": "John", "surname": "Smith", "salary": 150000}
 */
@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = ServletHelper.getJsonObject(gson, request);
        Model model = Model.getInstance();
        model.add(new User(
                jsonObject.get("name").getAsString(),
                jsonObject.get("surname").getAsString(),
                jsonObject.get("salary").getAsDouble()));
        ServletHelper.print(gson, response, model.getUsers());

    }
}
