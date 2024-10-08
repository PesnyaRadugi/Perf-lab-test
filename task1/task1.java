public class task1 {

    public static void main(String[] args) {
        // Чтение аргументов командной строки
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        StringBuilder path = new StringBuilder();
        
        int currentIndex = 1;

        for (int i = 0; i < n; i++) {
            if (currentIndex == 0) { // Если остаток %n == 0 значит остановились на числе n
                path.append(n);
            } else {
                path.append(currentIndex);
            }

            /*
             * m-1 потому, что на каждом интервале мы занимаем 1 элемент
             * под конечный элемент предыдущего и добавляем m-1 новых элементов
             */
            currentIndex = (currentIndex + m - 1) % n;

            // Прерываем, если пришли в единицу
            if (currentIndex == 1) {
                break;
            }
        }
        System.out.println(path.toString());
    }
}