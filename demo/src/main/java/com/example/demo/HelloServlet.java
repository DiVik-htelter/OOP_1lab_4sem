package com.example.demo;
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/calc")
public class HelloServlet extends HttpServlet {
    private String message;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        // получаем параметр id
        String abh = request.getParameter("abh");
        String r = request.getParameter("r");
        String a_tet = request.getParameter("a");
        String Rr = request.getParameter("Rr");

        String[] item_abh = abh.split(" ");
        String[] item_Rr = Rr.split(" ");
        int[] item_int = new int[5];
        for (int i = 0; i<5;i++)
        {
            if(i<=2)
                item_int[i] = Integer.parseInt(item_abh[i]);
            else
                item_int[i] = Integer.parseInt(item_Rr[i-3]);
        }
        try {
            writer.println("Объемы тел равны: ");
            writer.println("<h2>Паралеллепипед V = " +item_int[0]*item_int[1]*item_int[2]  + "</h2>");
            writer.println("<h2>Шар V = " + (4/3)*Math.PI* Math.pow(Integer.parseInt(r),3)  + "</h2>");
            writer.println("<h2>Тэтраэдр V = " + (Math.pow(Integer.parseInt(a_tet),3) * Math.sqrt(2)) /12 + "</h2>");
            writer.println("<h2>Тор V = " + 2* Math.PI*Math.PI*item_int[3]*Math.pow(item_int[4],2)+ "</h2>");

        } finally {
            writer.close();
        }
    }

    public void destroy() {
    }
}