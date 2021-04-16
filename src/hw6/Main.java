package hw6;

public class Main {
    public static void main(String[] args) {
        String text = "Дженерики (обобщения) 1111 - это особые средства языка Java для реализации обобщённого программирования";
        Formatting formatting = new Formatting(text);
        formatting.formatText(text);
    }
}
