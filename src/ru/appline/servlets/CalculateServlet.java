package ru.appline.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.servlets.ServletHelper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @example {"a": "2", "b": 2, "math": "+"}
 */
@WebServlet(urlPatterns = "/calculate")
public class CalculateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = ServletHelper.getJsonObject(gson, request);
        double a = jsonObject.get("a").getAsDouble();
        double b = jsonObject.get("b").getAsDouble();
        String math = jsonObject.get("math").getAsString();
        Map<String, Double> result = new HashMap<>();
        switch (math) {
            case "+":
                result.put("result", a + b);
                break;
            case "-":
                result.put("result", a - b);
                break;
            case "*":
                result.put("result", a * b);
                break;
            case "/":
                result.put("result", a / b);
        }
        ServletHelper.print(gson, response, result);
    }
}
