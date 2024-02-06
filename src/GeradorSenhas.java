import java.security.SecureRandom;

public class GeradorSenhas {

    public static void main(String[] args) {
        String senhaGerada = gerarSenha(12); // Substitua 12 pelo comprimento desejado da senha
        System.out.println("Senha gerada: " + senhaGerada);
    }

    public static String gerarSenha(int comprimento) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder senha = new StringBuilder();

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }
}

