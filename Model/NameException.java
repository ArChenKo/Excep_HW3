package Model;

public class NameException extends Exception {

    String inputString;

    public NameException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Неверный формат ФИО '" + inputString + "'. ФИО могут содержать только буквы.\n";
    }
}
