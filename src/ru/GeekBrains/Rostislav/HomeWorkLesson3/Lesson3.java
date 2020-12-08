package ru.GeekBrains.Rostislav.HomeWorkLesson3;

import java.util.Scanner;

public class Lesson3
{
    public static void main ( String[] args)
    {
        /*
        Определение массива вариантов (ниже можно заменить и/или добавить элементы)
         */
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String answerUser; // переменная для ответа пользователя
        String hiddenFood = words[(int)(Math.random() * words.length)]; // загаданное компьютером слово
        System.out.println("Загадано одно из следующих слов:");
        for(int j = 0; j < words.length; j++) // вывод списка слов
            {
                System.out.println(words[j] + ", ");
            }
        System.out.println("угадайте какое?");
        Scanner scan = new Scanner(System.in);

        for(;;) // неограниченное число попыток угадать слово
            {
                answerUser = scan.nextLine(); // ввод в консоль ответа пользователя
                int h = 0; // переменная для перебора букв в ответе
                if(hiddenFood.equals(answerUser)) // сравнение с загаданным словом
                    {
                    System.out.println("Вы выиграли!!!");
                    break;
                    }
                else
                    System.out.println("Показаны совпадающие буквы");
                do
                    {
                    if(hiddenFood.charAt(h) == answerUser.charAt(h)) // побуквенное сравнение ответа
                        {
                        System.out.print(hiddenFood.charAt(h)); // печать совпадающих букв
                        }
                    else
                        System.out.print("#"); // печать при несовпадении букв
                    h += 1;
                    }
                /*
                Цикл, пока не закончатся буквы в ответе или загаданном слове
                 */
                while (h < hiddenFood.length() && h < answerUser.length());
                while (h < 15) // доводим число символов в подсказке до 15
                {
                    System.out.print("#");
                    h += 1;
                }
                System.out.println();
                System.out.println("Попробуйте еще раз!");
            }
    }

}
