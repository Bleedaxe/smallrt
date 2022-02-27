package tpp.uni.plovdiv.data;

public class Sphere {
    private final double rad;
    private final Vec p;
    private final Vec e;
    private final Vec c;
    private final ReflT refl;

    public Sphere(double rad, Vec p, Vec e, Vec c, ReflT refl) {
        this.rad = rad;
        this.p = p;
        this.e = e;
        this.c = c;
        this.refl = refl;
    }

    public double intersect(Ray ray) {
        throw new RuntimeException("Not implemented!");
    }

    public Vec getP() {
        return p;
    }

    public Vec getE() {
        return e;
    }

    public Vec getC() {
        return c;
    }

    public ReflT getRefl() {
        return refl;
    }
}
