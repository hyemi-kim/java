package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        OrderManagementSystem orderManagementSystem = new OrderManagementSystem();
        System.out.println("주문정보를 저장할 파일명을 입력해 주세요");

        orderManagementSystem.setFileName(scanner.nextLine());

        while(flag){
            System.out.println("메뉴를 선택해주세요.\n"
                + "1. 새로운 주문정보 저장\n"
                + "2. 기존 주문정보 처리\n"
                + "3. 주문ID로 주문정보 조회\n"
                + "4. 주문 정보 전체조회\n"
                + "5. 주문ID로 배송처리 하기\n"
                + "6. 나가기.."
            );
            int selected = scanner.nextInt();
            switch(selected){
                case 1 :
                    System.out.println("주문ID와 상품ID를 공백으로 구분하여 입력해주세요.");
                    orderManagementSystem.addOrder(scanner.nextInt(),scanner.nextInt());
                    break;
                case 2 :
                    orderManagementSystem.processOrder();
                    break;
                case 3:
                    System.out.println("주문ID를 입력해주세요.");
                    orderManagementSystem.printOrderInformationByOrderID(scanner.nextInt());
                    break;
                case 4:
                    orderManagementSystem.listAllOrderInformationList();
                    break;
                case 5:
                    System.out.println("주문ID를 입력해주세요.");
                    orderManagementSystem.logisticsProcess(scanner.nextInt());
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("다시 입력하세요.......");
            }
        }
    }
}
