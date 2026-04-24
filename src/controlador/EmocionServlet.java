package controlador;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmocionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String texto = request.getParameter("texto");
        String emocion = "Neutral";

        if (texto != null) {
            texto = texto.toLowerCase();

            if (texto.contains("feliz")) {
                emocion = "Felicidad";
            } else if (texto.contains("triste")) {
                emocion = "Tristeza";
            } else if (texto.contains("enojado")) {
                emocion = "Enojo";
            }
        }

        request.setAttribute("resultado", emocion);
        RequestDispatcher rd = request.getRequestDispatcher("resultado.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().println("Usa el formulario");
    }
}