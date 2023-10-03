package Model;

public class GenderException extends Exception {
    String inputString;

    public GenderException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Пол указан неверно (используйте только латинские буквы f - Женщина или m - Мужчина)\n";
    }
}
