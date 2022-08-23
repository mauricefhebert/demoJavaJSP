import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Produit;

public class ModifierServlet extends HttpServlet {
    private ProduitDataContext dc = new ProduitDataContext();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produit p = dc.find(Integer.parseInt(request.getParameter("numero")));
        request.setAttribute("produit", p);

        RequestDispatcher disp = request.getRequestDispatcher("/ModifierProduit.jsp");
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produit p = new Produit();
        p.Mapper(request);
        dc.update(p);
        response.sendRedirect("ListeProduits");
    }

}