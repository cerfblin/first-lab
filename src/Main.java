import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dot A = new Dot(2, 1);
        Dot B = new Dot(5, 2);
        Dot C = new Dot(3, 5);
        Triangle t= new Triangle(A, B, C);

        Dot A1 = new Dot(5, 8);
        Dot B1 = new Dot(1, 2);
        Dot C1 = new Dot(1, 9);
        Triangle t1= new Triangle(A1, B1, C1);

        Dot A2 = new Dot(4, 4);
        Dot B2 = new Dot(7, 5);
        Dot C2 = new Dot(1, 4);
        Triangle t2= new Triangle(A2, B2, C2);

        List<Triangle> triangles = new ArrayList<>();

        triangles.add(0,t);
        triangles.add(1,t1);
        triangles.add(2,t2);
        Triangle max = triangles.get(0);
        double maxArea = triangles.get(0).getArea();
        Triangle min = triangles.get(0);
        double minArea = triangles.get(0).getArea();
        for(int i =0; i<triangles.size(); i++){
            if(maxArea<triangles.get(i).getArea()){
                max = triangles.get(i);
            }
        }
        for(int i =0; i<triangles.size(); i++){
            if(minArea>triangles.get(i).getArea()){
                min = triangles.get(i);
            }
        }

        int c1=0, c2=0, c3=0, c4=0;
        for(Triangle thisTriangle : triangles)
        {
            String type=thisTriangle.getTitle();
            if(type.contains("Равносторонний")) c1++;
            if(type.contains("Равнобедренный")) c2++;
            if(type.contains("Прямоугольный")) c3++;
            if(type.contains("Произвольный")) c4++;
        }

        System.out.println("Равносторонних: " + c1);
        System.out.println("Равнобедренных: " + c2);
        System.out.println("Прямоугольных: " + c3);
        System.out.println("Произвольных: " + c4);
        System.out.println("Наибольший по площади - " + max);
        System.out.println("Наименьший по площади - " + min);

    }
}
