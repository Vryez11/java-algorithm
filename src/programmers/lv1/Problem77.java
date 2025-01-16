package src.programmers.lv1;

public class Problem77 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] leftIndex = {0, 3};
        int[] rightIndex = {2, 3};

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                leftIndex[0] = 0;
                leftIndex[1] = switch (number) {
                    case 1 -> 0;
                    case 4 -> 1;
                    default -> 2;
                };
                answer += "L";
            } else if (number == 3 || number == 6 || number ==9) {
                rightIndex[0] = 2;
                rightIndex[1] = switch (number) {
                    case 3 -> 0;
                    case 6 -> 1;
                    default -> 2;
                };
                answer += "R";
            } else {
                int leftdistance;
                int rigthdistance;

                if (number == 2) {
                    leftdistance = Math.abs(leftIndex[0] - 1) + Math.abs(leftIndex[1]);
                    rigthdistance = Math.abs(rightIndex[0] - 1)+ Math.abs(rightIndex[1]);

                    if (leftdistance < rigthdistance) {
                        answer += "L";
                        leftIndex[0] = 1;
                        leftIndex[1] = 0;
                    } else if (leftdistance > rigthdistance) {
                        answer += "R";
                        rightIndex[0] = 1;
                        rightIndex[1] = 0;
                    } else {
                        if (hand.equals("right")) {
                            answer += "R";
                            rightIndex[0] = 1;
                            rightIndex[1] = 0;
                        } else {
                            answer += "L";
                            leftIndex[0] = 1;
                            leftIndex[1] = 0;
                        }
                    }
                } else if (number == 5) {
                    leftdistance = Math.abs(leftIndex[0] - 1) + Math.abs(leftIndex[1] - 1);
                    rigthdistance = Math.abs(rightIndex[0] - 1)+ Math.abs(rightIndex[1] - 1);;

                    if (leftdistance < rigthdistance) {
                        answer += "L";
                        leftIndex[0] = 1;
                        leftIndex[1] = 1;
                    } else if (leftdistance > rigthdistance) {
                        answer += "R";
                        rightIndex[0] = 1;
                        rightIndex[1] = 1;
                    } else {
                        if (hand.equals("right")) {
                            answer += "R";
                            rightIndex[0] = 1;
                            rightIndex[1] = 1;
                        } else {
                            answer += "L";
                            leftIndex[0] = 1;
                            leftIndex[1] = 1;
                        }
                    }
                } else if (number == 8) {
                    leftdistance = Math.abs(leftIndex[0] - 1) + Math.abs(leftIndex[1] - 2);
                    rigthdistance = Math.abs(rightIndex[0] - 1)+ Math.abs(rightIndex[1] - 2);;

                    if (leftdistance < rigthdistance) {
                        answer += "L";
                        leftIndex[0] = 1;
                        leftIndex[1] = 2;
                    } else if (leftdistance > rigthdistance) {
                        answer += "R";
                        rightIndex[0] = 1;
                        rightIndex[1] = 2;
                    } else {
                        if (hand.equals("right")) {
                            answer += "R";
                            rightIndex[0] = 1;
                            rightIndex[1] = 2;
                        } else {
                            answer += "L";
                            leftIndex[0] = 1;
                            leftIndex[1] = 2;
                        }
                    }
                } else if (number == 0) {
                    leftdistance = Math.abs(leftIndex[0] - 1) + Math.abs(leftIndex[1] - 3);
                    rigthdistance = Math.abs(rightIndex[0] - 1)+ Math.abs(rightIndex[1] - 3);;

                    if (leftdistance < rigthdistance) {
                        answer += "L";
                        leftIndex[0] = 1;
                        leftIndex[1] = 3;
                    } else if (leftdistance > rigthdistance) {
                        answer += "R";
                        rightIndex[0] = 1;
                        rightIndex[1] = 3;
                    } else {
                        if (hand.equals("right")) {
                            answer += "R";
                            rightIndex[0] = 1;
                            rightIndex[1] = 3;
                        } else {
                            answer += "L";
                            leftIndex[0] = 1;
                            leftIndex[1] = 3;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
