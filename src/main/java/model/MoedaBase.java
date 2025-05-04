package model;

public class MoedaBase {

    public MoedaBase(double usd, double eur, double jpy, double cny, double gbp, double chf, double brl) {
        this.usd = usd;
        this.eur = eur;
        this.jpy = jpy;
        this.cny = cny;
        this.gbp = gbp;
        this.chf = chf;
        this.brl = brl;
    }

    private double usd;
    private double eur;
    private double jpy;
    private double cny;
    private double gbp;
    private double chf;
    private double brl;

    @Override
    public String toString() {
        return "MoedaBase{" +
                "usd=" + usd +
                ", eur=" + eur +
                ", jpy=" + jpy +
                ", cny=" + cny +
                ", gbp=" + gbp +
                ", chf=" + chf +
                ", brl=" + brl +
                '}';
    }
}
