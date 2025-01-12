package src.programmers.lv1;

public class Problem53 {

    public int solution(int[] wallet, int[] bill) {

        int count = 0;
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        int billMax = Math.max(bill[0], bill[1]);
        int billMin = Math.min(bill[0], bill[1]);

        while (!(walletMax >= billMax && walletMin >= billMin)) {
            count++;
            int temp = billMax / 2;
            billMax = Math.max(temp, billMin);
            billMin = Math.min(billMin, temp);
            System.out.println("billMax, billMin: " + billMax + ", " + billMin);
        }

        return count;
    }


}
