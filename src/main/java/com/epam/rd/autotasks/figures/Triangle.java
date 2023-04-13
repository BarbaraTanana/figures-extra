package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private Point a;
    private  Point b;
    private  Point c;

    public Triangle (Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException();
        }
        this.a=a;
        this.b=b;
        this.c=c;
        if (0.5 *(Math.abs((a.getX()-c.getX())*(b.getY()-a.getY())-(a.getX()-b.getX())*(c.getY()-a.getY())))==0) {
            throw new IllegalArgumentException("Exception because such a triangle would be degenerative");
        }
    }
    public  Point centroid() {
            return new Point(Math.pow(3,-1) *(a.getX()+b.getX()+c.getX()),
                    Math.pow(3,-1) *(a.getY()+b.getY()+c.getY()));
        }

    public double area() {
        double ar=0.5 *(Math.abs((a.getX()-c.getX())*(b.getY()-a.getY())-(a.getX()-b.getX())*(c.getY()-a.getY())));
        return ar;
    }

    public boolean isTheSame(Figure figure) {
        if (figure instanceof  Triangle) {
            return true;
        }
        if (figure==null) {
            return false;
        }

        Triangle other = (Triangle) figure;
        return (this.a==other.a) && (this.b==other.b) && (this.c==other.c);
    }

}
