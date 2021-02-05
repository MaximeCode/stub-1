package ru.appline.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletHelper {

    public static JsonObject getJsonObject(Gson gson, HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        StringBuilder jsonString = new StringBuilder();
        request.getReader().lines().forEach(jsonString::append);
        return gson.fromJson(jsonString.toString(), JsonObject.class);
    }

    public static void print(Gson gson, HttpServletResponse response, Object object) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(gson.toJson(object));
    }
}
