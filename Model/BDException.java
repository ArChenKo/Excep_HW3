package Model;

public class BDException extends Exception {

    String inputString;

    public BDException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Неверный ввод даты '" + inputString + "', правильный формат - 'дд.мм.гггг'.\n";
    }
}