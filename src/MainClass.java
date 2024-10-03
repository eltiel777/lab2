public class MainClass {
    public static void main(String[] args) {
        System.out.println("--Задача a--");
        System.out.println("На основе двумерной числовой матрицы необходимо сгенерировать новую матрицу,");
        System.out.println("в которой элементы равны произведению соответствующих элементов исходной матрицы на сумму элементов исходной матрицы.");

        // Тест 1
        System.out.println("Тест 1");

        Array matrix1 = new Array(new int[][]{{1, 2}, {3, 4}});
        ArrayOperations test1 = new ArrayOperations(matrix1);
        test1.countSum();
        test1.createFinalMatr();
        test1.printResult(matrix1, test1.getFinalMatr());
        System.out.println(" ");

        // Тест 2
        System.out.println("Тест 2");
        Array matrix2 = new Array(new int[][]{{-1, -2}, {-3, -4}});
        ArrayOperations test1_2 = new ArrayOperations(matrix2);
        test1_2.countSum();
        test1_2.createFinalMatr();
        test1_2.printResult(matrix2, test1_2.getFinalMatr());
        System.out.println(" ");

        // Тест 3
        System.out.println("Тест 3");
        Array matrix3 = new Array(new int[][]{{0, 0}, {0, 0}, {0, 0}});
        ArrayOperations test1_3 = new ArrayOperations(matrix3);
        test1_3.countSum();
        test1_3.createFinalMatr();
        test1_3.printResult(matrix3, test1_3.getFinalMatr());
        System.out.println(" ");

        // Тесты для задачи b
        System.out.println("--Задача b--");
        System.out.println("Сдвинуть вправо все нулевые элементы матрицы.");

        System.out.println("Тест 1");
        Array nulMatr1 = new Array(new int[][]{{0, 1, 0, 2}, {3, 0, 4, 5}});
        ArrayOperations test2_1 = new ArrayOperations(nulMatr1);
        test2_1.moveZeros();
        test2_1.printResult(nulMatr1, test2_1.getFinalMatr());
        System.out.println(" ");

        System.out.println("Тест 2");
        Array nulMatr2 = new Array(new int[][]{{1, 3, 6, 8}});
        ArrayOperations test2_2 = new ArrayOperations(nulMatr2);
        test2_2.moveZeros();
        test2_2.printResult(nulMatr2, test2_2.getFinalMatr());
        System.out.println(" ");

        System.out.println("Тест 3");
        Array nulMatr3 = new Array(new int[][]{{5, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 0, 0}, {0, 0, 0, 3, 1, 9}});
        ArrayOperations test2_3 = new ArrayOperations(nulMatr3);
        test2_3.moveZeros();
        test2_3.printResult(nulMatr3, test2_3.getFinalMatr());
        System.out.println(" ");

        System.out.println("--Задача c--");
        System.out.println("Сгенерировать новую одномерную матрицу из элементов двумерной преобразованной матрицы,");
        System.out.println("расположив элементы в порядке возрастания.");

        //задача С
        System.out.println("Тест 1");
        Array matrixC1 = new Array(new int[][]{{5, 7, 1}, {3, 8, 9}, {1, 6, 2}});
        ArrayOperations test3_1 = new ArrayOperations(matrixC1);
        int[] oneMatr1 = test3_1.transformationToOne();
        test3_1.sort(oneMatr1);
        test3_1.printArray(oneMatr1);

        System.out.println("Тест 2");
        Array matrixC2 = new Array(new int[][]{{8, -4, 0}, {-2, 1, 4}, {5, 0, 5}});
        ArrayOperations test3_2 = new ArrayOperations(matrixC2);
        int[] oneMatr2 = test3_2.transformationToOne();
        test3_2.sort(oneMatr2);
        test3_2.printArray(oneMatr2);

        System.out.println("Тест 3");
        Array matrixC3 = new Array(new int[][]{{2, 0, 0}, {1, 7, 12}, {100, 32, 1}});
        ArrayOperations test3_3 = new ArrayOperations(matrixC3);
        int[] oneMatr3 = test3_3.transformationToOne();
        test3_3.sort(oneMatr3);
        test3_3.printArray(oneMatr3);

        // Тест для задачи D
        System.out.println("--Задача d--");
        System.out.println("Найти количество слов в предложении, стоящих между самым коротким и самым длинным словом.");

        System.out.println("Тест 1");
        String sentence1 = "рыжий кот любил есть картофель очень";
        System.out.println("Предложение: " + sentence1);
        TextAnalysis.taskD(sentence1);

        System.out.println("Тест 2");
        String sentence2 = "кот кот кот кот";
        System.out.println("Предложение: " + sentence2);
        TextAnalysis.taskD(sentence2);

        System.out.println("Тест 3");
        String sentence3 = "мой брат гуляет просто так";
        System.out.println("Предложение: " + sentence3);
        TextAnalysis.taskD(sentence3);
    }
}

class Array { // отвечает за хранение данных, сами массивы
    private int[][] data; // поле с исходными данными, private - доступ только внутри класса

    // ОБЪЯВЛЕНИЕ КОНСТРУКТОРОВ
    public Array() { // конструктор без аргументов, т.е. массив пустой будет
        this.data = new int[0][0]; // this - ссылка на текущий объект
    }

    public Array(int[][] data) {
        this.data = data; // создается матрица с заданными значениями
    }

    // ОБЪЯВЛЕНИЕ МЕТОДОВ
    public void enterData(int[][] data) { // ввод данных в массив
        this.data = data;
    }

    public int[][] getData() { // получить данные массива
        return data;
    }

    public void print() { // вывод массива
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println(); // Перенос строки для красивого отображения матрицы
        }
    }
}

class ArrayOperations { // отвечает за операции над массивом
    // задача A
    private Array originalMatr; // исходная матрица класса массивов
    private Array finalMatr; // итоговая матрица класса массивов
    private int sum; // сумма элементов исходной матрицы

    // ОБЪЯВЛЕНИЕ КОНСТРУКТОРОВ

    public ArrayOperations() { // исходная матрица будет пустой
        this.originalMatr = new Array();
    }

    public ArrayOperations(Array originalMatr) { // исходная матрица = исх матрице
        this.originalMatr = originalMatr;
    }

    // ОБЪЯВЛЕНИЕ МЕТОДОВ
    // задача A
    public void countSum() {
        sum = 0;
        int[][] data = originalMatr.getData(); // массив с данными имеет данные исходной матрицы
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j];
            }
        }
    }

    public void createFinalMatr() {
        int[][] originalData = originalMatr.getData(); // есть исходная матрица с уже заданными данными
        int[][] finalData = new int[originalData.length][originalData[0].length]; // создаем итоговую матрицу, размером как исходная
        for (int i = 0; i < originalData.length; i++) {
            for (int j = 0; j < originalData[i].length; j++) {
                finalData[i][j] = originalData[i][j] * sum;
            }
        }
        finalMatr = new Array(finalData);
    }

    // задача B
    public void moveZeros() {
        int[][] originalData = originalMatr.getData(); // исходная матрица с заданными данными
        int[][] dataCopy = new int[originalData.length][originalData[0].length];

        // Копируем данные из originalData в dataCopy, чтобы не изменять исходную матрицу
        for (int i = 0; i < originalData.length; i++) {
            System.arraycopy(originalData[i], 0, dataCopy[i], 0, originalData[i].length);
        }

        // Выполняем сдвиг нулей в dataCopy
        for (int i = 0; i < dataCopy.length; i++) {
            int index = 0;
            for (int j = 0; j < dataCopy[i].length; j++) {
                if (dataCopy[i][j] != 0) {
                    dataCopy[i][index] = dataCopy[i][j];
                    index++;
                }
            }
            while (index < dataCopy[i].length) {
                dataCopy[i][index] = 0;
                index++;
            }
        }

        // Создаем итоговую матрицу на основе копии данных
        finalMatr = new Array(dataCopy);
    }
    //задача С
    public int[] transformationToOne()
    {
        int[][] twoMatr = originalMatr.getData();
        int s = twoMatr.length * twoMatr[0].length; // размер одномерного массива
        int[] oneMatr = new int[s]; // одномерный массив с длиной s
        int index = 0;

        System.out.println("Исходная матрица:");
        for (int i = 0; i < twoMatr.length; i++) {
            for (int j = 0; j < twoMatr[i].length; j++) {
                int value = twoMatr[i][j];
                oneMatr[index++] = value;
                System.out.print(value + " ");
            }
            System.out.println();
        }

        return oneMatr;
    }

    public void sort(int[] oneMatr)
    {
        int s = oneMatr.length;
        for (int i = 0; i < s - 1; i++) {
            for (int j = 0; j < s - i - 1; j++) {
                if (oneMatr[j] > oneMatr[j + 1]) {
                    int temp = oneMatr[j];
                    oneMatr[j] = oneMatr[j + 1];
                    oneMatr[j + 1] = temp;
                }
            }
        }
    }

    public void printArray(int[] array) {
        System.out.println("Итоговый массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void printResult(Array originalMatr, Array resultMatr) {
        System.out.println("Исходная матрица:");
        originalMatr.print();
        System.out.println("Итоговая матрица:");
        resultMatr.print();
    }

    public Array getFinalMatr() {
        return finalMatr;
    }
}

class TextAnalysis {

    // Метод для задачи D
    public static void taskD(String sentence) {
        String[] words = splitSentence(sentence);
        int[] lengths = createLengthArray(words);
        int[] maxMinIndexes = findMaxMinIndexes(lengths);
        int result = calculateWordsBetween(maxMinIndexes);
        System.out.println("Результат: " + result);
    }

    // Разбивает строку на слова
    public static String[] splitSentence(String sentence) {
        return sentence.split(" ");
    }

    // Создает массив, содержащий длины слов
    public static int[] createLengthArray(String[] words) {
        int[] lengths = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lengths[i] = words[i].length();
        }
        return lengths;
    }

    // Находит индексы самого длинного и самого короткого слова
    public static int[] findMaxMinIndexes(int[] lengths) {
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 1; i < lengths.length; i++) {
            if (lengths[i] > lengths[maxIndex]) {
                maxIndex = i;
            }
            if (lengths[i] < lengths[minIndex]) {
                minIndex = i;
            }
        }
        return new int[]{maxIndex, minIndex};
    }

    // Вычисляет количество слов между самым длинным и самым коротким словом
    public static int calculateWordsBetween(int[] maxMinIndexes) {
        int maxIndex = maxMinIndexes[0];
        int minIndex = maxMinIndexes[1];
        if (maxIndex == minIndex) { // Если индексы равны, значит слова одинаковой длины
            return 0;
        } else {
            return Math.abs(maxIndex - minIndex) - 1; // Количество слов между ними
        }
    }
}
