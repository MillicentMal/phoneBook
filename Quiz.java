package phoneBook;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Quiz {
    public static void quiz_runner (String questions[], String answers[][], int correct_answers[])  throws InputMismatchException {
        String response = "y";
        boolean keepPlaying = true;
        while (keepPlaying == true) {
            for (int i = 0; i < questions.length; i++) {
                System.out.println(questions[i]);
                for (int j =0; j < 5; j++){
                    System.out.println(answers[i][j]);
                }
                long startTime = System.nanoTime();
   // ... the code being measured ...
   
                Scanner user_answer = new Scanner(System.in); //System.in is a standard input stream  
                System.out.print("Do you want to keep playing? ");  
                int ans = user_answer.nextInt();
                long estimatedTime = System.nanoTime() - startTime;
                long timetaken = TimeUnit.SECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS);

                if (ans == correct_answers[i]) {
                    System.out.println("Well Done. That is correct");
                }
                else if (ans != correct_answers[i]){
                    System.out.println("Wrng answer. Keep playing");
                }
                else {
    
                }
                System.out.println("You took " + timetaken);

                Scanner user_response = new Scanner(System.in); //System.in is a standard input stream  
                System.out.print("Do you want to keep playing? ");  
                String str1= user_response.nextLine();  
                if (str1.toLowerCase() == response){
                    keepPlaying = true;
                } 
                else if (str1.toLowerCase() != response){
                    keepPlaying = false;
                    System.out.println("Thank you for playing");     
                          }
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