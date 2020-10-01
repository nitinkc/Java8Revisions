package com.nitin.transactions.runner;

import com.nitin.transactions.ReadTransactionsCsv;
import com.nitin.transactions.entity.Transaction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Created by nichaurasia
 * @create on Wednesday, September/30/2020 at 10:26 PM
 */

public class TransactionGroup {
    public static void main(String[] args) {
        List<Transaction> transactions = ReadTransactionsCsv.getData();

        System.out.println("**************************************************************");
        System.out.println("Get sum of all the Tx's in each city using maptoDouble");
        //Map<String, Double> mapCitySum =
        transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCity,
                        Collectors.summingDouble(Transaction::getValue)))
                .entrySet().forEach(System.out::println);

        System.out.println("**************************************************************");
        System.out.println("Get sum of all the Tx's in each currency");
        //Map<String, Double> mapCitySum =
        transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency,
                        Collectors.summingDouble(Transaction::getValue)))
                .entrySet().forEach(System.out::println);

        System.out.println("**************************************************************");
        System.out.println("Get sum of all the Tx's of each type");
        //Map<String, Double> mapCitySum =
        transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType,
                        Collectors.summingDouble(Transaction::getValue)))
                .entrySet().forEach(System.out::println);
    }
}
