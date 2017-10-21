import java.io.IOException;

/**
 * Created by kissi on 05/10/17.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Parser p =new Parser();
//        System.out.println("\n Get from  python EIGENVALUES AND EIGENVECTORS :\n");
//
//        System.out.println(p.eigenVectors(5));

        double[][] eigenVectors=p.eigenVectors(5).getMatrix();
        double[] eigenValues= p.eigenValues(5);


                double lamda1=eigenValues[0], lamda2=eigenValues[1], lamda3=eigenValues[2],lamda4=eigenValues[3], lamda5=eigenValues[4];
        double[]
                v1=eigenVectors[0],
                v2=eigenVectors[1],
                v3=eigenVectors[2],
                v4=eigenVectors[3],
                v5=eigenVectors[4];


        double[][] b = {
                {6,6,5,5.5,8},
                {8,8,8,8,9},
                {6,7,11,9.5,11},
                {14.5,14.5,15.5,15,8},
                {14,14,12,12,10},
                {11,10,5.5,7,13},
                {5.5,7,14,11.5,10},
                {13,12.5,8.5,9.5,12},
                {9,9.5,12.5,12,18},
        };

        Matrix m1 = new Matrix(b);
        Matrix m5=((m1.centredMatrix()).reduceCentredMatrix());
        Matrix m6 = m5.fatcor(v1,v2,v3,v4,v5);

        //System.out.println(m6);

        Matrix m2=new Matrix(m6.getMatrix());
        System.out.println("======================NEW COORD WITH EIGEN VECTORS =========================\n\n***********PAGE 2 *************\n\n"+m6);
        Matrix m7= new Matrix(m6.getMatrix());
        //System.out.println("======================INDIVIDUAL CONTRIBUTION =========================\n\n"+m2.individualContribution(m7,lamda1,lamda2,lamda3));


        System.out.println("======================QUALITY OF REPRESENTATION =========================\n\n***********PAGE 4 *************\n\n"+m6.qualityOfRepresentation(m6));

        System.out.println("======================FACTORIAL COORD OF VARIABLES =========================\n\n***********PAGE 4 *************\n\n"+m6.coordFactorielOfVariable(m5,m6,lamda1,lamda2,lamda3));

        Matrix m8=m6.coordFactorielOfVariable(m5,m6,lamda1,lamda2,lamda3);

      //  System.out.println("======================CONTRIBUTION OF VARIABLES =========================\n\n***********PAGE 5 *************\n\n"+m6.contributionOfVariables(m8,lamda1,lamda2,lamda3));
        System.out.println("======================CONTRIBUTION OF VARIABLES =========================\n\n***********PAGE 6 *************\n\n"+m6.qualityOfRepresentation(m8));


    }
}