import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Student9 on 15.04.2017.
 */
public class FigureToFile {

    public void main (Object object) {
        try {
            OutputStream outputStream = new FileOutputStream("output.txt");
            String figureStr = object.toString();
            byte figureBytes[] = figureStr.getBytes();
            outputStream.write(figureBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}