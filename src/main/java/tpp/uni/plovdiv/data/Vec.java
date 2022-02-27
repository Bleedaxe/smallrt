package tpp.uni.plovdiv.data;

public class Vec {

    private final double x;
    private final double y;
    private final double z;

    public Vec(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec() {
        this(0, 0, 0);
    }

    public Vec plus(Vec b) {
        return new Vec(x + b.x, y + b.y, z + b.z);
    }

    public Vec minus(Vec b) {
        return new Vec(x - b.x, y - b.y, z - b.z);
    }

    public Vec multiply(Vec b) {
        return new Vec(x * b.x, y * b.y, z * b.z);
    }

    public Vec multiply(double b) {
        return new Vec(x * b, y * b, z * b);
    }

    public double dot(Vec b) {
        return x * b.x + y * b.y + z * b.z;
    }

    public Vec divide(Vec b) {
        return new Vec(y * b.z - z * b.y, z * b.x - x * b.z, x * b.y - y * b.x);

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
