 import java.util.Scanner;
 import java.util.Random;
 
public class Main
{
    public static void main(String[] args)//основна функція для роботи програми
    {   
        final int beginningNumber = -1;//початкове потенційно введене число за замовчуванням
        System.out.println("Input your name");
        Scanner scan = new Scanner(System.in);//змінна класу Scanner,котра буде використовуватись для введеня ім'я/числа(року)
        String name = scan.nextLine();//вводимо ім'я гравця
        Random random = new Random();//змінна класу Random,що буде використовуватись для генерації псевдовипадквого числа
        String[][] events = { //матриця дат і подій
         {"1914","World War I began"},
         {"1929","Great Depression crisis happend"},
         {"1932","Holodomor happened"},
         {"1939", "World War II began"},
         {"1945","World War II ended"},
         {"1962","Cuban missle crisis"},
         {"1969", "Man landed on the moon"},
         {"1974","Watergate scandal happend"},
         {"1986", "Chernobyl disaster happened"},
         {"1991", "Ukraine returned it's independence"},
         {"2001", "9/11 terrorist attacks occurred"},
         {"2008","Global financial crisis happend"},
         {"2014","War in Donbass began"},
         {"2022","russian full-scale invasion into Ukraine began"},
         {"2024","Paris olympic games took place"}
     };
        int eventIndex = random.nextInt(events.length);//загадуємо подію за індексом в матриці
        int correctYear = Integer.parseInt(events[eventIndex][0]);//загадуємо рік події
        String eventDescription = events[eventIndex][1];//загадуємо опис події
        System.out.println("Let the game begin! You need to guess the year of the following event:");
        System.out.println("When did " + eventDescription + "?");
        int playerNumber = beginningNumber;
        int[] inputtedNumbers=new int[1];//створюємо масив,котрий буде зберігати введені числа
        do {
             
             boolean flag = false;
             do 
             {
             try 
             {
                System.out.println("Input some number");
                scan = new Scanner(System.in);
                playerNumber = scan.nextInt();
             } catch (Exception e) //перевіряємо чи гравець ввів число
             {
               System.out.println("You entered not a number.Please be more accurate.");
               playerNumber = beginningNumber;
             }finally
             {
               if(playerNumber != beginningNumber)
               {
                flag = true;
               }
             }
             } while (flag==false);
             
             //визначаємо "положення" введеного числа(дати) відносно загаданої
             if(playerNumber>correctYear)
                System.out.println("Your number is too big. Please, try again.");//потрібно зменшити число
             else if(playerNumber<correctYear)
                System.out.println("Your number is too small. Please, try again.");//потрібно збільшити число
             else if(playerNumber==correctYear)
                System.out.println("Congratulations, " +name+"!You guessed the correct year: " + correctYear);//число вгадано
                if(inputtedNumbers.length==1 && inputtedNumbers[0]==0)
                  inputtedNumbers[0]=playerNumber;
                else
                 inputtedNumbers=rechangeArray(inputtedNumbers,playerNumber);
        } while (playerNumber!=correctYear);
        scan.close(); 
        showArray(inputtedNumbers);//показуємо введені числа
    }
    
    public static int[] sorting(int[] arr)//метод,що сортує масив введених чисел за алгоритмом бульбашки 
    {
       for(int i=0;i<arr.length-1;i++)
        {
            for(int j =i+1;j<arr.length;j++)
          {
            if(arr[i]>arr[j])
                continue;
            else if(arr[i]<arr[j])
           {
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
           }
          }
        }
          return arr;
    }

    public static int[] rechangeArray(int[] arr,int newNumber)//метод додавання нового введеного числа,відповідно до продовження ходу гри
    {
       int[] newArr = new int[arr.length+1];
       int counter = 0;
       for (int i : arr) 
       {
          newArr[counter]=i;
          counter++;
       }
       newArr[arr.length]=newNumber;
       return newArr;
    }

    public static void showArray(int[] arr)//метод показу масиву
    {   arr=sorting(arr);
        System.out.println("Your numbers: ");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}