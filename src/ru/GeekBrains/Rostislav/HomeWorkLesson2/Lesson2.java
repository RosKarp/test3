package ru.GeekBrains.Rostislav.HomeWorkLesson2;

public class Lesson2 {

    public static void main(String[] args)
    {
        //ДЗ п.1
        int[] array0and1 = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for(int i=0; i<10; i++)
        {
            if(array0and1[i] == 0)
            {
                array0and1[i] = 1;
            } else
                array0and1[i] = 0;
        }
        System.out.println("п.1 Массив после замены 0 на 1, 1 на 0:");
        System.out.print("{");
        for (int j=0; j< array0and1.length -1; j++)
        {
            System.out.print(array0and1[j] + ", ");
        }
        System.out.println(array0and1[array0and1.length-1] + "}");
        System.out.println();

        //ДЗ п.2
        int[] array2 = new int[8];
        for(int i=0; i< array2.length; i++)
        {
            array2[i] = i*3;
        }
        System.out.println("п.2 Заполненный массив:");
        System.out.print("{");
        for (int j=0; j< array2.length -1; j++)
        {
            System.out.print(array2[j] + ", ");
        }
        System.out.println(array2[array2.length-1] + "}");
        System.out.println();

        //ДЗ п.3
        int[] array3 = new int[] {1,5,3,2,11,4,5,2,4,8,9,1};
        for(int i=0; i < array3.length; i++)
        {
            if(array3[i]<6) {
                array3[i] = array3[i] * 2;
            }
        }
        System.out.println("п.3 Заполненный массив (числа меньше 6 умножили на 2):");
        System.out.print("{");
        for (int j=0; j< array3.length -1; j++)
        {
            System.out.print(array3[j] + ", ");
        }
        System.out.println(array3[array3.length-1] + "}");
        System.out.println();

        //ДЗ п.4
        int n = 10;  //размерность массива n x n
        int[][] array4 = new int[n][n];
        for(int i=0; i<n; i++)
        {
            array4[i][i] = 1;    //заполнение диагональных элементов
            array4[i][n-1-i] = 1;
        }
        System.out.println("п.4 Заполненный массив:");
        for (int j=0; j< array4.length ; j++)
        {
            for (int i = 0; i < array4[j].length; i++)
            {
                System.out.print(array4[j][i] + "   ");
            }
            System.out.println();
        }
        System.out.println();

        //ДЗ п.5
        System.out.println("п.5 Максимальное и минимальное число в массиве.");
        double[] array5 = new double[] {-5.589, 3.264, 482.237, -26.12, 64.2, 8.1, -30.3485};
        for (int j=0; j< array5.length ; j++)
        {
            int count = 0;
            for (int i=0; i < array5.length; i++)
            {
                if (array5[j] <= array5[i] )
                {
                    count++;
                }
                if (count == array5.length)
                {
                    System.out.println("      Минимальное число  " + array5[j]);
                }
            }
        }

        for (int j=0; j< array5.length ; j++)
        {
            int count = 0;
            for (int i=0; i < array5.length; i++)
            {
                if (array5[j] >= array5[i] )
                {
                    count++;
                }
                if (count == array5.length)
                {
                    System.out.println("      Максимальное число  " + array5[j]);
                }
            }
        }
        System.out.println();

        //ДЗ п.6
        int[] checkBalance = new int[] {4,5,9,-10,15,3,8,6,7,-1};
        System.out.println("п.6 В переданном массиве есть место между элементами, где сумма левой части равна сумме правой части");
        System.out.println(arrayBalance(checkBalance));
        System.out.println();

        //ДЗ п.7
        double[] array7 = new double[] {1.6,2.1,3.8,4.7,5.3,6.2,7.9,8.3,9.1,10.6};
        int m = -77;
        moveRoundArrayAt_n(array7, m);
        System.out.println("п.7 Элементы массива сдвигаются на " + m + " позиций(-ии)");
        System.out.print("{");
        for (int j=0; j< array7.length -1; j++)
        {
            System.out.print(array7[j] + ", ");
        }
        System.out.println(array7[array7.length-1] + "}");
        System.out.println();

    }

    //ДЗ п.6
    public static boolean arrayBalance (int[] checkBalance)
    {
        int[] rightSide = new int[checkBalance.length - 1]; //массив для правой половины checkBalance
        rightSide[0] = checkBalance[1];
        int[] leftSide = new int[checkBalance.length-1];  //массив для левой половины checkBalance
        leftSide[0]= checkBalance[0];
        if (checkBalance.length == 2) //случай двух элементов в массиве
        {
            return leftSide[0] == rightSide[0];
        }
        for (int i = 1; i < checkBalance.length-1; i++)
        {
            rightSide[i] = rightSide[i-1]+checkBalance[i+1]; // сумма правых элементов checkBalance, кроме 1-го
        }
        if(checkBalance[0] == rightSide[checkBalance.length-2]) //если 1-й элемент равен сумме последующих
        {
            return true;
        }
        else
            rightSide[1] = rightSide[checkBalance.length-2] - checkBalance[1];
            for(int j=1; j < checkBalance.length - 2; j++ )
            {
                leftSide[j] = leftSide[j-1]+checkBalance[j]; // заполнение leftSide[j] суммой элементов checkBalance до j
                rightSide[j+1] = rightSide[j] - checkBalance[j+1]; // заполнение rightSide[j] суммой элементов checkBalance после j
            }
            leftSide[checkBalance.length-2] = leftSide[checkBalance.length - 3]+checkBalance[checkBalance.length - 2]; //вычисление последнего элемента leftSide
            for(int h = 1; h < checkBalance.length-1; h++)
            {
                if (leftSide[h] == rightSide[h]) // сравнение сумм левой и правой части для всех вариантов разделений
                {
                    return true;
                }
            }
            return false;
    }

    //ДЗ п.7
    public static void moveRoundArrayAt_n(double[] array, int n)
    {
        if(n >= 0)
        {
            for (int j = 0; j < n; j++)
            {
                double buffer = array[array.length - 1];
                for (int i = array.length - 2; i >= 0; i--)
                {
                    array[i + 1] = array[i];
                }
                array[0] = buffer;
            }
        }
        else
            for (int j = 0; j < -n; j++)
            {
                double buffer = array[0];
                for (int i = 0; i <= array.length - 2; i++)
                {
                    array[i] = array[i+1];
                }
                array[array.length - 1] = buffer;
            }
    }

}
