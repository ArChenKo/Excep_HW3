package Model;

public class PhoneException extends Exception {
    String inputString;

    public PhoneException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка определения " + inputString + " в телефонный номер, (верный формат телефона - 10 цифр без разделителей 1231234567)\n";
    }
}
