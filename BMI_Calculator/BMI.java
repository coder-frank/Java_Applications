package BMI_Calculator;

import java.util.Scanner;

public class BMI {
    
    public static void main(String [] args)
    {
        System.out.println("Welcome to BMI Calculator");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your weight in Kilograms(KG):");
        double weight = sc.nextDouble();
        System.out.println("Enter your height in Meters(M):");
        double height = sc.nextDouble();
        sc.close();

        double bmi = weight / (Math.pow(height, 2));
        String result;

        if (bmi < 18.5)
        {
            result = "Underweight";
        } else if (bmi > 18.5 && bmi <= 24.9)
        {
            result = "Healthy Weight";
        } else if (bmi >= 25 && bmi <= 29.9)
        {
            result = "Overweight";
        } else {
            result = "Obese";
        }

        System.out.println("Your result came back:" + bmi);
        System.out.println("This is considered " + result);
    }
}
