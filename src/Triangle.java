import static java.lang.Math.pow;

public class Triangle implements Comparable<Triangle>{

    Dot A;
    Dot B;
    Dot C;

    String title;

    Triangle(Dot A, Dot B, Dot C){
        try {
            this.A = A;
            this.B = B;
            this.C = C;
            if(validate(A, B, C)){
                throw new Exception();
            }
        } catch (Exception e){
            System.out.println("EXCEPTION!!! Треугольник не может быть задан");
        }
        this.title = setTitle();
    }

    Triangle(float xA, float xB, float xC, float yA, float yB, float yC){
        try {
            this.A = new Dot(xA, yA);
            this.B = new Dot(xB, yB);
            this.C = new Dot(xC, yC);
            if(validate(A, B, C)){
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("С такими сторонами(точкмами) треугольников не сущетсвует");
        }
        this.title = setTitle();
    }
    double getDistance(Dot one, Dot two){             // Distance between Points
        //
        double firstKat =  Math.abs(one.getX() - two.getX());
        double secondKat =  Math.abs(one.getY() - two.getY());
        double hypotenuse = Math.sqrt(pow(firstKat,2) + pow(secondKat,2));
        return hypotenuse;
    }


    public boolean validate(Dot A, Dot B, Dot C){
        double AB = getDistance(this.A, this.B);
        double AC = getDistance(this.A, this.C);
        double BC = getDistance(this.B, this.C);
        if(AB+BC<=AC || AB+AC<=BC || BC+AC<=AB){ return true;}
        return false;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public int compareTo(Triangle o) {
        return  (int) (this.getArea()-o.getArea());
    }
    public double getPerimeter() {
        double AB = getDistance(this.A, this.B);
        double AC = getDistance(this.A, this.C);
        double BC = getDistance(this.B, this.C);
        return AB + BC + AC;
    }

    public double getArea() {
        double perimeter = getPerimeter();
        double AB = getDistance(this.A, this.B);
        double AC = getDistance(this.A, this.C);
        double BC = getDistance(this.B, this.C);
        return Math.sqrt((perimeter/2)*((perimeter/2)-AB)*((perimeter/2)-BC)*((perimeter/2)-AC));
    }

    private String setTitle(){
        double AB = Math.round(getDistance(this.A, this.B));
        double AC = Math.round(getDistance(this.A, this.C));
        double BC = Math.round(getDistance(this.B, this.C));
        StringBuilder title= new StringBuilder(" ");

        if(AB==BC && AB==AC && AC==BC){
            title.append("Равносторонний и Равнобедренный");
            return title.toString();
        }
            if(AB == BC || AB == AC || AC == BC)
            {
            title.append("Равнобедренный");
            }
        if(this.isRectangularTriangle())
        {
            if(title.isEmpty())
            title.append(" Прямоугольный ");
            else
                title.append("и Прямоугольный ");
            return title.toString();
        }
        if(title.isEmpty())
        title.append("Произвольный");

        return title.toString();
    }
    public String getTitle(){return title;}
    private boolean isRectangularTriangle(){
        double scalarMultiplyABxBC = getVector(this.A, this.B).getX()*getVector(this.B, this.C).getX()+getVector(this.A, this.B).getY()*getVector(this.B, this.C).getY();
        double scalarMultiplyABxAC = getVector(this.A, this.B).getX()*getVector(this.A, this.C).getX()+getVector(this.A, this.B).getY()*getVector(this.A, this.C).getY();
        double scalarMultiplyACxBC = getVector(this.A, this.C).getX()*getVector(this.B, this.C).getX()+getVector(this.A, this.C).getY()*getVector(this.B, this.C).getY();

        if(scalarMultiplyABxAC==0 || scalarMultiplyABxBC==0 || scalarMultiplyACxBC==0){
            return true;
        }
        return false;
    }
    private Dot getVector(Dot one, Dot two){
        Dot vector = new Dot(one.getX()-two.getX(), one.getY()- two.getY());
        return vector;
    }
}