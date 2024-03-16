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
     * @Author: Rodrigo Queiroz Vieira Freire
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
/*
Classe geraSenha tipo String
rand - Instância um novo objeto da classe Random
str - Instância um novo objeto da classe StringBuilder
String CHAR - Armazena todos os caracteres que podem ser possível da senha gerada
Int TamPass - Faz a randomização de acordo com os caracteres encontráveis na variável CHAR
str.append - Adiciona o caractere do TamPass na String
Str.toString() - Retorna a String da senha completa

Classe Main
int tamanho - Tamanho da senha
String senha - Recebe o retorno da classe geraSenha
String filename - Armazena o nome do arquivo .txt
file - Instância um novo objeto da classe File

Bloco try - catch
writer - Instância um nobo objeto da classe FileWriter
Se o arquivo Senhas.txt não existir
Crie um arquivo de texto Senhas.txt
Escreva a variável senha no arquivo de texto
Senao 
writer - Instância um nobo objeto da classe FileWriter
Escreva a variável senha no arquivo de texto existente
    */
