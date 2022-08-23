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
    /**
     * utiliser l’objet "request" pour lire l’en-tête HTTP (e.g. cookies) et les
     * données d’un formulaire HTML
     */
    /**
     * utiliser l’objet "response" pour spécifier l’en-tête de la réponse HTTP e.g.
     * specifier le content type, et les cookies).
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuper le dernier id et ajoute 1 a l'id
        int nextNum = dc.getListeProduits().stream().max(
                (e1, e2) -> Integer.compare(e1.getNumero(), e2.getNumero()))
                .get().getNumero() + 1;
        request.setAttribute("NetNum", nextNum);
        // Recuper la vue
        RequestDispatcher disp = request.getRequestDispatcher("/AjouterProduit.jsp");
        // Retourn la vue
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