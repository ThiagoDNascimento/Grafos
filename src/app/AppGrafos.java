import java.io.BufferedReader;
import java.io.FileReader;

public class AppGrafos {
    public static void main(String[] args) throws Exception {
        
        String filename = "entrada.txt";

        try (BufferedReader buffer = new BufferedReader(new FileReader(filename))){
            String linha;
            int quantidadeCidades = Integer.parseInt(buffer.readLine()); // quantidade de cidades na primeira linha do arquivo

        } catch (Exception e) {
            // TODO: handle exception
        }





    }
}
