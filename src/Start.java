import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kissi on 20/10/17.
 */
public class Start {
    public static void main(String[] args) throws IOException {

        double[][] arrayOfData = {
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


        Matrix m1 = new Matrix(arrayOfData);
        Matrix m5=((m1.centredMatrix()).reduceCentredMatrix());


        String current = new java.io.File( "." ).getCanonicalPath();

        PrintWriter writer = new PrintWriter("corrMatrix", "UTF-8");
        writer.println(((m1.centredMatrix()).reduceCentredMatrix()).varCorrelationOfReducedMatrix().pythonFormat());
        writer.close();


        try {

            Process process = Runtime.getRuntime().exec("python "+current+"/app.py");


        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }


    }
}
