package Presenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Model.ParsingException;
import Model.Checker;
import View.View;

public class Presenter< V extends View> {

    private Checker model;
    private V view;

    public Presenter(V v) {
        view = v;
    }

    public void start() {
        boolean wokring = true;
        do {
            String input = view.getInput(
                    "Введите данные через пробел (Фамилию Имя Отчество ДатуРождения НомерТелефона Пол), или Exit для прекращения программы:");
            if (input.equals("Exit")) {
                wokring = false;
                break;
            } else {
                // множественные пробелы заменяем на одинарные (не считаем это страшной ошибкой)
                String[] splitedInput = input.replaceAll("\\s+", " ").split(" ");

                int inputDataCount = checkInputDataCount(splitedInput.length);
                if (inputDataCount == -1) {
                    view.printOutput("Слишком мало введенных данных (должно быть " + Checker.dataCount
                            + " разделённых пробелом ' ': Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
                } else if (inputDataCount == 0) {
                    view.printOutput("Слишком много введенных данных (должно быть " + Checker.dataCount
                            + " разделённых пробелом ' ': Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
                } else {
                    try {
                        model = new Checker();
                        model.CheckData(splitedInput);
                        writePersonData(model);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParsingException e) {
                        view.printOutput(e.getMessage());
                    }
                }
            }
        } while (wokring);
    }

    // проверяем кол-во введённых данных на соответствие
    private int checkInputDataCount(int inputDataCount) {
        if (inputDataCount < Checker.dataCount) {
            return -1;
        } else if (inputDataCount > Checker.dataCount) {
            return 0;
        } else {
            return inputDataCount;
        }
    }

    // подключаемся по фамилии и добавляем новые данные
    private void writePersonData(Checker data) throws IOException {
        File filepath = new File(data.getLastName());
        try (FileWriter fw = new FileWriter(filepath, true)) {
            fw.append(data.toString() + "\n");
        } catch (IOException e) {
            throw e;
        }
    }
}
