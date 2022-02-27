package tpp.uni.plovdiv;

import tpp.uni.plovdiv.data.Ray;
import tpp.uni.plovdiv.data.ReflT;
import tpp.uni.plovdiv.data.Sphere;
import tpp.uni.plovdiv.data.Vec;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Util {

    private static double clamp(double x) {
        if (x < 0) {
            return 0;
        } else if (x > 1) {
            return 1;
        } else {
            return x;
        }
    }

    public static int toInt(double x) {
        return (int) (Math.pow(clamp(x), 1 / 2.2) * 255 + .5);
    }

    //TODO: This method should change t and id values
    public static boolean intersect(Sphere[] spheres, Ray r, double t, int id) {
        double d;
        double inf = t = 1e20;

        for (int i = spheres.length - 1; i >= 0; i--) {
            d = spheres[i].intersect(r);
            if (d > 0 && d < t) {
                t = d;
                id = i;
            }
        }

        //TODO: Extract 't' and 'id' values
        return t < inf;
    }

    public static Vec radiance(Sphere[] spheres, Ray r, int depth, int i) {
        double t = 0;
        int id = 0;
        //TODO: Create RadianceResult Object with default value 0
        if (!intersect(spheres, r, t, id)) {
            return new Vec();
        }

        Sphere sphere = spheres[id];

        Vec x = r.getO().plus(r.getD().multiply(t));
        Vec n = (x.minus(sphere.getP()));//.norm() What the heck is this???
        Vec nl = n.dot(r.getD()) < 0
                ? n
                : n.multiply(-1);
        Vec f = sphere.getC();

        double p = f.getX() > f.getY() && f.getX() > f.getZ() ? f.getX() : Math.max(f.getY(), f.getZ());

        int rand = ThreadLocalRandom.current().nextInt();
        if (++depth > 5)
        {
            if (rand < p)
            {
                f = f.multiply(1 / p);
            }
            else
            {
                return sphere.getE();
            }
        }
return null;
//        if (sphere.getRefl() == ReflT.DIFF) {
//            double r1 = 2 * Math.PI * erand48(Xi);
//            double r2 = erand48(Xi);
//            double r2s = Math.sqrt(r2);
//
//            Vec w = nl;
//            Vec u = ((fabs(w.x) > .1 ? Vec(0, 1) : Vec(1)) % w).norm();
//            Vec v = w % u;
//            Vec d = (u * cos(r1) * r2s + v * sin(r1) * r2s + w * sqrt(1 - r2)).norm();
//            return obj.e + f.mult(radiance(Ray(x, d), depth, Xi));
//        }
    }
}
