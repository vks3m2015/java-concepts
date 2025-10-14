package java8.streams.programs;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//We have list of Invoices. Find sum of total amount per date
public class InvoiceSumAmount {


    public static void main(String[] args) {

        List<Invoice> invoices = List.of(
                new Invoice("INV001", LocalDate.of(2025, 10, 1), 500.0),
                new Invoice("INV002", LocalDate.of(2025, 10, 1), 300.0),
                new Invoice("INV003", LocalDate.of(2025, 10, 2), 200.0),
                new Invoice("INV004", LocalDate.of(2025, 10, 3), 100.0),
                new Invoice("INV005", LocalDate.of(2025, 10, 2), 700.0)
        );

        // Group by date and sum amount
        Map<LocalDate, Double> totalPerDate = invoices.stream()
                .collect(Collectors.groupingBy(
                        Invoice::getDate,
                        //Collectors.summingDouble(Invoice::getAmount)
                        Collectors.summingDouble(Invoice::getAmount)
                ));

        // Print result
        totalPerDate.forEach((date, total) ->
                System.out.println(date + " -> " + total));


        //Find invoices which are less than 30 days old
        LocalDate today = LocalDate.now();

        List<Invoice> recentInvoices = invoices.stream()
                .filter(inv -> inv.getDate().isAfter(today.minusDays(30)))
                .collect(Collectors.toList());
        recentInvoices.forEach(System.out::println);
    }

    @Getter
    private static class Invoice {
        private String id;
        private LocalDate date;
        private double amount;
        // constructor, getters, setters
        public Invoice(String id, LocalDate date, double amount) {
            this.id = id;
            this.date = date;
            this.amount = amount;
        }

    }
}




