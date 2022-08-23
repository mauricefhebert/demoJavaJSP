package Models;

import javax.servlet.http.HttpServletRequest;

public class Produit {
    public Produit() {
    }

    public Produit(int _numero, String _description, double _prix, char _taxe) {
        this._numero = _numero;
        this._description = _description;
        this._prix = _prix;
        this._taxe = _taxe;
    }

    private int _numero;
    private String _description;
    private double _prix;
    private char _taxe;

    public int getNumero() {
        return _numero;
    }

    public void setNumero(int _numero) {
        this._numero = _numero;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public double getPrix() {
        return _prix;
    }

    public void setPrix(double _prix) {
        this._prix = _prix;
    }

    public char getTaxe() {
        return _taxe;
    }

    public void setTaxe(char _taxe) {
        this._taxe = _taxe;
    }

    public void Mapper(HttpServletRequest request) {

        this.setNumero(Integer.parseInt(request.getParameter("numero")));
        this.setDescription(request.getParameter("description"));
        this.setPrix(Double.parseDouble(request.getParameter("prix")));
        this.setTaxe(request.getParameter("taxe").charAt(0));
    }
}