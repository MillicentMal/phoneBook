

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Quiz {
    public static void quiz_runner (String questions[], String answers[][], int correct_answers[])  throws InputMismatchException {
        System.out.println("Welcome to the general knowledge quiz.");
        boolean keepPlaying = true;
        int i = 0;
        while (keepPlaying == true) {
            if (i == questions.length) {
                i = 0;
            }
            System.out.println(questions[i]);

            for (int j =0; j < 5; j++){
            System.out.println(answers[i][j]);
            }
            long startTime = System.nanoTime();
   // ... the code being measured ...
   
            Scanner user_answer = new Scanner(System.in); //System.in is a standard input stream  
            System.out.print("What is your answer?");  
            int ans = user_answer.nextInt();
            long estimatedTime = System.nanoTime() - startTime;
            long timetaken = TimeUnit.SECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS);

            if (ans == correct_answers[i]) {
                System.out.println("Well Done. That is correct");
            }
            else if (ans != correct_answers[i]){
                System.out.println("Wrng answer. Sorry!");
            }
            System.out.println("You took " + timetaken + " seconds to answer.");
            Scanner user_response = new Scanner(System.in);
                System.out.print("Do you want to keep playing? Answer 1 for yes and 0 for no. ");  
                int str1= user_response.nextInt();  
                if (str1 == 1){
                    keepPlaying = true;
                    if ( i == questions.length - 1){
                    i = 0;
                    }
                    else {
                        i++;
                    }
                } 
                else {
                    System.out.println("Thank you for playing, see you!");   
                    break; 
                            }
            }
            }


    public static void main( String[] args) {
        String questions [] = {
            "Who is the president of Rwanda?", "Who founded ALU?"
        };
        String answers [][] = { {"1: Paul Kagame", "2: Cyril Ramaphosa", "3: Jack Russell", "4: Museveni", "5: Eric Wayene"}, 
        {
            "1: Apple Joseph", "2: Steve Apple", "3: Steve Jobs", "4: Tim Cook", "5: Jack Daniels"
        }

        };
        int correct_answers [] = {
            1, 3
        };
            try {
            quiz_runner(questions, answers, correct_answers);
                       }
            catch 
                (Exception e) {
                    e.printStackTrace();
            }
    }
    }