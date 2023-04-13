package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Circle extends  Figure {
    private  Point center;
    private  double r;
    private static final double DELTA = 1e-15;

    public Circle (Point center,double r) {
        this.center=center;
        this.r=r;

        if (r<=0 || center==null) {
            throw new IllegalArgumentException("Exception because such a circle would be degenerative");
        }
    }
    public  Point centroid() {
        return center;
    }

    public boolean isTheSame(Figure figure) {
        if (figure == null) {
            return false;
        }
        if (this == figure) {
            return true;
        }
        if (figure instanceof Circle) {
            return true;
        }
        Circle one = (Circle) figure;
        if (Math.abs(this.r - one.r) >DELTA) {
            return false;
        }
        return (this.center == one.center) && (this.r == one.r);
    }


}
