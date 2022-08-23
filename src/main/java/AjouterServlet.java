import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Produit;

public class AjouterServlet extends HttpServlet {
    private ProduitDataContext dc = new ProduitDataContext();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nextNum = dc.getListeProduits().stream().max(
                (e1, e2) -> Integer.compare(e1.getNumero(), e2.getNumero()))
                .get().getNumero() + 1;
        request.setAttribute("NetNum", nextNum);
        RequestDispatcher disp = request.getRequestDispatcher("/AjouterProduit.jsp");
        disp.forward(request, response); // return View(…)

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produit p = new Produit();
        p.Mapper(request);
        dc.add(p);
        response.sendRedirect("ListeProduits");// RedirecTotAction
    }

}