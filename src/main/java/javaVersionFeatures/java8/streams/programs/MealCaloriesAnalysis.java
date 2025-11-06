package javaVersionFeatures.java8.streams.programs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

//You have a list of meals (each representing a meal by a user), and you want to find
// how many distinct users have total calories (summed per month) greater than a given threshold.
//Result like -
/*
Users above threshold per month:
2022-9 -> 1 users
2022-10 -> 2 users

 */

//TOPTAL interview question
public class MealCaloriesAnalysis {

    static class Meal {
        int id;
        String userId;
        double calories;
        LocalDate dateConsumed;

        public Meal(int id, String userId, double calories, String dateConsumed) {
            this.id = id;
            this.userId = userId;
            this.calories = calories;
            this.dateConsumed = LocalDate.parse(dateConsumed, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        public String getUserId() {
            return userId;
        }

        public double getCalories() {
            return calories;
        }

        public LocalDate getDateConsumed() {
            return dateConsumed;
        }
    }

    public static void main(String[] args) {
        List<Meal> meals = List.of(
                new Meal(1, "18", 383, "2022-09-25"),
                new Meal(2, "18", 500, "2022-09-27"),
                new Meal(3, "19", 700, "2022-09-15"),
                new Meal(4, "20", 200, "2022-10-05"),
                new Meal(5, "18", 1000, "2022-10-07"),
                new Meal(6, "19", 1500, "2022-10-15")
        );

        double threshold = 1000.0; // calories limit
        Map<String, Long> result = findUsersAboveCaloriesByMonth(meals, threshold);

        System.out.println("Users above threshold per month:");
        result.forEach((month, count) -> System.out.println(month + " -> " + count + " users"));
    }

    public static Map<String, Long> findUsersAboveCaloriesByMonth(List<Meal> meals, double threshold) {

        // Step 1: Group by (month, user)
        Map<String, Map<String, Double>> caloriesPerUserPerMonth = meals.stream()
                .collect(Collectors.groupingBy(
                        meal -> meal.getDateConsumed().getYear() + "-" + meal.getDateConsumed().getMonthValue(),
                        Collectors.groupingBy(
                                Meal::getUserId,
                                Collectors.summingDouble(Meal::getCalories)
                        )
                ));

        // Step 2: For each month, count users whose total calories > threshold
        Map<String, Long> usersAboveThresholdPerMonth = new TreeMap<>();

        caloriesPerUserPerMonth.forEach((month, userCalories) -> {
            long count = userCalories.values().stream()
                    .filter(total -> total > threshold)
                    .count();
            usersAboveThresholdPerMonth.put(month, count);
        });

        return usersAboveThresholdPerMonth;
    }
}

