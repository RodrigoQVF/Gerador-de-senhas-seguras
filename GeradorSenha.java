import java.util.Random;
import java.io.FileWriter;
import java.io.File;

public class GeradorSenha {
    public static String geraSenha(int tamanho) {
        Random rand = new Random();
        StringBuilder str = new StringBuilder(tamanho);

        String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!&@$";

        for (int i = 0; i < tamanho; i++) {
            int TamPass = rand.nextInt(CHAR.length());
            str.append(CHAR.charAt(TamPass));
        }
        return str.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int tamanho = 15;
        String senha;
        String filename = "Senhas.txt";
        File file = new File(filename);
        senha = geraSenha(tamanho);

    

        try {
            if(!file.exists()){
                FileWriter writer = new FileWriter(filename);
                writer.write(senha);
                writer.close();
            }else{
                FileWriter writer = new FileWriter(filename, true);
                writer.write("\n" + senha);
                writer.close();
            }

        } catch (Exception e) {
            System.out.println("Erro ao criar arquivo");
        }
    }
}