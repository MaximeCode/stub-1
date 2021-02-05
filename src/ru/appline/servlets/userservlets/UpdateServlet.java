package ru.appline.servlets.userservlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.servlets.ServletHelper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @example {"id": 1, "name": "John", "surname": "Smith", "salary": 150000}
 */
@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = ServletHelper.getJsonObject(gson, request);
        Model model = Model.getInstance();
        model.getUser(jsonObject.get("id").getAsInt())
                .setName(jsonObject.get("name").getAsString())
                .setSurname(jsonObject.get("surname").getAsString())
                .setSalary(jsonObject.get("salary").getAsDouble());
        ServletHelper.print(gson, response, model.getUsers());
    }
}
