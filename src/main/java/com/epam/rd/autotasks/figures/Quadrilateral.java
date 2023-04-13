package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null | c == null || d == null) {
            throw new IllegalArgumentException("All points must be non-null.");
        }
        if (a.equals(b) || a.equals(c) || a.equals(d) ||
                b.equals(c) || b.equals(d) || c.equals(d)) {
            throw new IllegalArgumentException("All points must be distinct.");
        }
        if( new Triangle(a,b,c).area()<=0 || new Triangle(a,b,d).area()<=0 || new Triangle(b,c,d).area()<=0 || new Triangle(a,c,d).area()<=0)
            throw new IllegalArgumentException();

        if((new Segment(a, c).intersection(new Segment(b, d)) == null))
            throw new IllegalArgumentException();

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public  Point centroid() {
        Point g1=new Triangle(a,b,c).centroid();
        Point g2=new Triangle(a,b,d).centroid();
        Point g3=new Triangle(a,c,d).centroid();
        Point g4=new Triangle(b,c,d).centroid();
        return (new Segment(g1,g3)).intersection(new Segment(g2,g4));
    }


    public boolean isTheSame(Figure figure) {
        if (this == figure) {
            return true;
        }
        if (figure instanceof Quadrilateral) {
            return true;
        }
        if (figure == null) {
            return false;
        }
        Quadrilateral one = (Quadrilateral) figure;

        if ((this.a == one.a) && (this.b == one.b) && (this.c == one.c) && (this.d == one.d)) {
            return true;
        }
        if ((this.b == one.a) && (this.c == one.b) && (this.d == one.c) && (this.a == one.d)) {
            return true;
        }
        if ((this.b == one.a) && (this.a == one.b) && (this.d == one.c) && (this.c == one.d)) {
            return true;
        }
        if ((this.c == one.a) && (this.b == one.b) && (this.a == one.c) && (this.d == one.d)) {
            return true;
        } else {
            return false;
        }
    }
}
   class Segment {
    private final double xStart;
    private final double xEnd;
    private final double yStart;
    private final double yEnd;

    public Segment(Point start, Point end) {
        xStart = start.getX();
        xEnd = end.getX();
        yStart = start.getY();
        yEnd = end.getY();
        if ((xStart == xEnd) && (yStart == yEnd)) {
            throw new IllegalArgumentException();
        }
    }

    Point intersection(Segment another) {
        double k = (xStart - xEnd) * (another.yStart - another.yEnd) - (yStart - yEnd) * (another.xStart - another.xEnd);
        double t, u;
        if (k == 0) {
            return null;
        }
        t = ((xStart - another.xStart) * (another.yStart - another.yEnd) - (yStart - another.yStart) * (another.xStart - another.xEnd)) / k;
        u = ((xStart - another.xStart) * (yStart - yEnd) - (yStart - another.yStart) * (xStart - xEnd)) / k;
        if ((t < 0 || t > 1) || (u < 0 || u > 1)) {
            return null;
        }
        return new Point(xStart + t * (xEnd - xStart), yStart + t * (yEnd - yStart));
    }

}