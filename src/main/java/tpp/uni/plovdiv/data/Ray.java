package tpp.uni.plovdiv.data;

public class Ray {

    private final Vec o;
    private final Vec d;

    public Ray(Vec o, Vec d) {
        this.o = o;
        this.d = d;
    }

    public Vec getO() {
        return o;
    }

    public Vec getD() {
        return d;
    }
}
