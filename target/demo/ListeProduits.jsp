<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.Produit" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
      <head>
          <title>Liste produits servlet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">                  
      </head>
            <body>
            
           
            <h1>La liste des produits</h1>
            <table class="table">
                <tr><td colspan="3">
                     <a href="AjouterProduit" >Ajouter</a></td>
                </tr>
                
                    <tr><th>Numéro</th><th>Description</th><th>Prix</th><th>Taxe</th><th>Commande</th>
                    <% for(Produit p:(List<Produit>)request.getAttribute("listeproduits")){%>
                        <tr><td><%= p.getNumero()%></td>
                            <td><%= p.getDescription()%></td>
                            <td><%= p.getPrix()%></td>
                            <% if(p.getTaxe()=='A'){%>
                                <td>Avec taxe</td>
                            <%}else{%>
                                <td>Sans taxe</td>
                            <%}%>
                            <td>
                                <a href="SupprimerProduit?numero=<%= p.getNumero()%>" class="btn btn-danger btn-lg">Supprimer</a> |
                                <a href="ModifierProduit?numero=<%= p.getNumero()%>" class="btn btn-primary btn-lg">Modifier</a>
                            </td>
                        </tr>               
                    <%}%>
               
            <table>
                
       </body>
    </html>