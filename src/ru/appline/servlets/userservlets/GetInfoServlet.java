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
 * @example {"id": 0}
 */
@WebServlet(urlPatterns = "/getInfo")
public class GetInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = ServletHelper.getJsonObject(gson, request);
        Model model = Model.getInstance();
        int id = jsonObject.get("id").getAsInt();
        ServletHelper.print(gson, response, id == 0 ? model.getUsers() : model.getUser(id));
    }
}
