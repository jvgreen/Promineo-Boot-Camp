package com.promineo.week4;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
            Part 1 - 3
         */
        List<String> employeeNames = new ArrayList<>();
	    Set<Integer> ids = new HashSet<>();
        Map<Integer, String> employeeMap = new HashMap<>();

        /*
            Part 4
         */
        populateEmployeeNames(employeeNames);
        populateIds(ids);

        /*
            Parts 5 & 6
         */
        populateEmployeeMap(employeeNames, ids, employeeMap);
        displayEmployeeMap(employeeMap);

        /*
            Parts 7 & 8 & 9
         */
        StringBuilder idsBuilder = new StringBuilder();
        buildIdsString(idsBuilder, ids);
        System.out.println(idsBuilder.toString());

        /*
            Parts 10 & 11 & 12
         */
        StringBuilder namesBuilder = new StringBuilder();
        buildNamesString(namesBuilder, employeeNames);
        System.out.println(namesBuilder.toString());
    }

    /*
        BUILD NAMES STRING
     */
    private static void buildNamesString(StringBuilder namesBuilder, List<String> employeeNames) {
        for (String name : employeeNames) {
            namesBuilder.append(name).append(" ");
        }
    }

    /*
        BUILD IDS STRING
     */
    private static void buildIdsString(StringBuilder idsBuilder, Set<Integer> ids) {
        int i = 0;
        for (int id : ids) {

            idsBuilder.append(id);

            if (i++ != ids.size() - 1) { // Check to see if we are at the last element if so don't add "-"
                idsBuilder.append("-");
            }
        }
    }

    /*
        DISPLAY EMPLOYEE MAP
     */
    private static void displayEmployeeMap(Map<Integer, String> employeeMap) {
        Set<Integer> employeeIds = employeeMap.keySet();
        for (int employeeId : employeeIds) {
            System.out.println(employeeId + ": " + employeeMap.get(employeeId));
        }
    }

    /*
        POPULATE EMPLOYEE MAP
     */
    private static void populateEmployeeMap(List<String> employeeNames,
                                            Set<Integer> ids, Map<Integer, String> employeeMap) {
        int i = 0;
        for(int id : ids) {
            employeeMap.put(id, employeeNames.get(i));
            i++;
        }
    }

    /*
        POPULATE IDS
     */
    private static void populateIds(Set<Integer> ids) {
        ids.add(101);
        ids.add(202);
        ids.add(303);
        ids.add(404);
        ids.add(505);
    }

    /*
        POPULATE EMPLOYEE NAMES
     */
    private static void populateEmployeeNames(List<String> employeeNames) {
        employeeNames.add("John");
        employeeNames.add("Jill");
        employeeNames.add("Don");
        employeeNames.add("Ray");
        employeeNames.add("Matt");
    }
}
